package org.igsq.igsqbot.commands.commands.misc;

import info.debatty.java.stringsimilarity.JaroWinkler;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.Permission;
import net.dv8tion.jda.api.entities.*;
import net.dv8tion.jda.api.events.message.guild.react.GuildMessageReactionAddEvent;
import org.igsq.igsqbot.Constants;
import org.igsq.igsqbot.IGSQBot;
import org.igsq.igsqbot.commands.subcommands.verification.VerificationAddCommand;
import org.igsq.igsqbot.commands.subcommands.verification.VerificationRemoveCommand;
import org.igsq.igsqbot.commands.subcommands.verification.VerificationShowCommand;
import org.igsq.igsqbot.entities.Emoji;
import org.igsq.igsqbot.entities.command.Command;
import org.igsq.igsqbot.entities.command.CommandEvent;
import org.igsq.igsqbot.entities.command.CommandFlag;
import org.igsq.igsqbot.entities.database.GuildConfig;
import org.igsq.igsqbot.entities.exception.CommandException;
import org.igsq.igsqbot.entities.exception.CommandResultException;
import org.igsq.igsqbot.util.CommandChecks;
import org.igsq.igsqbot.util.Parser;
import org.igsq.igsqbot.util.UserUtils;
import org.igsq.igsqbot.util.VerificationUtils;

@SuppressWarnings("unused")
public class VerificationCommand extends Command
{
	public VerificationCommand()
	{
		super("Verification", "Handles verification of new members.", "[user] | [add | remove | show]");
		addAliases("verify", "verification", "accept");
		addFlags(CommandFlag.GUILD_ONLY);
		addMemberPermissions(Permission.MESSAGE_MANAGE);
		addSelfPermissions(Permission.MANAGE_ROLES);
		addChildren(
				new VerificationAddCommand(this),
				new VerificationShowCommand(this),
				new VerificationRemoveCommand(this));
	}

	@Override
	public void run(List<String> args, CommandEvent cmd, Consumer<CommandException> failure)
	{
		if(CommandChecks.argsEmpty(cmd, failure)) return;

		MessageChannel channel = cmd.getChannel();
		Guild guild = cmd.getGuild();
		Role verifiedRole = guild.getRoleById(new GuildConfig(cmd).getVerifiedRole());
		Role unverifiedRole = guild.getRoleById(new GuildConfig(cmd).getUnverifiedRole());

		if(CommandChecks.roleConfigured(verifiedRole, "Verified role", failure)) return;

		new Parser(args.get(0), cmd).parseAsUser(
				target ->
						UserUtils.getMemberFromUser(target, guild).queue(
								member ->
								{
									if(member.getRoles().contains(verifiedRole))
									{
										failure.accept(new CommandResultException("User " + target.getAsMention() + " is already verified."));
										return;
									}
									channel.getIterableHistory().takeAsync(10).thenAccept(
											input ->
											{

												List<Message> messages = filterMessages(input, target);

												if(messages.isEmpty())
												{
													failure.accept(new CommandResultException("No messages from " + target.getAsMention() + " were found in this channel."));
													return;
												}

												StringBuilder ctxMessage = new StringBuilder();
												StringBuilder welcomeMessage = new StringBuilder();

												List<Role> roles = getMatches(messages, cmd.getGuild(), cmd.getIGSQBot()).stream()
														.map(guild::getRoleById)
														.filter(Objects::nonNull)
														.collect(Collectors.toList());

												for(Role role : roles)
												{
													ctxMessage.append(role.getAsMention()).append("\n");
													welcomeMessage.append(role.getAsMention());
												}

												roles.addAll(member.getRoles());

												cmd.getChannel().sendMessage(new EmbedBuilder()
														.setTitle("Verification for " + target.getAsTag())
														.addField("Roles", ctxMessage.length() == 0 ? "No roles found" : ctxMessage.toString(), false)
														.setColor(Constants.IGSQ_PURPLE)
														.setTimestamp(Instant.now())
														.build()).queue(message ->
												{
													message.addReaction(Emoji.THUMB_UP.getAsReaction()).queue();
													cmd.getIGSQBot().getEventWaiter().waitForEvent(GuildMessageReactionAddEvent.class,
															event -> event.getMessageIdLong() == message.getIdLong() && event.getUserIdLong() == cmd.getAuthor().getIdLong(),
															event ->
															{
																message.delete().queue();
																channel.purgeMessages(messages);

																MessageChannel welcomeChannel = guild.getTextChannelById(new GuildConfig(cmd).getWelcomeChannel());
																if(welcomeChannel != null)
																{
																	welcomeChannel.sendMessage(new EmbedBuilder()
																			.setAuthor(target.getAsTag(), null, target.getEffectiveAvatarUrl())
																			.setDescription(target.getAsMention() + " has joined " + guild.getName() + ". Welcome!")
																			.addField("Roles", welcomeMessage.length() == 0 ? "No roles." : welcomeMessage.toString(), false)
																			.setColor(Constants.IGSQ_PURPLE)
																			.setTimestamp(Instant.now())
																			.build()).queue();
																}
																else
																{
																	cmd.replyError("Welcome channel not setup, no welcome message will be sent.");
																}

																roles.add(verifiedRole);
																if(unverifiedRole != null)
																{
																	roles.remove(unverifiedRole);
																}

																guild.modifyMemberRoles(member, roles).queue();

															},
															10000, TimeUnit.MILLISECONDS,
															() -> message.delete().queue());
												});
											});
								}));
	}

	private List<Message> filterMessages(List<Message> messages, User target)
	{
		return messages.stream().filter(message -> message.getAuthor().equals(target)).collect(Collectors.toList());
	}

	private List<Long> getMatches(List<Message> messages, Guild guild, IGSQBot igsqBot)
	{
		List<Long> result = new ArrayList<>();
		List<String> content = messages.stream().map(Message::getContentRaw).collect(Collectors.toList());

		Map<Long, String> mappings = VerificationUtils.getMappedPhrases(guild, igsqBot);
		JaroWinkler matcher = new JaroWinkler();

		mappings.forEach(
				(role, phrase) ->
				{
					for(String message : content)
					{
						if(phrase.contains(" "))
						{
							phrase = String.join(" ", phrase.split(" "));
						}
						if(matcher.similarity(phrase, message) > 0.8)
						{
							result.add(role);
						}
					}
				});
		return result;
	}

}

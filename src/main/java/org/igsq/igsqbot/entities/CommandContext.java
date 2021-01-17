package org.igsq.igsqbot.entities;

import java.util.List;
import java.util.Objects;
import java.util.Set;
import javax.annotation.Nonnull;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.Permission;
import net.dv8tion.jda.api.entities.*;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import org.igsq.igsqbot.Constants;
import org.igsq.igsqbot.IGSQBot;
import org.igsq.igsqbot.entities.database.GuildConfig;
import org.igsq.igsqbot.util.EmbedUtils;
import org.jooq.DSLContext;

public class CommandContext
{
	private final MessageReceivedEvent event;
	private final IGSQBot igsqBot;
	private final Command command;

	public CommandContext(MessageReceivedEvent event, IGSQBot igsqBot, Command command)
	{
		this.event = event;
		this.igsqBot = igsqBot;
		this.command = command;
	}

	public String getPrefix()
	{
		if(!isFromGuild())
		{
			return Constants.DEFAULT_BOT_PREFIX;
		}
		else
		{
			return new GuildConfig(this).getPrefix();
		}
	}

	public void addErrorReaction()
	{
		getMessage().addReaction(Emoji.FAILURE.getAsReaction()).queue();
	}

	public IGSQBot getIGSQBot()
	{
		return igsqBot;
	}

	public Command getCommand()
	{
		return command;
	}

	public MessageChannel getChannel()
	{
		return event.getChannel();
	}

	public Message getMessage()
	{
		return event.getMessage();
	}

	public Guild getGuild()
	{
		return event.isFromGuild() ? event.getGuild() : null;
	}

	public DSLContext getDBContext()
	{
		return getIGSQBot().getDatabaseHandler().getContext();
	}

	public User getAuthor()
	{
		return event.getAuthor();
	}

	public JDA getJDA()
	{
		return event.getJDA();
	}

	public boolean isChild()
	{
		return command.getParent() != null;
	}

	public ChannelType getChannelType()
	{
		return event.getChannelType();
	}

	public MessageReceivedEvent getEvent()
	{
		return event;
	}

	/**
	 * This member will not be null, due to previous checks
	 *
	 * @return the member for this context
	 */
	@Nonnull
	public Member getMember()
	{
		return Objects.requireNonNull(event.getMember());
	}

	public void replyError(String errorText)
	{
		EmbedUtils.sendError(getChannel(), errorText);
	}

	public void replySuccess(String successText)
	{
		EmbedUtils.sendSuccess(getChannel(), successText);
	}

	public boolean isDeveloper()
	{
		return List.of(igsqBot.getConfig().getString(ConfigOption.PRIVILEGEDUSERS).split(",")).contains(getAuthor().getId());
	}

	public boolean isFromGuild()
	{
		return event.isFromGuild();
	}

	public boolean hasPermission(List<Permission> permissions)
	{
		return event.getGuild().getSelfMember().hasPermission((GuildChannel) event.getChannel(), permissions) || (event.getMember() != null && event.getMember().hasPermission((GuildChannel) event.getChannel(), permissions));
	}

	public boolean hasPermission(Set<Permission> permissions)
	{
		return event.getGuild().getSelfMember().hasPermission((GuildChannel) event.getChannel(), permissions) || (event.getMember() != null && event.getMember().hasPermission((GuildChannel) event.getChannel(), permissions));
	}

	public boolean hasPermission(Permission... permissions)
	{
		return event.getGuild().getSelfMember().hasPermission((GuildChannel) event.getChannel(), permissions) || (event.getMember() != null && event.getMember().hasPermission((GuildChannel) event.getChannel(), permissions));
	}
}

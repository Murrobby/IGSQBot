package org.igsq.igsqbot.events.main;

import net.dv8tion.jda.api.entities.ChannelType;
import net.dv8tion.jda.api.entities.Role;
import net.dv8tion.jda.api.events.message.MessageDeleteEvent;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.events.message.react.MessageReactionAddEvent;
import net.dv8tion.jda.api.events.message.react.MessageReactionRemoveEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.igsq.igsqbot.entities.EventWaiter;
import org.igsq.igsqbot.entities.cache.CachedMessage;
import org.igsq.igsqbot.entities.cache.MessageCache;
import org.igsq.igsqbot.entities.json.Filename;
import org.igsq.igsqbot.entities.json.JsonGuild;
import org.igsq.igsqbot.entities.json.JsonGuildCache;
import org.igsq.igsqbot.entities.json.JsonReactionRole;
import org.igsq.igsqbot.entities.yaml.GuildConfig;
import org.igsq.igsqbot.handlers.CommandHandler;
import org.igsq.igsqbot.util.YamlUtils;

public class MessageEventsMain extends ListenerAdapter
{
	@Override
	public void onMessageReactionAdd(MessageReactionAddEvent event)
	{
		if(!EventWaiter.waitingOnThis(event) && event.isFromType(ChannelType.TEXT))
		{
			event.retrieveUser().queue(
					user ->
					{
						if(!user.isBot())
						{
							JsonGuild jsonGuild = JsonGuildCache.getInstance().get(event.getGuild().getId());
							JsonReactionRole jsonReactionRole = jsonGuild.getReactionRoles().get(event.getReactionEmote().isEmoji() ? event.getReactionEmote().getEmoji() : event.getReactionEmote().getEmote().getId());
							if(jsonReactionRole != null)
							{
								Role role = event.getGuild().getRoleById(jsonReactionRole.getPrimaryKey());
								if(role != null)
								{
									event.retrieveMember().queue(member -> event.getGuild().addRoleToMember(member, role).queue());
								}
							}
						}
					}
			);
		}
	}



	@Override
	public void onMessageReactionRemove(MessageReactionRemoveEvent event)
	{
		if(!EventWaiter.waitingOnThis(event) && event.isFromType(ChannelType.TEXT))
		{
			event.retrieveUser().queue(
					user ->
					{
						if(!user.isBot())
						{
							JsonGuild jsonGuild = JsonGuildCache.getInstance().get(event.getGuild().getId());
							JsonReactionRole jsonReactionRole = jsonGuild.getReactionRoles().get(event.getReactionEmote().isEmoji() ? event.getReactionEmote().getEmoji() : event.getReactionEmote().getEmote().getId());
							if(jsonReactionRole != null)
							{
								Role role = event.getGuild().getRoleById(jsonReactionRole.getPrimaryKey());
								if(role != null)
								{
									event.retrieveMember().queue(member -> event.getGuild().removeRoleFromMember(member, role).queue());
								}
							}
						}
					}
			);
		}
	}

	@Override
	public void onMessageReceived(MessageReceivedEvent event)
	{
		if(event.getChannelType().equals(ChannelType.TEXT) && !event.getAuthor().isBot() && !EventWaiter.waitingOnThis(event))
		{
			if(!event.getMessage().getContentRaw().startsWith(new GuildConfig(event.getGuild(), event.getJDA()).getGuildPrefix()))
			{
				MessageCache.getCache(event.getGuild()).set(new CachedMessage(event.getMessage()));
			}
		}
		CommandHandler.handle(event);
	}


	@Override
	public void onMessageDelete(MessageDeleteEvent event)
	{
		YamlUtils.clearField(event.getMessageId(), Filename.INTERNAL);
	}
}


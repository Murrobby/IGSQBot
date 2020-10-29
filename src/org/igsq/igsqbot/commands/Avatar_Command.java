package org.igsq.igsqbot.commands;

import java.awt.Color;

import org.igsq.igsqbot.EmbedGenerator;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.Permission;
import net.dv8tion.jda.api.entities.ChannelType;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.TextChannel;
import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

public class Avatar_Command {
	private Member me;
	private TextChannel channel;
	private User author;
	private Message message;
	User avatarUser;
	private String avatarUrl = "";

	public Avatar_Command(MessageReceivedEvent event) 
	{
		this.author = event.getAuthor();
		this.channel = event.getTextChannel();
		this.me = event.getGuild().getSelfMember();
		this.message = event.getMessage();
		
		avatarQuery();
	}
	
	private void avatarQuery()
	{
		if(message.isFromType(ChannelType.TEXT) && !author.isBot()) avatar();
		else new EmbedGenerator(channel).text("You cannot Execute this command!\nThis may be due to sending it in the wrong channel or not having the required permission.").color(Color.RED).sendTemporary();
	}
	
	private void avatar() 
	{
		if(me.hasPermission(Permission.MESSAGE_WRITE))
		{
			if(!message.getMentionedUsers().isEmpty() && message.getMentionedUsers().size() <= 3)
			{
				for(User selectedUser : message.getMentionedUsers())
				{
					String selectedAvatar = selectedUser.getEffectiveAvatarUrl();
					
			    	EmbedBuilder embedBuilder = new EmbedBuilder();
			    	embedBuilder.setTitle(selectedUser.getName() + "\'s Avatar");
			        embedBuilder.setImage(selectedAvatar);
			        channel.sendMessage(embedBuilder.build()).queue();
				}
			}
			else if(message.getMentionedUsers().size() > 3)
			{
				new EmbedGenerator(channel).text("Too many users entered! (Limit: 3)").color(Color.RED).sendTemporary();
			}
			else
			{
				avatarUser = author;
				avatarUrl = author.getEffectiveAvatarUrl();
				
		    	EmbedBuilder embedBuilder = new EmbedBuilder();
		    	embedBuilder.setTitle(avatarUser.getName() + "\'s Avatar");
		        embedBuilder.setImage(avatarUrl);
		        channel.sendMessage(embedBuilder.build()).queue();
			}
			
		}

	}
}

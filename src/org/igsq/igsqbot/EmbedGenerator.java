package org.igsq.igsqbot;

import java.awt.Color;
import java.util.concurrent.TimeUnit;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.Permission;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.MessageChannel;
import net.dv8tion.jda.api.entities.MessageEmbed;
import net.dv8tion.jda.api.entities.MessageEmbed.Field;
import net.dv8tion.jda.api.entities.TextChannel;

/**
 * Creates Embeds using JDA's {@link EmbedBuilder} api, with increased functionality.
 * @see #EmbedGenerator(MessageChannel)
 * @see #footer(String)
 * @see #text(String)
 * @see #title(String)
 * @see #author(String)
 * @see #element(String, String, boolean)
 * @see #image(String)
 * @see #reaction(String[])
 * @see #thumbnail(String)
 * @see #send()
 * @see #sendTemporary(int)
 * @see #replace(Message)
 * @see #getBuilder()
 * @see #getChannel()
 * @see #getReactions()
 */
public class EmbedGenerator{
	
	private String[] reactions = {};
	private MessageChannel channel;
	private final EmbedBuilder embed;
	private Message sentMessage = null;
	/**
	 * Constructor for Embed, requires a location for the embed to be created in ({@link MessageChannel})
	 * {@link #EmbedGenerator(MessageChannel) Without EmbedBuilder} 
	 * @see org.igsq.igsqbot.EmbedGenerator
	 */
	public EmbedGenerator(MessageChannel channel)
	{
		this.channel = channel;
		embed = new EmbedBuilder();
	}
	/**
	 * Constructor for Embed, requires a location for the embed to be created in ({@link MessageChannel})
	 * Overloads {@link #EmbedGenerator(MessageChannel) With EmbedBuilder}  
	 * @see org.igsq.igsqbot.EmbedGenerator
	 */
	public EmbedGenerator(MessageChannel channel, EmbedBuilder builder)
	{
		this.channel = channel;
		embed = builder;
	}
	/**
	 * Constructor for Embed, requires a location for the embed to be created in ({@link MessageChannel})
	 * Overloads {@link #EmbedGenerator(MessageChannel) With EmbedBuilder}  
	 * @see org.igsq.igsqbot.EmbedGenerator
	 */
	public EmbedGenerator(MessageChannel channel, MessageEmbed message)
	{
		this.channel = channel;
		embed = new EmbedBuilder();
		try {embed.setAuthor(message.getAuthor().toString());} catch(Exception exception) {new ErrorHandler(exception);}
		try {embed.setColor(message.getColor());} catch(Exception exception) {new ErrorHandler(exception);}
		try {embed.setDescription(message.getDescription());} catch(Exception exception) {new ErrorHandler(exception);}
		try {embed.setFooter(message.getFooter().getText());} catch(Exception exception) {new ErrorHandler(exception);}
		try {embed.setImage(message.getImage().toString());} catch(Exception exception) {new ErrorHandler(exception);}
		try {embed.setThumbnail(message.getThumbnail().toString());} catch(Exception exception) {new ErrorHandler(exception);}
		try {embed.setTimestamp(message.getTimestamp());} catch(Exception exception) {new ErrorHandler(exception);}
		try {embed.setTitle(message.getTitle());} catch(Exception exception) {new ErrorHandler(exception);}
		try {for(Field selectedField : message.getFields()) embed.addField(selectedField);} catch(Exception exception) {new ErrorHandler(exception);}
	}
	/**
	 * Sets the footer of an embed.
	 * Overloads {@link #footer(String,String) With icon}.
	 * @see net.dv8tion.jda.api.EmbedBuilder#setFooter(String)
	 * @see org.igsq.igsqbot.EmbedGenerator
	 */
	public EmbedGenerator footer(String text) 
	{
		embed.setFooter(text);
		return this;
	}
	/**
	 * Sets the footer of an embed with an icon using a url.
	 * Overloads {@link #footer(String) Without icon}.
	 * @see net.dv8tion.jda.api.EmbedBuilder#setFooter(String,String)
	 * @see org.igsq.igsqbot.EmbedGenerator
	 */
	public EmbedGenerator footer(String text,String iconUrl) 
	{
		embed.setFooter(text, iconUrl);
		return this;
	}
	
	/**
	 * Sets the title of an embed. Cannot be more characters than {@link Messaging#EMBED_TITLE_LIMIT}.
	 * Overloads {@link #title(String, String) With icon}.
	 * @see net.dv8tion.jda.api.EmbedBuilder#setTitle(String)
	 * @see org.igsq.igsqbot.EmbedGenerator
	 */
	public EmbedGenerator title(String text) 
	{
		if(text.length() > Messaging.EMBED_TITLE_LIMIT) return this;
		embed.setTitle(text);
		return this;
	}
	/**
	 * Sets the title of an embed with an icon using a url. Cannot be more characters than {@link Messaging#EMBED_TITLE_LIMIT}.
	 * Overloads {@link #title(String) Without icon}.
	 * @see net.dv8tion.jda.api.EmbedBuilder#setTitle(String,String)
	 * @see org.igsq.igsqbot.EmbedGenerator
	 */
	public EmbedGenerator title(String text,String iconUrl) 
	{
		if(text.length() > Messaging.EMBED_TITLE_LIMIT) return this;
		embed.setTitle(text, iconUrl);
		return this;
	}
	/**
	 * Sets the main text body of the embed. If you are planning to have subtitles or more than one body use {@link #element(String, String, boolean) elements}
	 * @see net.dv8tion.jda.api.EmbedBuilder#setDescription(CharSequence)
	 * @see org.igsq.igsqbot.EmbedGenerator
	 */
	public EmbedGenerator text(String text) 
	{
		embed.setDescription(text);
		return this;
	}
	/**
	 * Adds a field to the embed. If you are planning to have text with no subtitle use {@link #text(String) text}.
	 * Overloads {@link #element(String, String,boolean) Inline option}, {@link #element(Field) Using field type}, {@link #element(Field[]) Using an array of field types}.
	 * @see net.dv8tion.jda.api.EmbedBuilder#addField(String, String, boolean)
	 * @see org.igsq.igsqbot.EmbedGenerator
	 */
	public EmbedGenerator element(String subTitle,String description) 
	{
		embed.addField(subTitle, description, false);
		return this;
	}
	/**
	 * Adds a field to the embed. If you are planning to have text with no subtitle use {@link #text(String) text}.
	 * Overloads {@link #element(String, String) Inline defaulted to false}, {@link #element(Field) Using field type}, {@link #element(Field[]) Using an array of field types}.
	 * @see net.dv8tion.jda.api.EmbedBuilder#addField(String, String, boolean)
	 * @see org.igsq.igsqbot.EmbedGenerator
	 */
	public EmbedGenerator element(String subTitle,String description,boolean inline) 
	{
		embed.addField(subTitle, description, inline);
		return this;
	}
	/**
	 * Adds a {@link net.dv8tion.jda.api.entities.MessageEmbed.Field Field} to the embed. If you are planning to have text with no subtitle use {@link #text(String) text}.
	 * Overloads {@link #element(String, String) Inline defaulted to false}, {@link #element(String, String,boolean) Inline option}, {@link #element(Field[]) Using an array of field types}.
	 * @see net.dv8tion.jda.api.EmbedBuilder#addField(Field)
	 * @see org.igsq.igsqbot.EmbedGenerator
	 */
	public EmbedGenerator element(Field field) 
	{
		embed.addField(field);
		return this;
	}
	/**
	 * Adds an array of {@link net.dv8tion.jda.api.entities.MessageEmbed.Field Fields} to the embed. If you are planning to have text with no subtitle use {@link #text(String) text}.
	 * Overloads {@link #element(String, String) Inline defaulted to false}, {@link #element(String, String,boolean) Inline option}, {@link #element(Field) Using field type}.
	 * @see net.dv8tion.jda.api.EmbedBuilder#addField(Field)
	 * @see org.igsq.igsqbot.EmbedGenerator
	 */
	public EmbedGenerator element(Field[] field) 
	{
		for(Field selectedField : field) embed.addField(selectedField);
		return this;
	}
	/**
	 * Sets the {@link java.awt.Color Color} of the strip on the embed.
	 * @see net.dv8tion.jda.api.EmbedBuilder#setColor(Color)
	 * @see org.igsq.igsqbot.EmbedGenerator
	 */
	public EmbedGenerator color(Color color) 
	{
		embed.setColor(color);
		return this;
	}
	/**
	 * Sets the thumbnail of the embed given a url. The thumbnail is a smaller {@link #image(String) image} at the top right of the embed.
	 * @see net.dv8tion.jda.api.EmbedBuilder#setThumbnail(String)
	 * @see org.igsq.igsqbot.EmbedGenerator
	 */
	public EmbedGenerator thumbnail(String url) 
	{
		embed.setThumbnail(url);
		return this;
	}
	/**
	 * Sets the image of the embed given a url. The image is a bigger variant of the {@link #thumbnail(String) thumbnail} and is positioned at the center.
	 * @see net.dv8tion.jda.api.EmbedBuilder#setImage(String)
	 * @see org.igsq.igsqbot.EmbedGenerator
	 */
	public EmbedGenerator image(String url) 
	{
		embed.setImage(url);
		return this;
	}
	
	/**
	 * Sets the author of the embed.
	 * Overloads {@link #author(String, String) With url}, {@link #author(String, String, String) With icon}.
	 * @see net.dv8tion.jda.api.EmbedBuilder#setAuthor(String)
	 * @see org.igsq.igsqbot.EmbedGenerator
	 */
	public EmbedGenerator author(String author) 
	{
		embed.setAuthor(author);
		return this;
	}
	/**
	 * Sets the author of the embed. With a url.
	 * Overloads {@link #author(String) Only author}, {@link #author(String, String, String) With icon}.
	 * @see net.dv8tion.jda.api.EmbedBuilder#setAuthor(String, String)
	 * @see org.igsq.igsqbot.EmbedGenerator
	 */
	public EmbedGenerator author(String author,String url) 
	{
		embed.setAuthor(author, url);
		return this;
	}
	/**
	 * Sets the author of the embed. With a url & a little icon.
	 * Overloads {@link #author(String) Only author}, {@link #author(String, String) With url}.
	 * @see net.dv8tion.jda.api.EmbedBuilder#setAuthor(String, String, String)
	 * @see org.igsq.igsqbot.EmbedGenerator
	 */
	public EmbedGenerator author(String author,String url,String iconUrl) 
	{
		embed.setAuthor(author, url, iconUrl);
		return this;
	}
	/**
	 * Adds a reaction to the embed which is done after the embed has been sent. The reactions can be retrieved at any time using {@link #getReactions()}. If more than {@link Messaging#REACTION_LIMIT} reactions exist they will be ignored.
	 * Overloads {@link #reaction(String[]) Multiple (Array)}.
	 * @see org.igsq.igsqbot.EmbedGenerator
	 */
	public EmbedGenerator reaction(String emojiUnicode) 
	{
		if(reactions.length >= Messaging.REACTION_LIMIT) return this;
		reactions = Common.append(reactions, emojiUnicode);
		return this;
	}
	/**
	 * Adds an array of reactions to the embed which is done after the embed has been sent. The reactions can be retrieved at any time using {@link #getReactions()}. If more than {@link Messaging#REACTION_LIMIT} reactions exist they will be ignored.
	 * Overloads {@link #reaction(String) Singular}.
	 * @see org.igsq.igsqbot.EmbedGenerator
	 * @see org.igsq.igsqbot.MessageGenerator#reaction(String[])
	 */
	public EmbedGenerator reaction(String[] emojiUnicodes) 
	{
		for(String emojiUnicode : emojiUnicodes) 
		{
			if(reactions.length >= Messaging.REACTION_LIMIT) return this;
			reactions = Common.append(reactions, emojiUnicode);
		}
		return this;
	}
	
	/**
	 * Sends the message to the channel designated in the {@link #EmbedGenerator(MessageChannel)} (MessageChannel) constructor}. 
	 * @see  net.dv8tion.jda.api.entities.MessageChannel#sendMessage(MessageEmbed)
	 * @see org.igsq.igsqbot.EmbedGenerator
	 */
	public Message send()
	{
		if(embed.isEmpty()) return null;
		if(channel instanceof TextChannel && !((TextChannel)channel).getGuild().getSelfMember().hasPermission(Permission.MESSAGE_WRITE)) return null;
		
		sentMessage = channel.sendMessage(embed.build()).complete();
		if(!(channel instanceof TextChannel) || ((TextChannel)channel).getGuild().getSelfMember().hasPermission(Permission.MESSAGE_ADD_REACTION)) for(String reaction : reactions) sentMessage.addReaction(reaction).queue();
		return sentMessage;
	}
	/**
	 * Sends the message to the channel designated in the {@link #EmbedGenerator(MessageChannel)} (MessageChannel) constructor}. Deletes the message after delay time has passed. Uses {@link TimeUnit#MILLISECONDS}.
	 * Overloads {@link #sendTemporary() default 10s}.
	 * @see  net.dv8tion.jda.api.entities.MessageChannel#sendMessage(MessageEmbed)
	 * @see  net.dv8tion.jda.api.entities.Message#delete()
	 * @see org.igsq.igsqbot.EmbedGenerator
	 */
	public Message sendTemporary(int delay) 
	{
		if(embed.isEmpty()) return null;
		if(channel instanceof TextChannel && !((TextChannel)channel).getGuild().getSelfMember().hasPermission(Permission.MESSAGE_WRITE)) return null;
		if(delay < 0) return null;
		if(delay == 0) return send();
		channel.sendMessage(embed.build()).queue
		(
    		message -> 
    		{
    			if(!(channel instanceof TextChannel) || ((TextChannel)channel).getGuild().getSelfMember().hasPermission(Permission.MESSAGE_ADD_REACTION)) for(String reaction : reactions) message.addReaction(reaction).queue();
    			message.delete().submitAfter(delay, TimeUnit.MILLISECONDS);
    			this.sentMessage = message;
    		}
        );
		return sentMessage;
	}
	/**
	 * Sends the message to the channel designated in the {@link #EmbedGenerator(MessageChannel)} constructor}. Deletes the message after 10 seconds has passed.
	 * Overloads {@link #sendTemporary(int) non default times}.
	 * @see  net.dv8tion.jda.api.entities.MessageChannel#sendMessage(MessageEmbed)
	 * @see  net.dv8tion.jda.api.entities.Message#delete()
	 * @see org.igsq.igsqbot.EmbedGenerator
	 */
	public Message sendTemporary() 
	{
		return sendTemporary(10000);
	}
	/**
	 * Replaces the message in the channel designated in the {@link #EmbedGenerator(MessageChannel)} constructor}.
	 * Overloads {@link #replace(Message, long, MessageEmbed)} replace(Message, int) With delay}
	 * @see net.dv8tion.jda.api.entities.Message#editMessage(Message)
	 * @see org.igsq.igsqbot.EmbedGenerator
	 */
	public void replace(Message activeMessage)
	{
		if(Yaml.getFieldBool(activeMessage.getId() + ".changepending", "internal")) return;
		if(embed.isEmpty()) return;
		if(channel instanceof TextChannel && !((TextChannel)channel).getGuild().getSelfMember().hasPermission(Permission.MESSAGE_WRITE)) return;
        activeMessage.editMessage(embed.build()).queue
        (
				message -> 
				{
					if(channel instanceof TextChannel && ((TextChannel)channel).getGuild().getSelfMember().hasPermission(Permission.MESSAGE_ADD_REACTION)) for(String reaction : reactions) message.addReaction(reaction).queue();
				}
		);
	}
	/**
	 * Replaces the message in the channel designated in the {@link #EmbedGenerator(MessageChannel)} (MessageChannel) constructor}.
	 * Overloads {@link #replace(Message, long, MessageEmbed)} With delay}
	 * @see net.dv8tion.jda.api.entities.Message#editMessage(Message)
	 * @see org.igsq.igsqbot.EmbedGenerator
	 */
	public void replace(Message activeMessage, boolean overwritePending)
	{
		if(!overwritePending) 
			{
				replace(activeMessage);
				return;
			}
		Yaml.updateField(activeMessage.getId() + ".changepending", "internal", false);
		if(embed.isEmpty()) return;
		if(channel instanceof TextChannel && !((TextChannel)channel).getGuild().getSelfMember().hasPermission(Permission.MESSAGE_WRITE)) return;
        activeMessage.editMessage(embed.build()).queue
        (
				message ->
				{
					if(channel instanceof TextChannel && ((TextChannel)channel).getGuild().getSelfMember().hasPermission(Permission.MESSAGE_ADD_REACTION)) for(String reaction : reactions) message.addReaction(reaction).queue();
				}
		);
	}
	/**
	 * Replaces the message in the channel designated in the {@link #EmbedGenerator(MessageChannel)} (MessageChannel) constructor}. Reverts to previous embed after set delay.
	 * Overloads {@link #replace(Message) Without delay}
	 * @see net.dv8tion.jda.api.entities.Message#editMessage(Message)
	 * @see org.igsq.igsqbot.EmbedGenerator
	 */
	public void replace(Message activeMessage, long delay, MessageEmbed oldEmbed)
	{
		if(Yaml.getFieldBool(activeMessage.getId() + ".changepending", "internal")) return;
		if(embed.isEmpty()) return;
		if(channel instanceof TextChannel && !((TextChannel)channel).getGuild().getSelfMember().hasPermission(Permission.MESSAGE_WRITE)) return;
        activeMessage.editMessage(embed.build()).queue
        (
				message -> 
				{
					if(channel instanceof TextChannel && ((TextChannel)channel).getGuild().getSelfMember().hasPermission(Permission.MESSAGE_ADD_REACTION)) for(String reaction : reactions) message.addReaction(reaction).queue();
				}
		);

        Yaml.updateField(activeMessage.getId() + ".changepending", "internal", true);
        Common.scheduler.schedule(() ->
		{
			if(oldEmbed.equals(activeMessage.getEmbeds().get(0)) && Yaml.getFieldBool(activeMessage.getId() + ".changepending", "internal"))
			{
				activeMessage.editMessage(oldEmbed).complete();
			}
		}, delay, TimeUnit.MILLISECONDS);

        Common.scheduler.schedule(() ->
		{
			if(Yaml.getFieldBool(activeMessage.getId() + ".changepending", "internal"))
			{
				Yaml.updateField(activeMessage.getId() + ".changepending", "internal", false);
			}
		}, delay, TimeUnit.MILLISECONDS);
	}
	/**
	 * Gets the {@link EmbedBuilder EmbedBuilder} the message is being built from.
	 * @see org.igsq.igsqbot.EmbedGenerator
	 */
	public EmbedBuilder getBuilder() 
	{
		return embed;
	}
	
	/**
	 * Gets the reactions ready to be added to the message.
	 * @see  #reaction(String[])
	 * @see org.igsq.igsqbot.MessageGenerator
	 */
	public String[] getReactions() 
	{
		return reactions;
	}
	/**
	 * Gets the channel the embed will be send to, designated by the {@link #EmbedGenerator(MessageChannel)} (MessageChannel) constructor}
	 * @see  net.dv8tion.jda.api.entities.MessageChannel
	 * @see org.igsq.igsqbot.MessageGenerator
	 */
	public MessageChannel getChannel() 
	{
		return channel;
	}
	public EmbedGenerator setChannel(MessageChannel channel) 
	{
		this.channel = channel;
		return this;
	}
	
}

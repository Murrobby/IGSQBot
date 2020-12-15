package org.igsq.igsqbot.commands;

import net.dv8tion.jda.api.Permission;
import net.dv8tion.jda.api.entities.MessageChannel;
import net.dv8tion.jda.api.entities.User;

import org.igsq.igsqbot.util.ArrayUtils;
import org.igsq.igsqbot.util.CommandUtils;
import org.igsq.igsqbot.objects.Command;
import org.igsq.igsqbot.objects.Context;
import org.igsq.igsqbot.objects.EmbedGenerator;
import org.igsq.igsqbot.util.EmbedUtils;

import java.util.ArrayList;
import java.util.List;

public class Poll_Command extends Command
{
	public Poll_Command()
	{
		super("poll", new String[]{}, "Starts a poll for users to vote in.","[title]/[option1]/[option2]-20-",new Permission[]{}, false,0);
	}

	@Override
	public void execute(String[] args, Context ctx)
	{
		final StringBuilder options = new StringBuilder();
		final MessageChannel channel = ctx.getChannel();
		final User author = ctx.getAuthor();
		final List<String> reactions = new ArrayList<>();
		final String[] slashArgs;

		if(args.length != 1)
		{
			EmbedUtils.sendSyntaxError(channel,this);
			return;
		}
		slashArgs = args[0].split("/");
		if(slashArgs.length >= 3)
		{
			String topic = slashArgs[0];
			for(int i = 1; i < slashArgs.length && i < EmbedUtils.REACTION_LIMIT+1; i++)
			{
				options.append(slashArgs[i]).append(" ").append(CommandUtils.POLL_EMOJIS.get(i - 1)).append("\n");
				if(args.length <= EmbedUtils.REACTION_LIMIT/2+1) options.append("\n");
				reactions.add(CommandUtils.POLL_EMOJIS_UNICODE.get(i-1));
			}
			new EmbedGenerator(channel)
					.title("Poll:")
					.text(topic)
					.element("Options:", options.toString())
					.footer("Poll created by "+ author.getAsTag())
					.thumbnail(author.getAvatarUrl())
					.color(EmbedUtils.IGSQ_PURPLE)
					.reaction(reactions.toArray(new String[0]))
					.send();
		}
		else
		{
			EmbedUtils.sendSyntaxError(channel,this);
		}
	}
}

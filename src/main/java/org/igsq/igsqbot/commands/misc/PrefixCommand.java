package org.igsq.igsqbot.commands.misc;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.Permission;
import net.dv8tion.jda.api.entities.MessageChannel;
import org.igsq.igsqbot.Constants;
import org.igsq.igsqbot.entities.Command;
import org.igsq.igsqbot.entities.CommandContext;
import org.igsq.igsqbot.util.ArrayUtils;
import org.igsq.igsqbot.util.EmbedUtils;

import java.util.Collections;
import java.util.List;

public class PrefixCommand extends Command
{
	@Override
	public void execute(List<String> args, CommandContext ctx)
	{
		MessageChannel channel = ctx.getChannel();

		if(args.isEmpty())
		{
			EmbedUtils.sendDeletingEmbed(channel, new EmbedBuilder()
					.setDescription("")
					.setColor(Constants.IGSQ_PURPLE), 30000);
		}
		else if(args.size() > 1 || args.get(0).length() > 5)
		{
			EmbedUtils.sendSyntaxError(ctx);
		}
		else if(args.get(0).equalsIgnoreCase("reset"))
		{
			ctx.replySuccess("Reset my prefix to `" + Constants.DEFAULT_BOT_PREFIX + "`");
		}
		else
		{
			if(!ArrayUtils.isValueInArray(new String[]{" "}, args.get(0)))
			{
				ctx.replySuccess("My new prefix is `" + args.get(0) + "`");
			}
		}
	}

	@Override
	public String getName()
	{
		return "Prefix";
	}

	@Override
	public List<String> getAliases()
	{
		return Collections.singletonList("prefix");
	}

	@Override
	public String getDescription()
	{
		return "Sets / gets the prefix for the bot in the current server.";
	}

	@Override
	public String getSyntax()
	{
		return "<newPrefix {5}> | <reset> | <none> ";
	}

	@Override
	public boolean canExecute(CommandContext ctx)
	{
		return ctx.hasPermission(Collections.singletonList(Permission.ADMINISTRATOR));
	}

	@Override
	public boolean isGuildOnly()
	{
		return true;
	}

	@Override
	public int getCooldown()
	{
		return 0;
	}
}

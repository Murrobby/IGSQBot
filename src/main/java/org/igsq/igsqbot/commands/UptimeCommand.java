package org.igsq.igsqbot.commands;

import net.dv8tion.jda.api.Permission;
import org.igsq.igsqbot.IGSQBot;
import org.igsq.igsqbot.entities.Command;
import org.igsq.igsqbot.entities.CommandContext;
import org.igsq.igsqbot.entities.EmbedGenerator;
import org.igsq.igsqbot.util.EmbedUtils;
import org.igsq.igsqbot.util.StringUtils;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;

public class UptimeCommand extends Command
{
	public UptimeCommand()
	{
		super("Uptime", new String[]{"uptime"}, "Displays the bots uptime", "[none]", new Permission[]{}, false, 0);
	}

	@Override
	public void execute(List<String> args, CommandContext ctx)
	{
		if(!args.isEmpty())
		{
			EmbedUtils.sendSyntaxError(ctx.getChannel(), this);
			return;
		}

		final Duration uptime = Duration.between(IGSQBot.START_TIMESTAMP, LocalDateTime.now());
		new EmbedGenerator(ctx.getChannel())
				.text("Uptime: " + uptime.toDays() + " days, " + uptime.toHours() + " hours, " + uptime.toSeconds() + " seconds.")
				.color(EmbedUtils.IGSQ_PURPLE)
				.footer(StringUtils.getTimestamp())
				.send();
	}
}

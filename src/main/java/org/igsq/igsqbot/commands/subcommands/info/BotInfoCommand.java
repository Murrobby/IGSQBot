package org.igsq.igsqbot.commands.subcommands.info;

import java.util.List;
import net.dv8tion.jda.api.EmbedBuilder;
import org.igsq.igsqbot.entities.command.Command;
import org.igsq.igsqbot.entities.command.CommandContext;
import org.igsq.igsqbot.entities.info.BotInfo;

public class BotInfoCommand extends Command
{
	public BotInfoCommand(Command parent)
	{
		super(parent, "bot", "Shows information about the bot.", "[none]");
	}

	@Override
	public void run(List<String> args, CommandContext ctx)
	{
		ctx.sendMessage(new EmbedBuilder()
				.setTitle("IGSQBot information")
				.addField("JVM Version", BotInfo.getJavaVersion(), true)
				.addField("JDA Version", BotInfo.getJDAVersion(), true)
				.addBlankField(true)
				.addField("Thread Count", String.valueOf(BotInfo.getThreadCount()), true)
				.addField("Memory Usage", BotInfo.getMemoryFormatted(), true)
				.addBlankField(true)
				.addField("Shard info", ctx.getJDA().getShardInfo().getShardString(), true)
				.addField("Server count", String.valueOf(BotInfo.getTotalServers(ctx.getIGSQBot().getShardManager())), true)
				.addBlankField(true));
	}
}

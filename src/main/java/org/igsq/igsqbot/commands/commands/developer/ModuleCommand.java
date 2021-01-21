package org.igsq.igsqbot.commands.commands.developer;

import java.util.List;
import java.util.function.Consumer;
import org.igsq.igsqbot.entities.command.Command;
import org.igsq.igsqbot.entities.command.CommandEvent;
import org.igsq.igsqbot.entities.command.CommandFlag;
import org.igsq.igsqbot.entities.exception.CommandException;
import org.igsq.igsqbot.entities.exception.CommandResultException;
import org.igsq.igsqbot.entities.exception.CommandSyntaxException;
import org.igsq.igsqbot.util.CommandChecks;

@SuppressWarnings("unused")
public class ModuleCommand extends Command
{
	public ModuleCommand()
	{
		super("Module", "Disables / Enables the specified module.", "[enable/disable] [module]");
		addFlags(CommandFlag.DEVELOPER_ONLY);
		addAliases("module", "command");
		addChildren(
				new ModuleEnableCommand(this),
				new ModuleDisableCommand(this)
		);
	}

	@Override
	public void run(List<String> args, CommandEvent cmd, Consumer<CommandException> failure)
	{
		failure.accept(new CommandSyntaxException(cmd));
	}

	public static class ModuleEnableCommand extends Command
	{
		public ModuleEnableCommand(Command parent)
		{
			super(parent, "enable", "Enables a module", "[module-name]");
			addFlags(CommandFlag.DEVELOPER_ONLY);
		}

		@Override
		public void run(List<String> args, CommandEvent cmd, Consumer<CommandException> failure)
		{
			if(CommandChecks.argsEmpty(cmd, failure)) return;
			String moduleName = args.get(0);
			Command command = cmd.getIGSQBot().getCommandHandler().getCommandMap().get(moduleName);
			if(command == null)
			{
				failure.accept(new CommandResultException("Module " + moduleName + " was not found"));
				return;
			}

			if(!command.isDisabled())
			{
				failure.accept(new CommandResultException("Module " + command.getName() + " was already enabled."));
				return;
			}
			command.setDisabled(false);
			cmd.replySuccess("Enabled module: `" + command.getName() + "`.");
			cmd.getIGSQBot().getLogger().warn("Module " + command.getName() + " was enabled.");
		}
	}

	public static class ModuleDisableCommand extends Command
	{
		public ModuleDisableCommand(Command parent)
		{
			super(parent, "disable", "Disables a module", "[module-name]");
			addFlags(CommandFlag.DEVELOPER_ONLY);
		}

		@Override
		public void run(List<String> args, CommandEvent cmd, Consumer<CommandException> failure)
		{
			if(CommandChecks.argsEmpty(cmd, failure)) return;
			String moduleName = args.get(0);
			Command command = cmd.getIGSQBot().getCommandHandler().getCommandMap().get(moduleName);
			if(command == null)
			{
				failure.accept(new CommandResultException("Module " + moduleName + " was not found"));
				return;
			}
			if(command.isDisabled())
			{
				failure.accept(new CommandResultException("Module " + command.getName() + " was already disabled."));
				return;
			}

			command.setDisabled(true);
			cmd.replySuccess("Disabled module: `" + command.getName() + "`.");
			cmd.getIGSQBot().getLogger().warn("Module " + command.getName() + " was disabled.");
		}
	}
}

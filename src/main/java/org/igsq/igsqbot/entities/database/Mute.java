package org.igsq.igsqbot.entities.database;

import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.Role;
import org.igsq.igsqbot.IGSQBot;
import org.igsq.igsqbot.entities.jooq.Tables;
import org.igsq.igsqbot.entities.jooq.tables.Mutes;
import org.igsq.igsqbot.entities.jooq.tables.Roles;

import java.sql.Connection;
import java.time.LocalDateTime;
import java.util.List;

public class Mute
{
	private final LocalDateTime mutedUntil;
	private final IGSQBot igsqBot;
	private final long memberId;
	private final Guild guild;
	private final List<Long> roleIds;

	public Mute(long memberId, List<Long> roleIds, Guild guild, LocalDateTime mutedUntil, IGSQBot igsqBot)
	{
		this.memberId = memberId;
		this.roleIds = roleIds;
		this.guild = guild;
		this.mutedUntil = mutedUntil;
		this.igsqBot = igsqBot;
	}

	public boolean add()
	{
		try(Connection connection = igsqBot.getDatabaseManager().getConnection())
		{
			if(igsqBot.getDatabaseManager().getContext(connection)
					.select(Mutes.MUTES.USERID)
					.from(Tables.MUTES)
					.fetchOne() != null)
			{
				return false;
			}

			for(long roleId : roleIds)
			{
				igsqBot.getDatabaseManager().getContext(connection)
						.insertInto(Tables.ROLES)
						.columns(Roles.ROLES.GUILDID, Roles.ROLES.USERID, Roles.ROLES.ROLEID)
						.values(guild.getIdLong(), memberId, roleId)
						.execute();
			}

			igsqBot.getDatabaseManager().getContext(connection)
					.insertInto(Tables.MUTES)
					.columns(Mutes.MUTES.GUILDID, Mutes.MUTES.USERID, Mutes.MUTES.MUTEDUNTIL)
					.values(guild.getIdLong(), memberId, mutedUntil)
					.execute();

		}
		catch(Exception exception)
		{
			igsqBot.getLogger().error("An SQL error occurred", exception);
			return false;
		}
		return true;
	}

	public void remove()
	{
		try(Connection connection = igsqBot.getDatabaseManager().getConnection())
		{
			igsqBot.getDatabaseManager().getContext(connection)
					.deleteFrom(Tables.MUTES)
					.where(Mutes.MUTES.USERID.eq(memberId))
					.execute();

			igsqBot.getDatabaseManager().getContext(connection)
					.deleteFrom(Tables.ROLES)
					.where(Roles.ROLES.USERID.eq(memberId))
					.execute();

		}
		catch(Exception exception)
		{
			igsqBot.getLogger().error("An SQL error occurred", exception);
		}
	}

	public static void removeMuteById(long userId, IGSQBot igsqBot)
	{
		try(Connection connection = igsqBot.getDatabaseManager().getConnection())
		{
			var roles = igsqBot.getDatabaseManager().getContext(connection)
					.selectFrom(Tables.ROLES)
					.where(Roles.ROLES.USERID.eq(userId));

			for(var value : roles.fetch())
			{
				Guild guild = igsqBot.getShardManager().getGuildById(value.getGuildid());
				if(guild != null)
				{
					Role role = guild.getRoleById(value.getRoleid());
					if(role != null)
					{
						guild.addRoleToMember(value.getUserid(), role).queue();
					}
				}
			}
			igsqBot.getDatabaseManager().getContext(connection)
					.deleteFrom(Tables.MUTES)
					.where(Mutes.MUTES.USERID.eq(userId))
					.execute();

			igsqBot.getDatabaseManager().getContext(connection)
					.deleteFrom(Tables.ROLES)
					.where(Roles.ROLES.USERID.eq(userId))
					.execute();
		}
		catch(Exception exception)
		{
			igsqBot.getLogger().error("An SQL error occurred", exception);
		}
	}
}

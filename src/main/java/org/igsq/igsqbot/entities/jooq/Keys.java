/*
 * This file is generated by jOOQ.
 */
package org.igsq.igsqbot.entities.jooq;


import org.jooq.ForeignKey;
import org.jooq.TableField;
import org.jooq.UniqueKey;
import org.igsq.igsqbot.entities.jooq.tables.ChannelBlacklists;
import org.igsq.igsqbot.entities.jooq.tables.Guilds;
import org.igsq.igsqbot.entities.jooq.tables.Levels;
import org.igsq.igsqbot.entities.jooq.tables.ReactionRoles;
import org.igsq.igsqbot.entities.jooq.tables.Reminders;
import org.igsq.igsqbot.entities.jooq.tables.Reports;
import org.igsq.igsqbot.entities.jooq.tables.Roles;
import org.igsq.igsqbot.entities.jooq.tables.Tempbans;
import org.igsq.igsqbot.entities.jooq.tables.Votes;
import org.igsq.igsqbot.entities.jooq.tables.Warnings;
import org.igsq.igsqbot.entities.jooq.tables.WordBlacklists;
import org.igsq.igsqbot.entities.jooq.tables.records.ChannelBlacklistsRecord;
import org.igsq.igsqbot.entities.jooq.tables.records.GuildsRecord;
import org.igsq.igsqbot.entities.jooq.tables.records.LevelsRecord;
import org.igsq.igsqbot.entities.jooq.tables.records.ReactionRolesRecord;
import org.igsq.igsqbot.entities.jooq.tables.records.RemindersRecord;
import org.igsq.igsqbot.entities.jooq.tables.records.ReportsRecord;
import org.igsq.igsqbot.entities.jooq.tables.records.RolesRecord;
import org.igsq.igsqbot.entities.jooq.tables.records.TempbansRecord;
import org.igsq.igsqbot.entities.jooq.tables.records.VotesRecord;
import org.igsq.igsqbot.entities.jooq.tables.records.WarningsRecord;
import org.igsq.igsqbot.entities.jooq.tables.records.WordBlacklistsRecord;
import org.jooq.impl.DSL;
import org.jooq.impl.Internal;


/**
 * A class modelling foreign key relationships and constraints of tables in 
 * public.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Keys {

    // -------------------------------------------------------------------------
    // UNIQUE and PRIMARY KEY definitions
    // -------------------------------------------------------------------------

    public static final UniqueKey<ChannelBlacklistsRecord> CHANNEL_BLACKLISTS_PKEY = Internal.createUniqueKey(ChannelBlacklists.CHANNEL_BLACKLISTS, DSL.name("channel_blacklists_pkey"), new TableField[] { ChannelBlacklists.CHANNEL_BLACKLISTS.ID }, true);
    public static final UniqueKey<GuildsRecord> GUILDS_PKEY = Internal.createUniqueKey(Guilds.GUILDS, DSL.name("guilds_pkey"), new TableField[] { Guilds.GUILDS.GUILD_ID }, true);
    public static final UniqueKey<LevelsRecord> LEVELS_PKEY = Internal.createUniqueKey(Levels.LEVELS, DSL.name("levels_pkey"), new TableField[] { Levels.LEVELS.ID }, true);
    public static final UniqueKey<ReactionRolesRecord> REACTION_ROLES_PKEY = Internal.createUniqueKey(ReactionRoles.REACTION_ROLES, DSL.name("reaction_roles_pkey"), new TableField[] { ReactionRoles.REACTION_ROLES.ID }, true);
    public static final UniqueKey<RemindersRecord> REMINDERS_PKEY = Internal.createUniqueKey(Reminders.REMINDERS, DSL.name("reminders_pkey"), new TableField[] { Reminders.REMINDERS.ID }, true);
    public static final UniqueKey<ReportsRecord> REPORTS_MESSAGE_ID_KEY = Internal.createUniqueKey(Reports.REPORTS, DSL.name("reports_message_id_key"), new TableField[] { Reports.REPORTS.MESSAGE_ID }, true);
    public static final UniqueKey<ReportsRecord> REPORTS_PKEY = Internal.createUniqueKey(Reports.REPORTS, DSL.name("reports_pkey"), new TableField[] { Reports.REPORTS.ID }, true);
    public static final UniqueKey<ReportsRecord> REPORTS_REPORT_MESSAGE_ID_KEY = Internal.createUniqueKey(Reports.REPORTS, DSL.name("reports_report_message_id_key"), new TableField[] { Reports.REPORTS.REPORT_MESSAGE_ID }, true);
    public static final UniqueKey<RolesRecord> ROLES_PKEY = Internal.createUniqueKey(Roles.ROLES, DSL.name("roles_pkey"), new TableField[] { Roles.ROLES.ID }, true);
    public static final UniqueKey<TempbansRecord> TEMPBANS_GUILD_ID_KEY = Internal.createUniqueKey(Tempbans.TEMPBANS, DSL.name("tempbans_guild_id_key"), new TableField[] { Tempbans.TEMPBANS.GUILD_ID }, true);
    public static final UniqueKey<TempbansRecord> TEMPBANS_PKEY = Internal.createUniqueKey(Tempbans.TEMPBANS, DSL.name("tempbans_pkey"), new TableField[] { Tempbans.TEMPBANS.ID }, true);
    public static final UniqueKey<TempbansRecord> TEMPBANS_USER_ID_KEY = Internal.createUniqueKey(Tempbans.TEMPBANS, DSL.name("tempbans_user_id_key"), new TableField[] { Tempbans.TEMPBANS.USER_ID }, true);
    public static final UniqueKey<VotesRecord> VOTES_PKEY = Internal.createUniqueKey(Votes.VOTES, DSL.name("votes_pkey"), new TableField[] { Votes.VOTES.ID }, true);
    public static final UniqueKey<WarningsRecord> WARNINGS_PKEY = Internal.createUniqueKey(Warnings.WARNINGS, DSL.name("warnings_pkey"), new TableField[] { Warnings.WARNINGS.ID }, true);
    public static final UniqueKey<WordBlacklistsRecord> WORD_BLACKLISTS_PKEY = Internal.createUniqueKey(WordBlacklists.WORD_BLACKLISTS, DSL.name("word_blacklists_pkey"), new TableField[] { WordBlacklists.WORD_BLACKLISTS.ID }, true);

    // -------------------------------------------------------------------------
    // FOREIGN KEY definitions
    // -------------------------------------------------------------------------

    public static final ForeignKey<ChannelBlacklistsRecord, GuildsRecord> CHANNEL_BLACKLISTS__CHANNEL_BLACKLISTS_GUILD_ID_FKEY = Internal.createForeignKey(ChannelBlacklists.CHANNEL_BLACKLISTS, DSL.name("channel_blacklists_guild_id_fkey"), new TableField[] { ChannelBlacklists.CHANNEL_BLACKLISTS.GUILD_ID }, Keys.GUILDS_PKEY, new TableField[] { Guilds.GUILDS.GUILD_ID }, true);
    public static final ForeignKey<ReportsRecord, GuildsRecord> REPORTS__REPORTS_GUILD_ID_FKEY = Internal.createForeignKey(Reports.REPORTS, DSL.name("reports_guild_id_fkey"), new TableField[] { Reports.REPORTS.GUILD_ID }, Keys.GUILDS_PKEY, new TableField[] { Guilds.GUILDS.GUILD_ID }, true);
    public static final ForeignKey<WordBlacklistsRecord, GuildsRecord> WORD_BLACKLISTS__WORD_BLACKLISTS_GUILD_ID_FKEY = Internal.createForeignKey(WordBlacklists.WORD_BLACKLISTS, DSL.name("word_blacklists_guild_id_fkey"), new TableField[] { WordBlacklists.WORD_BLACKLISTS.GUILD_ID }, Keys.GUILDS_PKEY, new TableField[] { Guilds.GUILDS.GUILD_ID }, true);
}

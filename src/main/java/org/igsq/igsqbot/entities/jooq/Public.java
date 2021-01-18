/*
 * This file is generated by jOOQ.
 */
package org.igsq.igsqbot.entities.jooq;


import java.util.Arrays;
import java.util.List;

import org.igsq.igsqbot.entities.jooq.tables.Roles;
import org.igsq.igsqbot.entities.jooq.tables.Tempbans;
import org.igsq.igsqbot.entities.jooq.tables.Votes;
import org.igsq.igsqbot.entities.jooq.tables.Warnings;
import org.jooq.Catalog;
import org.jooq.Sequence;
import org.jooq.Table;
import org.igsq.igsqbot.entities.jooq.tables.Guilds;
import org.igsq.igsqbot.entities.jooq.tables.ReactionRoles;
import org.igsq.igsqbot.entities.jooq.tables.Reminders;
import org.igsq.igsqbot.entities.jooq.tables.Reports;
import org.jooq.impl.SchemaImpl;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Public extends SchemaImpl {

    private static final long serialVersionUID = 1L;

    /**
     * The reference instance of <code>public</code>
     */
    public static final Public PUBLIC = new Public();

    /**
     * The table <code>public.guilds</code>.
     */
    public final Guilds GUILDS = Guilds.GUILDS;

    /**
     * The table <code>public.reaction_roles</code>.
     */
    public final ReactionRoles REACTION_ROLES = ReactionRoles.REACTION_ROLES;

    /**
     * The table <code>public.reminders</code>.
     */
    public final Reminders REMINDERS = Reminders.REMINDERS;

    /**
     * The table <code>public.reports</code>.
     */
    public final Reports REPORTS = Reports.REPORTS;

    /**
     * The table <code>public.roles</code>.
     */
    public final Roles ROLES = Roles.ROLES;

    /**
     * The table <code>public.tempbans</code>.
     */
    public final Tempbans TEMPBANS = Tempbans.TEMPBANS;

    /**
     * The table <code>public.votes</code>.
     */
    public final Votes VOTES = Votes.VOTES;

    /**
     * The table <code>public.warnings</code>.
     */
    public final Warnings WARNINGS = Warnings.WARNINGS;

    /**
     * No further instances allowed
     */
    private Public() {
        super("public", null);
    }


    @Override
    public Catalog getCatalog() {
        return DefaultCatalog.DEFAULT_CATALOG;
    }

    @Override
    public final List<Sequence<?>> getSequences() {
        return Arrays.<Sequence<?>>asList(
            Sequences.REACTION_ROLES_ID_SEQ,
            Sequences.REMINDERS_ID_SEQ,
            Sequences.REPORTS_ID_SEQ,
            Sequences.ROLES_ID_SEQ,
            Sequences.TEMPBANS_ID_SEQ,
            Sequences.VOTES_ID_SEQ,
            Sequences.WARNINGS_ID_SEQ);
    }

    @Override
    public final List<Table<?>> getTables() {
        return Arrays.<Table<?>>asList(
            Guilds.GUILDS,
            ReactionRoles.REACTION_ROLES,
            Reminders.REMINDERS,
            Reports.REPORTS,
            Roles.ROLES,
            Tempbans.TEMPBANS,
            Votes.VOTES,
            Warnings.WARNINGS);
    }
}

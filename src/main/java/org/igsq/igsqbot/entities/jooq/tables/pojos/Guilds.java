/*
 * This file is generated by jOOQ.
 */
package org.igsq.igsqbot.entities.jooq.tables.pojos;


import java.io.Serializable;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Guilds implements Serializable {

    private static final long serialVersionUID = 1L;

    private final Long   guildId;
    private final Long   logChannel;
    private final Long   mutedRole;
    private final Long   verifiedRole;
    private final Long   reportChannel;
    private final Long   voteChannel;
    private final Long   suggestionChannel;
    private final String prefix;

    public Guilds(Guilds value) {
        this.guildId = value.guildId;
        this.logChannel = value.logChannel;
        this.mutedRole = value.mutedRole;
        this.verifiedRole = value.verifiedRole;
        this.reportChannel = value.reportChannel;
        this.voteChannel = value.voteChannel;
        this.suggestionChannel = value.suggestionChannel;
        this.prefix = value.prefix;
    }

    public Guilds(
        Long   guildId,
        Long   logChannel,
        Long   mutedRole,
        Long   verifiedRole,
        Long   reportChannel,
        Long   voteChannel,
        Long   suggestionChannel,
        String prefix
    ) {
        this.guildId = guildId;
        this.logChannel = logChannel;
        this.mutedRole = mutedRole;
        this.verifiedRole = verifiedRole;
        this.reportChannel = reportChannel;
        this.voteChannel = voteChannel;
        this.suggestionChannel = suggestionChannel;
        this.prefix = prefix;
    }

    /**
     * Getter for <code>public.guilds.guild_id</code>.
     */
    public Long getGuildId() {
        return this.guildId;
    }

    /**
     * Getter for <code>public.guilds.log_channel</code>.
     */
    public Long getLogChannel() {
        return this.logChannel;
    }

    /**
     * Getter for <code>public.guilds.muted_role</code>.
     */
    public Long getMutedRole() {
        return this.mutedRole;
    }

    /**
     * Getter for <code>public.guilds.verified_role</code>.
     */
    public Long getVerifiedRole() {
        return this.verifiedRole;
    }

    /**
     * Getter for <code>public.guilds.report_channel</code>.
     */
    public Long getReportChannel() {
        return this.reportChannel;
    }

    /**
     * Getter for <code>public.guilds.vote_channel</code>.
     */
    public Long getVoteChannel() {
        return this.voteChannel;
    }

    /**
     * Getter for <code>public.guilds.suggestion_channel</code>.
     */
    public Long getSuggestionChannel() {
        return this.suggestionChannel;
    }

    /**
     * Getter for <code>public.guilds.prefix</code>.
     */
    public String getPrefix() {
        return this.prefix;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Guilds (");

        sb.append(guildId);
        sb.append(", ").append(logChannel);
        sb.append(", ").append(mutedRole);
        sb.append(", ").append(verifiedRole);
        sb.append(", ").append(reportChannel);
        sb.append(", ").append(voteChannel);
        sb.append(", ").append(suggestionChannel);
        sb.append(", ").append(prefix);

        sb.append(")");
        return sb.toString();
    }
}

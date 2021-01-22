/*
 * This file is generated by jOOQ.
 */
package org.igsq.igsqbot.entities.jooq.tables.records;


import org.igsq.igsqbot.entities.jooq.tables.Guilds;
import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record12;
import org.jooq.Row12;
import org.jooq.impl.UpdatableRecordImpl;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class GuildsRecord extends UpdatableRecordImpl<GuildsRecord> implements Record12<Long, Long, Long, Long, Long, Long, Long, Long, Long, Long, Long, String> {

    private static final long serialVersionUID = 1L;

    /**
     * Setter for <code>public.guilds.guild_id</code>.
     */
    public GuildsRecord setGuildId(Long value) {
        set(0, value);
        return this;
    }

    /**
     * Getter for <code>public.guilds.guild_id</code>.
     */
    public Long getGuildId() {
        return (Long) get(0);
    }

    /**
     * Setter for <code>public.guilds.log_channel</code>.
     */
    public GuildsRecord setLogChannel(Long value) {
        set(1, value);
        return this;
    }

    /**
     * Getter for <code>public.guilds.log_channel</code>.
     */
    public Long getLogChannel() {
        return (Long) get(1);
    }

    /**
     * Setter for <code>public.guilds.muted_role</code>.
     */
    public GuildsRecord setMutedRole(Long value) {
        set(2, value);
        return this;
    }

    /**
     * Getter for <code>public.guilds.muted_role</code>.
     */
    public Long getMutedRole() {
        return (Long) get(2);
    }

    /**
     * Setter for <code>public.guilds.verified_role</code>.
     */
    public GuildsRecord setVerifiedRole(Long value) {
        set(3, value);
        return this;
    }

    /**
     * Getter for <code>public.guilds.verified_role</code>.
     */
    public Long getVerifiedRole() {
        return (Long) get(3);
    }

    /**
     * Setter for <code>public.guilds.report_channel</code>.
     */
    public GuildsRecord setReportChannel(Long value) {
        set(4, value);
        return this;
    }

    /**
     * Getter for <code>public.guilds.report_channel</code>.
     */
    public Long getReportChannel() {
        return (Long) get(4);
    }

    /**
     * Setter for <code>public.guilds.vote_channel</code>.
     */
    public GuildsRecord setVoteChannel(Long value) {
        set(5, value);
        return this;
    }

    /**
     * Getter for <code>public.guilds.vote_channel</code>.
     */
    public Long getVoteChannel() {
        return (Long) get(5);
    }

    /**
     * Setter for <code>public.guilds.suggestion_channel</code>.
     */
    public GuildsRecord setSuggestionChannel(Long value) {
        set(6, value);
        return this;
    }

    /**
     * Getter for <code>public.guilds.suggestion_channel</code>.
     */
    public Long getSuggestionChannel() {
        return (Long) get(6);
    }

    /**
     * Setter for <code>public.guilds.channel_suggestion_channel</code>.
     */
    public GuildsRecord setChannelSuggestionChannel(Long value) {
        set(7, value);
        return this;
    }

    /**
     * Getter for <code>public.guilds.channel_suggestion_channel</code>.
     */
    public Long getChannelSuggestionChannel() {
        return (Long) get(7);
    }

    /**
     * Setter for <code>public.guilds.self_promo_channel</code>.
     */
    public GuildsRecord setSelfPromoChannel(Long value) {
        set(8, value);
        return this;
    }

    /**
     * Getter for <code>public.guilds.self_promo_channel</code>.
     */
    public Long getSelfPromoChannel() {
        return (Long) get(8);
    }

    /**
     * Setter for <code>public.guilds.self_promo_role</code>.
     */
    public GuildsRecord setSelfPromoRole(Long value) {
        set(9, value);
        return this;
    }

    /**
     * Getter for <code>public.guilds.self_promo_role</code>.
     */
    public Long getSelfPromoRole() {
        return (Long) get(9);
    }

    /**
     * Setter for <code>public.guilds.level_up_bot</code>.
     */
    public GuildsRecord setLevelUpBot(Long value) {
        set(10, value);
        return this;
    }

    /**
     * Getter for <code>public.guilds.level_up_bot</code>.
     */
    public Long getLevelUpBot() {
        return (Long) get(10);
    }

    /**
     * Setter for <code>public.guilds.prefix</code>.
     */
    public GuildsRecord setPrefix(String value) {
        set(11, value);
        return this;
    }

    /**
     * Getter for <code>public.guilds.prefix</code>.
     */
    public String getPrefix() {
        return (String) get(11);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    @Override
    public Record1<Long> key() {
        return (Record1) super.key();
    }

    // -------------------------------------------------------------------------
    // Record12 type implementation
    // -------------------------------------------------------------------------

    @Override
    public Row12<Long, Long, Long, Long, Long, Long, Long, Long, Long, Long, Long, String> fieldsRow() {
        return (Row12) super.fieldsRow();
    }

    @Override
    public Row12<Long, Long, Long, Long, Long, Long, Long, Long, Long, Long, Long, String> valuesRow() {
        return (Row12) super.valuesRow();
    }

    @Override
    public Field<Long> field1() {
        return Guilds.GUILDS.GUILD_ID;
    }

    @Override
    public Field<Long> field2() {
        return Guilds.GUILDS.LOG_CHANNEL;
    }

    @Override
    public Field<Long> field3() {
        return Guilds.GUILDS.MUTED_ROLE;
    }

    @Override
    public Field<Long> field4() {
        return Guilds.GUILDS.VERIFIED_ROLE;
    }

    @Override
    public Field<Long> field5() {
        return Guilds.GUILDS.REPORT_CHANNEL;
    }

    @Override
    public Field<Long> field6() {
        return Guilds.GUILDS.VOTE_CHANNEL;
    }

    @Override
    public Field<Long> field7() {
        return Guilds.GUILDS.SUGGESTION_CHANNEL;
    }

    @Override
    public Field<Long> field8() {
        return Guilds.GUILDS.CHANNEL_SUGGESTION_CHANNEL;
    }

    @Override
    public Field<Long> field9() {
        return Guilds.GUILDS.SELF_PROMO_CHANNEL;
    }

    @Override
    public Field<Long> field10() {
        return Guilds.GUILDS.SELF_PROMO_ROLE;
    }

    @Override
    public Field<Long> field11() {
        return Guilds.GUILDS.LEVEL_UP_BOT;
    }

    @Override
    public Field<String> field12() {
        return Guilds.GUILDS.PREFIX;
    }

    @Override
    public Long component1() {
        return getGuildId();
    }

    @Override
    public Long component2() {
        return getLogChannel();
    }

    @Override
    public Long component3() {
        return getMutedRole();
    }

    @Override
    public Long component4() {
        return getVerifiedRole();
    }

    @Override
    public Long component5() {
        return getReportChannel();
    }

    @Override
    public Long component6() {
        return getVoteChannel();
    }

    @Override
    public Long component7() {
        return getSuggestionChannel();
    }

    @Override
    public Long component8() {
        return getChannelSuggestionChannel();
    }

    @Override
    public Long component9() {
        return getSelfPromoChannel();
    }

    @Override
    public Long component10() {
        return getSelfPromoRole();
    }

    @Override
    public Long component11() {
        return getLevelUpBot();
    }

    @Override
    public String component12() {
        return getPrefix();
    }

    @Override
    public Long value1() {
        return getGuildId();
    }

    @Override
    public Long value2() {
        return getLogChannel();
    }

    @Override
    public Long value3() {
        return getMutedRole();
    }

    @Override
    public Long value4() {
        return getVerifiedRole();
    }

    @Override
    public Long value5() {
        return getReportChannel();
    }

    @Override
    public Long value6() {
        return getVoteChannel();
    }

    @Override
    public Long value7() {
        return getSuggestionChannel();
    }

    @Override
    public Long value8() {
        return getChannelSuggestionChannel();
    }

    @Override
    public Long value9() {
        return getSelfPromoChannel();
    }

    @Override
    public Long value10() {
        return getSelfPromoRole();
    }

    @Override
    public Long value11() {
        return getLevelUpBot();
    }

    @Override
    public String value12() {
        return getPrefix();
    }

    @Override
    public GuildsRecord value1(Long value) {
        setGuildId(value);
        return this;
    }

    @Override
    public GuildsRecord value2(Long value) {
        setLogChannel(value);
        return this;
    }

    @Override
    public GuildsRecord value3(Long value) {
        setMutedRole(value);
        return this;
    }

    @Override
    public GuildsRecord value4(Long value) {
        setVerifiedRole(value);
        return this;
    }

    @Override
    public GuildsRecord value5(Long value) {
        setReportChannel(value);
        return this;
    }

    @Override
    public GuildsRecord value6(Long value) {
        setVoteChannel(value);
        return this;
    }

    @Override
    public GuildsRecord value7(Long value) {
        setSuggestionChannel(value);
        return this;
    }

    @Override
    public GuildsRecord value8(Long value) {
        setChannelSuggestionChannel(value);
        return this;
    }

    @Override
    public GuildsRecord value9(Long value) {
        setSelfPromoChannel(value);
        return this;
    }

    @Override
    public GuildsRecord value10(Long value) {
        setSelfPromoRole(value);
        return this;
    }

    @Override
    public GuildsRecord value11(Long value) {
        setLevelUpBot(value);
        return this;
    }

    @Override
    public GuildsRecord value12(String value) {
        setPrefix(value);
        return this;
    }

    @Override
    public GuildsRecord values(Long value1, Long value2, Long value3, Long value4, Long value5, Long value6, Long value7, Long value8, Long value9, Long value10, Long value11, String value12) {
        value1(value1);
        value2(value2);
        value3(value3);
        value4(value4);
        value5(value5);
        value6(value6);
        value7(value7);
        value8(value8);
        value9(value9);
        value10(value10);
        value11(value11);
        value12(value12);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached GuildsRecord
     */
    public GuildsRecord() {
        super(Guilds.GUILDS);
    }

    /**
     * Create a detached, initialised GuildsRecord
     */
    public GuildsRecord(Long guildId, Long logChannel, Long mutedRole, Long verifiedRole, Long reportChannel, Long voteChannel, Long suggestionChannel, Long channelSuggestionChannel, Long selfPromoChannel, Long selfPromoRole, Long levelUpBot, String prefix) {
        super(Guilds.GUILDS);

        setGuildId(guildId);
        setLogChannel(logChannel);
        setMutedRole(mutedRole);
        setVerifiedRole(verifiedRole);
        setReportChannel(reportChannel);
        setVoteChannel(voteChannel);
        setSuggestionChannel(suggestionChannel);
        setChannelSuggestionChannel(channelSuggestionChannel);
        setSelfPromoChannel(selfPromoChannel);
        setSelfPromoRole(selfPromoRole);
        setLevelUpBot(levelUpBot);
        setPrefix(prefix);
    }
}

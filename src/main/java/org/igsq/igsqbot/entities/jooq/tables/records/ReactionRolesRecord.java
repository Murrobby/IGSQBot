/*
 * This file is generated by jOOQ.
 */
package org.igsq.igsqbot.entities.jooq.tables.records;


import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record5;
import org.jooq.Row5;
import org.igsq.igsqbot.entities.jooq.tables.ReactionRoles;
import org.jooq.impl.UpdatableRecordImpl;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class ReactionRolesRecord extends UpdatableRecordImpl<ReactionRolesRecord> implements Record5<Long, Long, Long, String, Long> {

    private static final long serialVersionUID = 1L;

    /**
     * Setter for <code>public.reaction_roles.id</code>.
     */
    public ReactionRolesRecord setId(Long value) {
        set(0, value);
        return this;
    }

    /**
     * Getter for <code>public.reaction_roles.id</code>.
     */
    public Long getId() {
        return (Long) get(0);
    }

    /**
     * Setter for <code>public.reaction_roles.message_id</code>.
     */
    public ReactionRolesRecord setMessageId(Long value) {
        set(1, value);
        return this;
    }

    /**
     * Getter for <code>public.reaction_roles.message_id</code>.
     */
    public Long getMessageId() {
        return (Long) get(1);
    }

    /**
     * Setter for <code>public.reaction_roles.guild_id</code>.
     */
    public ReactionRolesRecord setGuildId(Long value) {
        set(2, value);
        return this;
    }

    /**
     * Getter for <code>public.reaction_roles.guild_id</code>.
     */
    public Long getGuildId() {
        return (Long) get(2);
    }

    /**
     * Setter for <code>public.reaction_roles.emote_id</code>.
     */
    public ReactionRolesRecord setEmoteId(String value) {
        set(3, value);
        return this;
    }

    /**
     * Getter for <code>public.reaction_roles.emote_id</code>.
     */
    public String getEmoteId() {
        return (String) get(3);
    }

    /**
     * Setter for <code>public.reaction_roles.role_id</code>.
     */
    public ReactionRolesRecord setRoleId(Long value) {
        set(4, value);
        return this;
    }

    /**
     * Getter for <code>public.reaction_roles.role_id</code>.
     */
    public Long getRoleId() {
        return (Long) get(4);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    @Override
    public Record1<Long> key() {
        return (Record1) super.key();
    }

    // -------------------------------------------------------------------------
    // Record5 type implementation
    // -------------------------------------------------------------------------

    @Override
    public Row5<Long, Long, Long, String, Long> fieldsRow() {
        return (Row5) super.fieldsRow();
    }

    @Override
    public Row5<Long, Long, Long, String, Long> valuesRow() {
        return (Row5) super.valuesRow();
    }

    @Override
    public Field<Long> field1() {
        return ReactionRoles.REACTION_ROLES.ID;
    }

    @Override
    public Field<Long> field2() {
        return ReactionRoles.REACTION_ROLES.MESSAGE_ID;
    }

    @Override
    public Field<Long> field3() {
        return ReactionRoles.REACTION_ROLES.GUILD_ID;
    }

    @Override
    public Field<String> field4() {
        return ReactionRoles.REACTION_ROLES.EMOTE_ID;
    }

    @Override
    public Field<Long> field5() {
        return ReactionRoles.REACTION_ROLES.ROLE_ID;
    }

    @Override
    public Long component1() {
        return getId();
    }

    @Override
    public Long component2() {
        return getMessageId();
    }

    @Override
    public Long component3() {
        return getGuildId();
    }

    @Override
    public String component4() {
        return getEmoteId();
    }

    @Override
    public Long component5() {
        return getRoleId();
    }

    @Override
    public Long value1() {
        return getId();
    }

    @Override
    public Long value2() {
        return getMessageId();
    }

    @Override
    public Long value3() {
        return getGuildId();
    }

    @Override
    public String value4() {
        return getEmoteId();
    }

    @Override
    public Long value5() {
        return getRoleId();
    }

    @Override
    public ReactionRolesRecord value1(Long value) {
        setId(value);
        return this;
    }

    @Override
    public ReactionRolesRecord value2(Long value) {
        setMessageId(value);
        return this;
    }

    @Override
    public ReactionRolesRecord value3(Long value) {
        setGuildId(value);
        return this;
    }

    @Override
    public ReactionRolesRecord value4(String value) {
        setEmoteId(value);
        return this;
    }

    @Override
    public ReactionRolesRecord value5(Long value) {
        setRoleId(value);
        return this;
    }

    @Override
    public ReactionRolesRecord values(Long value1, Long value2, Long value3, String value4, Long value5) {
        value1(value1);
        value2(value2);
        value3(value3);
        value4(value4);
        value5(value5);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached ReactionRolesRecord
     */
    public ReactionRolesRecord() {
        super(ReactionRoles.REACTION_ROLES);
    }

    /**
     * Create a detached, initialised ReactionRolesRecord
     */
    public ReactionRolesRecord(Long id, Long messageId, Long guildId, String emoteId, Long roleId) {
        super(ReactionRoles.REACTION_ROLES);

        setId(id);
        setMessageId(messageId);
        setGuildId(guildId);
        setEmoteId(emoteId);
        setRoleId(roleId);
    }
}

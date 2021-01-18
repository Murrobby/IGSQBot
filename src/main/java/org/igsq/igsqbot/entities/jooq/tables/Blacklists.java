/*
 * This file is generated by jOOQ.
 */
package org.igsq.igsqbot.entities.jooq.tables;


import java.util.Arrays;
import java.util.List;

import org.igsq.igsqbot.entities.jooq.Public;
import org.jooq.Field;
import org.jooq.ForeignKey;
import org.jooq.Identity;
import org.jooq.Name;
import org.jooq.Record;
import org.jooq.Row3;
import org.jooq.Schema;
import org.jooq.Table;
import org.jooq.TableField;
import org.jooq.TableOptions;
import org.jooq.UniqueKey;
import org.igsq.igsqbot.entities.jooq.Keys;
import org.igsq.igsqbot.entities.jooq.tables.records.BlacklistsRecord;
import org.jooq.impl.DSL;
import org.jooq.impl.SQLDataType;
import org.jooq.impl.TableImpl;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Blacklists extends TableImpl<BlacklistsRecord> {

    private static final long serialVersionUID = 1L;

    /**
     * The reference instance of <code>public.blacklists</code>
     */
    public static final Blacklists BLACKLISTS = new Blacklists();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<BlacklistsRecord> getRecordType() {
        return BlacklistsRecord.class;
    }

    /**
     * The column <code>public.blacklists.id</code>.
     */
    public final TableField<BlacklistsRecord, Long> ID = createField(DSL.name("id"), SQLDataType.BIGINT.nullable(false).identity(true), this, "");

    /**
     * The column <code>public.blacklists.guild_id</code>.
     */
    public final TableField<BlacklistsRecord, Long> GUILD_ID = createField(DSL.name("guild_id"), SQLDataType.BIGINT.nullable(false), this, "");

    /**
     * The column <code>public.blacklists.phrase</code>.
     */
    public final TableField<BlacklistsRecord, String> PHRASE = createField(DSL.name("phrase"), SQLDataType.CLOB.nullable(false), this, "");

    private Blacklists(Name alias, Table<BlacklistsRecord> aliased) {
        this(alias, aliased, null);
    }

    private Blacklists(Name alias, Table<BlacklistsRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""), TableOptions.table());
    }

    /**
     * Create an aliased <code>public.blacklists</code> table reference
     */
    public Blacklists(String alias) {
        this(DSL.name(alias), BLACKLISTS);
    }

    /**
     * Create an aliased <code>public.blacklists</code> table reference
     */
    public Blacklists(Name alias) {
        this(alias, BLACKLISTS);
    }

    /**
     * Create a <code>public.blacklists</code> table reference
     */
    public Blacklists() {
        this(DSL.name("blacklists"), null);
    }

    public <O extends Record> Blacklists(Table<O> child, ForeignKey<O, BlacklistsRecord> key) {
        super(child, key, BLACKLISTS);
    }

    @Override
    public Schema getSchema() {
        return Public.PUBLIC;
    }

    @Override
    public Identity<BlacklistsRecord, Long> getIdentity() {
        return (Identity<BlacklistsRecord, Long>) super.getIdentity();
    }

    @Override
    public UniqueKey<BlacklistsRecord> getPrimaryKey() {
        return Keys.BLACKLISTS_PKEY;
    }

    @Override
    public List<UniqueKey<BlacklistsRecord>> getKeys() {
        return Arrays.<UniqueKey<BlacklistsRecord>>asList(Keys.BLACKLISTS_PKEY);
    }

    @Override
    public List<ForeignKey<BlacklistsRecord, ?>> getReferences() {
        return Arrays.<ForeignKey<BlacklistsRecord, ?>>asList(Keys.BLACKLISTS__BLACKLISTS_GUILD_ID_FKEY);
    }

    public Guilds guilds() {
        return new Guilds(this, Keys.BLACKLISTS__BLACKLISTS_GUILD_ID_FKEY);
    }

    @Override
    public Blacklists as(String alias) {
        return new Blacklists(DSL.name(alias), this);
    }

    @Override
    public Blacklists as(Name alias) {
        return new Blacklists(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public Blacklists rename(String name) {
        return new Blacklists(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public Blacklists rename(Name name) {
        return new Blacklists(name, null);
    }

    // -------------------------------------------------------------------------
    // Row3 type methods
    // -------------------------------------------------------------------------

    @Override
    public Row3<Long, Long, String> fieldsRow() {
        return (Row3) super.fieldsRow();
    }
}

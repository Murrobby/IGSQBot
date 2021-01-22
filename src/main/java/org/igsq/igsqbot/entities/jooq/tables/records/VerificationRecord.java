/*
 * This file is generated by jOOQ.
 */
package org.igsq.igsqbot.entities.jooq.tables.records;


import org.igsq.igsqbot.entities.jooq.tables.Verification;
import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record4;
import org.jooq.Row4;
import org.jooq.impl.UpdatableRecordImpl;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({"all", "unchecked", "rawtypes"})
public class VerificationRecord extends UpdatableRecordImpl<VerificationRecord>
		implements Record4<Long, Long, String, Long>
{

	private static final long serialVersionUID = 1L;

	/**
	 * Create a detached VerificationRecord
	 */
	public VerificationRecord()
	{
		super(Verification.VERIFICATION);
	}

	/**
	 * Create a detached, initialised VerificationRecord
	 */
	public VerificationRecord(Long id, Long guildId, String phrase, Long roleId)
	{
		super(Verification.VERIFICATION);

		setId(id);
		setGuildId(guildId);
		setPhrase(phrase);
		setRoleId(roleId);
	}

	/**
	 * Getter for <code>public.verification.id</code>.
	 */
	public Long getId()
	{
		return (Long) get(0);
	}

	/**
	 * Setter for <code>public.verification.id</code>.
	 */
	public VerificationRecord setId(Long value)
	{
		set(0, value);
		return this;
	}

	/**
	 * Getter for <code>public.verification.guild_id</code>.
	 */
	public Long getGuildId()
	{
		return (Long) get(1);
	}

	/**
	 * Setter for <code>public.verification.guild_id</code>.
	 */
	public VerificationRecord setGuildId(Long value)
	{
		set(1, value);
		return this;
	}

	/**
	 * Getter for <code>public.verification.phrase</code>.
	 */
	public String getPhrase()
	{
		return (String) get(2);
	}

	/**
	 * Setter for <code>public.verification.phrase</code>.
	 */
	public VerificationRecord setPhrase(String value)
	{
		set(2, value);
		return this;
	}

	// -------------------------------------------------------------------------
	// Primary key information
	// -------------------------------------------------------------------------

	/**
	 * Getter for <code>public.verification.role_id</code>.
	 */
	public Long getRoleId()
	{
		return (Long) get(3);
	}

	// -------------------------------------------------------------------------
	// Record4 type implementation
	// -------------------------------------------------------------------------

	/**
	 * Setter for <code>public.verification.role_id</code>.
	 */
	public VerificationRecord setRoleId(Long value)
	{
		set(3, value);
		return this;
	}

	@Override
	public Record1<Long> key()
	{
		return (Record1) super.key();
	}

	@Override
	public Row4<Long, Long, String, Long> fieldsRow()
	{
		return (Row4) super.fieldsRow();
	}

	@Override
	public Row4<Long, Long, String, Long> valuesRow()
	{
		return (Row4) super.valuesRow();
	}

	@Override
	public Field<Long> field1()
	{
		return Verification.VERIFICATION.ID;
	}

	@Override
	public Field<Long> field2()
	{
		return Verification.VERIFICATION.GUILD_ID;
	}

	@Override
	public Field<String> field3()
	{
		return Verification.VERIFICATION.PHRASE;
	}

	@Override
	public Field<Long> field4()
	{
		return Verification.VERIFICATION.ROLE_ID;
	}

	@Override
	public Long component1()
	{
		return getId();
	}

	@Override
	public Long component2()
	{
		return getGuildId();
	}

	@Override
	public String component3()
	{
		return getPhrase();
	}

	@Override
	public Long component4()
	{
		return getRoleId();
	}

	@Override
	public Long value1()
	{
		return getId();
	}

	@Override
	public Long value2()
	{
		return getGuildId();
	}

	@Override
	public String value3()
	{
		return getPhrase();
	}

	@Override
	public Long value4()
	{
		return getRoleId();
	}

	@Override
	public VerificationRecord value1(Long value)
	{
		setId(value);
		return this;
	}

	@Override
	public VerificationRecord value2(Long value)
	{
		setGuildId(value);
		return this;
	}

	@Override
	public VerificationRecord value3(String value)
	{
		setPhrase(value);
		return this;
	}

	// -------------------------------------------------------------------------
	// Constructors
	// -------------------------------------------------------------------------

	@Override
	public VerificationRecord value4(Long value)
	{
		setRoleId(value);
		return this;
	}

	@Override
	public VerificationRecord values(Long value1, Long value2, String value3, Long value4)
	{
		value1(value1);
		value2(value2);
		value3(value3);
		value4(value4);
		return this;
	}
}

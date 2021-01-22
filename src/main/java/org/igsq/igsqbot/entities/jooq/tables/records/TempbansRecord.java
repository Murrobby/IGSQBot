/*
 * This file is generated by jOOQ.
 */
package org.igsq.igsqbot.entities.jooq.tables.records;


import java.time.LocalDateTime;
import org.igsq.igsqbot.entities.jooq.tables.Tempbans;
import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record4;
import org.jooq.Row4;
import org.jooq.impl.UpdatableRecordImpl;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({"all", "unchecked", "rawtypes"})
public class TempbansRecord extends UpdatableRecordImpl<TempbansRecord>
		implements Record4<Long, Long, Long, LocalDateTime>
{

	private static final long serialVersionUID = 1L;

	/**
	 * Create a detached TempbansRecord
	 */
	public TempbansRecord()
	{
		super(Tempbans.TEMPBANS);
	}

	/**
	 * Create a detached, initialised TempbansRecord
	 */
	public TempbansRecord(Long id, Long userId, Long guildId, LocalDateTime mutedUntil)
	{
		super(Tempbans.TEMPBANS);

		setId(id);
		setUserId(userId);
		setGuildId(guildId);
		setMutedUntil(mutedUntil);
	}

	/**
	 * Getter for <code>public.tempbans.id</code>.
	 */
	public Long getId()
	{
		return (Long) get(0);
	}

	/**
	 * Setter for <code>public.tempbans.id</code>.
	 */
	public TempbansRecord setId(Long value)
	{
		set(0, value);
		return this;
	}

	/**
	 * Getter for <code>public.tempbans.user_id</code>.
	 */
	public Long getUserId()
	{
		return (Long) get(1);
	}

	/**
	 * Setter for <code>public.tempbans.user_id</code>.
	 */
	public TempbansRecord setUserId(Long value)
	{
		set(1, value);
		return this;
	}

	/**
	 * Getter for <code>public.tempbans.guild_id</code>.
	 */
	public Long getGuildId()
	{
		return (Long) get(2);
	}

	/**
	 * Setter for <code>public.tempbans.guild_id</code>.
	 */
	public TempbansRecord setGuildId(Long value)
	{
		set(2, value);
		return this;
	}

	// -------------------------------------------------------------------------
	// Primary key information
	// -------------------------------------------------------------------------

	/**
	 * Getter for <code>public.tempbans.muted_until</code>.
	 */
	public LocalDateTime getMutedUntil()
	{
		return (LocalDateTime) get(3);
	}

	// -------------------------------------------------------------------------
	// Record4 type implementation
	// -------------------------------------------------------------------------

	/**
	 * Setter for <code>public.tempbans.muted_until</code>.
	 */
	public TempbansRecord setMutedUntil(LocalDateTime value)
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
	public Row4<Long, Long, Long, LocalDateTime> fieldsRow()
	{
		return (Row4) super.fieldsRow();
	}

	@Override
	public Row4<Long, Long, Long, LocalDateTime> valuesRow()
	{
		return (Row4) super.valuesRow();
	}

	@Override
	public Field<Long> field1()
	{
		return Tempbans.TEMPBANS.ID;
	}

	@Override
	public Field<Long> field2()
	{
		return Tempbans.TEMPBANS.USER_ID;
	}

	@Override
	public Field<Long> field3()
	{
		return Tempbans.TEMPBANS.GUILD_ID;
	}

	@Override
	public Field<LocalDateTime> field4()
	{
		return Tempbans.TEMPBANS.MUTED_UNTIL;
	}

	@Override
	public Long component1()
	{
		return getId();
	}

	@Override
	public Long component2()
	{
		return getUserId();
	}

	@Override
	public Long component3()
	{
		return getGuildId();
	}

	@Override
	public LocalDateTime component4()
	{
		return getMutedUntil();
	}

	@Override
	public Long value1()
	{
		return getId();
	}

	@Override
	public Long value2()
	{
		return getUserId();
	}

	@Override
	public Long value3()
	{
		return getGuildId();
	}

	@Override
	public LocalDateTime value4()
	{
		return getMutedUntil();
	}

	@Override
	public TempbansRecord value1(Long value)
	{
		setId(value);
		return this;
	}

	@Override
	public TempbansRecord value2(Long value)
	{
		setUserId(value);
		return this;
	}

	@Override
	public TempbansRecord value3(Long value)
	{
		setGuildId(value);
		return this;
	}

	// -------------------------------------------------------------------------
	// Constructors
	// -------------------------------------------------------------------------

	@Override
	public TempbansRecord value4(LocalDateTime value)
	{
		setMutedUntil(value);
		return this;
	}

	@Override
	public TempbansRecord values(Long value1, Long value2, Long value3, LocalDateTime value4)
	{
		value1(value1);
		value2(value2);
		value3(value3);
		value4(value4);
		return this;
	}
}

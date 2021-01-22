/*
 * This file is generated by jOOQ.
 */
package org.igsq.igsqbot.entities.jooq.tables.pojos;


import java.io.Serializable;
import java.time.LocalDateTime;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({"all", "unchecked", "rawtypes"})
public class Votes implements Serializable
{

	private static final long serialVersionUID = 1L;

	private final Long id;
	private final Long voteId;
	private final Long guildId;
	private final Long directMessageId;
	private final Long userId;
	private final Integer option;
	private final Integer maxOptions;
	private final LocalDateTime expiry;
	private final Boolean hasVoted;

	public Votes(Votes value)
	{
		this.id = value.id;
		this.voteId = value.voteId;
		this.guildId = value.guildId;
		this.directMessageId = value.directMessageId;
		this.userId = value.userId;
		this.option = value.option;
		this.maxOptions = value.maxOptions;
		this.expiry = value.expiry;
		this.hasVoted = value.hasVoted;
	}

	public Votes(
			Long id,
			Long voteId,
			Long guildId,
			Long directMessageId,
			Long userId,
			Integer option,
			Integer maxOptions,
			LocalDateTime expiry,
			Boolean hasVoted
	)
	{
		this.id = id;
		this.voteId = voteId;
		this.guildId = guildId;
		this.directMessageId = directMessageId;
		this.userId = userId;
		this.option = option;
		this.maxOptions = maxOptions;
		this.expiry = expiry;
		this.hasVoted = hasVoted;
	}

	/**
	 * Getter for <code>public.votes.id</code>.
	 */
	public Long getId()
	{
		return this.id;
	}

	/**
	 * Getter for <code>public.votes.vote_id</code>.
	 */
	public Long getVoteId()
	{
		return this.voteId;
	}

	/**
	 * Getter for <code>public.votes.guild_id</code>.
	 */
	public Long getGuildId()
	{
		return this.guildId;
	}

	/**
	 * Getter for <code>public.votes.direct_message_id</code>.
	 */
	public Long getDirectMessageId()
	{
		return this.directMessageId;
	}

	/**
	 * Getter for <code>public.votes.user_id</code>.
	 */
	public Long getUserId()
	{
		return this.userId;
	}

	/**
	 * Getter for <code>public.votes.option</code>.
	 */
	public Integer getOption()
	{
		return this.option;
	}

	/**
	 * Getter for <code>public.votes.max_options</code>.
	 */
	public Integer getMaxOptions()
	{
		return this.maxOptions;
	}

	/**
	 * Getter for <code>public.votes.expiry</code>.
	 */
	public LocalDateTime getExpiry()
	{
		return this.expiry;
	}

	/**
	 * Getter for <code>public.votes.has_voted</code>.
	 */
	public Boolean getHasVoted()
	{
		return this.hasVoted;
	}

	@Override
	public String toString()
	{
		StringBuilder sb = new StringBuilder("Votes (");

		sb.append(id);
		sb.append(", ").append(voteId);
		sb.append(", ").append(guildId);
		sb.append(", ").append(directMessageId);
		sb.append(", ").append(userId);
		sb.append(", ").append(option);
		sb.append(", ").append(maxOptions);
		sb.append(", ").append(expiry);
		sb.append(", ").append(hasVoted);

		sb.append(")");
		return sb.toString();
	}
}

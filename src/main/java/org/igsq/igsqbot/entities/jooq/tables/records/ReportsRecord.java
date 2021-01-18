/*
 * This file is generated by jOOQ.
 */
package org.igsq.igsqbot.entities.jooq.tables.records;


import java.time.LocalDateTime;

import org.igsq.igsqbot.entities.jooq.tables.Reports;
import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record8;
import org.jooq.Row8;
import org.jooq.impl.UpdatableRecordImpl;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class ReportsRecord extends UpdatableRecordImpl<ReportsRecord> implements Record8<Long, Long, Long, Long, Long, Long, LocalDateTime, String> {

    private static final long serialVersionUID = 1L;

    /**
     * Setter for <code>public.reports.id</code>.
     */
    public ReportsRecord setId(Long value) {
        set(0, value);
        return this;
    }

    /**
     * Getter for <code>public.reports.id</code>.
     */
    public Long getId() {
        return (Long) get(0);
    }

    /**
     * Setter for <code>public.reports.message_id</code>.
     */
    public ReportsRecord setMessageId(Long value) {
        set(1, value);
        return this;
    }

    /**
     * Getter for <code>public.reports.message_id</code>.
     */
    public Long getMessageId() {
        return (Long) get(1);
    }

    /**
     * Setter for <code>public.reports.report_message_id</code>.
     */
    public ReportsRecord setReportMessageId(Long value) {
        set(2, value);
        return this;
    }

    /**
     * Getter for <code>public.reports.report_message_id</code>.
     */
    public Long getReportMessageId() {
        return (Long) get(2);
    }

    /**
     * Setter for <code>public.reports.channel_id</code>.
     */
    public ReportsRecord setChannelId(Long value) {
        set(3, value);
        return this;
    }

    /**
     * Getter for <code>public.reports.channel_id</code>.
     */
    public Long getChannelId() {
        return (Long) get(3);
    }

    /**
     * Setter for <code>public.reports.guild_id</code>.
     */
    public ReportsRecord setGuildId(Long value) {
        set(4, value);
        return this;
    }

    /**
     * Getter for <code>public.reports.guild_id</code>.
     */
    public Long getGuildId() {
        return (Long) get(4);
    }

    /**
     * Setter for <code>public.reports.user_id</code>.
     */
    public ReportsRecord setUserId(Long value) {
        set(5, value);
        return this;
    }

    /**
     * Getter for <code>public.reports.user_id</code>.
     */
    public Long getUserId() {
        return (Long) get(5);
    }

    /**
     * Setter for <code>public.reports.timestamp</code>.
     */
    public ReportsRecord setTimestamp(LocalDateTime value) {
        set(6, value);
        return this;
    }

    /**
     * Getter for <code>public.reports.timestamp</code>.
     */
    public LocalDateTime getTimestamp() {
        return (LocalDateTime) get(6);
    }

    /**
     * Setter for <code>public.reports.report_text</code>.
     */
    public ReportsRecord setReportText(String value) {
        set(7, value);
        return this;
    }

    /**
     * Getter for <code>public.reports.report_text</code>.
     */
    public String getReportText() {
        return (String) get(7);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    @Override
    public Record1<Long> key() {
        return (Record1) super.key();
    }

    // -------------------------------------------------------------------------
    // Record8 type implementation
    // -------------------------------------------------------------------------

    @Override
    public Row8<Long, Long, Long, Long, Long, Long, LocalDateTime, String> fieldsRow() {
        return (Row8) super.fieldsRow();
    }

    @Override
    public Row8<Long, Long, Long, Long, Long, Long, LocalDateTime, String> valuesRow() {
        return (Row8) super.valuesRow();
    }

    @Override
    public Field<Long> field1() {
        return Reports.REPORTS.ID;
    }

    @Override
    public Field<Long> field2() {
        return Reports.REPORTS.MESSAGE_ID;
    }

    @Override
    public Field<Long> field3() {
        return Reports.REPORTS.REPORT_MESSAGE_ID;
    }

    @Override
    public Field<Long> field4() {
        return Reports.REPORTS.CHANNEL_ID;
    }

    @Override
    public Field<Long> field5() {
        return Reports.REPORTS.GUILD_ID;
    }

    @Override
    public Field<Long> field6() {
        return Reports.REPORTS.USER_ID;
    }

    @Override
    public Field<LocalDateTime> field7() {
        return Reports.REPORTS.TIMESTAMP;
    }

    @Override
    public Field<String> field8() {
        return Reports.REPORTS.REPORT_TEXT;
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
        return getReportMessageId();
    }

    @Override
    public Long component4() {
        return getChannelId();
    }

    @Override
    public Long component5() {
        return getGuildId();
    }

    @Override
    public Long component6() {
        return getUserId();
    }

    @Override
    public LocalDateTime component7() {
        return getTimestamp();
    }

    @Override
    public String component8() {
        return getReportText();
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
        return getReportMessageId();
    }

    @Override
    public Long value4() {
        return getChannelId();
    }

    @Override
    public Long value5() {
        return getGuildId();
    }

    @Override
    public Long value6() {
        return getUserId();
    }

    @Override
    public LocalDateTime value7() {
        return getTimestamp();
    }

    @Override
    public String value8() {
        return getReportText();
    }

    @Override
    public ReportsRecord value1(Long value) {
        setId(value);
        return this;
    }

    @Override
    public ReportsRecord value2(Long value) {
        setMessageId(value);
        return this;
    }

    @Override
    public ReportsRecord value3(Long value) {
        setReportMessageId(value);
        return this;
    }

    @Override
    public ReportsRecord value4(Long value) {
        setChannelId(value);
        return this;
    }

    @Override
    public ReportsRecord value5(Long value) {
        setGuildId(value);
        return this;
    }

    @Override
    public ReportsRecord value6(Long value) {
        setUserId(value);
        return this;
    }

    @Override
    public ReportsRecord value7(LocalDateTime value) {
        setTimestamp(value);
        return this;
    }

    @Override
    public ReportsRecord value8(String value) {
        setReportText(value);
        return this;
    }

    @Override
    public ReportsRecord values(Long value1, Long value2, Long value3, Long value4, Long value5, Long value6, LocalDateTime value7, String value8) {
        value1(value1);
        value2(value2);
        value3(value3);
        value4(value4);
        value5(value5);
        value6(value6);
        value7(value7);
        value8(value8);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached ReportsRecord
     */
    public ReportsRecord() {
        super(Reports.REPORTS);
    }

    /**
     * Create a detached, initialised ReportsRecord
     */
    public ReportsRecord(Long id, Long messageId, Long reportMessageId, Long channelId, Long guildId, Long userId, LocalDateTime timestamp, String reportText) {
        super(Reports.REPORTS);

        setId(id);
        setMessageId(messageId);
        setReportMessageId(reportMessageId);
        setChannelId(channelId);
        setGuildId(guildId);
        setUserId(userId);
        setTimestamp(timestamp);
        setReportText(reportText);
    }
}

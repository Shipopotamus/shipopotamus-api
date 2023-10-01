/*
 * This file is generated by jOOQ.
 */
package com.github.shipopotamus.authentication.adapters.jooq.model.tables.records;


import com.github.shipopotamus.authentication.adapters.jooq.model.tables.Accounts;

import java.time.OffsetDateTime;
import java.util.UUID;

import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record5;
import org.jooq.Row5;
import org.jooq.impl.UpdatableRecordImpl;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class AccountsRecord extends UpdatableRecordImpl<AccountsRecord> implements Record5<UUID, UUID, String, OffsetDateTime, OffsetDateTime> {

    private static final long serialVersionUID = 1L;

    /**
     * Setter for <code>authentication_schema.accounts.id</code>.
     */
    public void setId(UUID value) {
        set(0, value);
    }

    /**
     * Getter for <code>authentication_schema.accounts.id</code>.
     */
    public UUID getId() {
        return (UUID) get(0);
    }

    /**
     * Setter for <code>authentication_schema.accounts.user_id</code>.
     */
    public void setUserId(UUID value) {
        set(1, value);
    }

    /**
     * Getter for <code>authentication_schema.accounts.user_id</code>.
     */
    public UUID getUserId() {
        return (UUID) get(1);
    }

    /**
     * Setter for <code>authentication_schema.accounts.email</code>.
     */
    public void setEmail(String value) {
        set(2, value);
    }

    /**
     * Getter for <code>authentication_schema.accounts.email</code>.
     */
    public String getEmail() {
        return (String) get(2);
    }

    /**
     * Setter for <code>authentication_schema.accounts.created_at</code>.
     */
    public void setCreatedAt(OffsetDateTime value) {
        set(3, value);
    }

    /**
     * Getter for <code>authentication_schema.accounts.created_at</code>.
     */
    public OffsetDateTime getCreatedAt() {
        return (OffsetDateTime) get(3);
    }

    /**
     * Setter for <code>authentication_schema.accounts.modified_at</code>.
     */
    public void setModifiedAt(OffsetDateTime value) {
        set(4, value);
    }

    /**
     * Getter for <code>authentication_schema.accounts.modified_at</code>.
     */
    public OffsetDateTime getModifiedAt() {
        return (OffsetDateTime) get(4);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    @Override
    public Record1<UUID> key() {
        return (Record1) super.key();
    }

    // -------------------------------------------------------------------------
    // Record5 type implementation
    // -------------------------------------------------------------------------

    @Override
    public Row5<UUID, UUID, String, OffsetDateTime, OffsetDateTime> fieldsRow() {
        return (Row5) super.fieldsRow();
    }

    @Override
    public Row5<UUID, UUID, String, OffsetDateTime, OffsetDateTime> valuesRow() {
        return (Row5) super.valuesRow();
    }

    @Override
    public Field<UUID> field1() {
        return Accounts.ACCOUNTS.ID;
    }

    @Override
    public Field<UUID> field2() {
        return Accounts.ACCOUNTS.USER_ID;
    }

    @Override
    public Field<String> field3() {
        return Accounts.ACCOUNTS.EMAIL;
    }

    @Override
    public Field<OffsetDateTime> field4() {
        return Accounts.ACCOUNTS.CREATED_AT;
    }

    @Override
    public Field<OffsetDateTime> field5() {
        return Accounts.ACCOUNTS.MODIFIED_AT;
    }

    @Override
    public UUID component1() {
        return getId();
    }

    @Override
    public UUID component2() {
        return getUserId();
    }

    @Override
    public String component3() {
        return getEmail();
    }

    @Override
    public OffsetDateTime component4() {
        return getCreatedAt();
    }

    @Override
    public OffsetDateTime component5() {
        return getModifiedAt();
    }

    @Override
    public UUID value1() {
        return getId();
    }

    @Override
    public UUID value2() {
        return getUserId();
    }

    @Override
    public String value3() {
        return getEmail();
    }

    @Override
    public OffsetDateTime value4() {
        return getCreatedAt();
    }

    @Override
    public OffsetDateTime value5() {
        return getModifiedAt();
    }

    @Override
    public AccountsRecord value1(UUID value) {
        setId(value);
        return this;
    }

    @Override
    public AccountsRecord value2(UUID value) {
        setUserId(value);
        return this;
    }

    @Override
    public AccountsRecord value3(String value) {
        setEmail(value);
        return this;
    }

    @Override
    public AccountsRecord value4(OffsetDateTime value) {
        setCreatedAt(value);
        return this;
    }

    @Override
    public AccountsRecord value5(OffsetDateTime value) {
        setModifiedAt(value);
        return this;
    }

    @Override
    public AccountsRecord values(UUID value1, UUID value2, String value3, OffsetDateTime value4, OffsetDateTime value5) {
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
     * Create a detached AccountsRecord
     */
    public AccountsRecord() {
        super(Accounts.ACCOUNTS);
    }

    /**
     * Create a detached, initialised AccountsRecord
     */
    public AccountsRecord(UUID id, UUID userId, String email, OffsetDateTime createdAt, OffsetDateTime modifiedAt) {
        super(Accounts.ACCOUNTS);

        setId(id);
        setUserId(userId);
        setEmail(email);
        setCreatedAt(createdAt);
        setModifiedAt(modifiedAt);
        resetChangedOnNotNull();
    }
}
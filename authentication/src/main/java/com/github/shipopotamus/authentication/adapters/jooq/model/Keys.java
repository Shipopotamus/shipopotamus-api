/*
 * This file is generated by jOOQ.
 */
package com.github.shipopotamus.authentication.adapters.jooq.model;


import com.github.shipopotamus.authentication.adapters.jooq.model.tables.Accounts;
import com.github.shipopotamus.authentication.adapters.jooq.model.tables.AuthenticationMethods;
import com.github.shipopotamus.authentication.adapters.jooq.model.tables.EmailPasswordAuthentications;
import com.github.shipopotamus.authentication.adapters.jooq.model.tables.Users;
import com.github.shipopotamus.authentication.adapters.jooq.model.tables.records.AccountsRecord;
import com.github.shipopotamus.authentication.adapters.jooq.model.tables.records.AuthenticationMethodsRecord;
import com.github.shipopotamus.authentication.adapters.jooq.model.tables.records.EmailPasswordAuthenticationsRecord;
import com.github.shipopotamus.authentication.adapters.jooq.model.tables.records.UsersRecord;

import org.jooq.ForeignKey;
import org.jooq.TableField;
import org.jooq.UniqueKey;
import org.jooq.impl.DSL;
import org.jooq.impl.Internal;


/**
 * A class modelling foreign key relationships and constraints of tables in
 * authentication_schema.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Keys {

    // -------------------------------------------------------------------------
    // UNIQUE and PRIMARY KEY definitions
    // -------------------------------------------------------------------------

    public static final UniqueKey<AccountsRecord> ACCOUNTS_PKEY = Internal.createUniqueKey(Accounts.ACCOUNTS, DSL.name("accounts_pkey"), new TableField[] { Accounts.ACCOUNTS.ID }, true);
    public static final UniqueKey<AuthenticationMethodsRecord> AUTHENTICATION_METHODS_PKEY = Internal.createUniqueKey(AuthenticationMethods.AUTHENTICATION_METHODS, DSL.name("authentication_methods_pkey"), new TableField[] { AuthenticationMethods.AUTHENTICATION_METHODS.ID }, true);
    public static final UniqueKey<EmailPasswordAuthenticationsRecord> EMAIL_PASSWORD_AUTHENTICATIONS_PKEY = Internal.createUniqueKey(EmailPasswordAuthentications.EMAIL_PASSWORD_AUTHENTICATIONS, DSL.name("email_password_authentications_pkey"), new TableField[] { EmailPasswordAuthentications.EMAIL_PASSWORD_AUTHENTICATIONS.AUTHENTICATION_METHOD_ID }, true);
    public static final UniqueKey<UsersRecord> USERS_PKEY = Internal.createUniqueKey(Users.USERS, DSL.name("users_pkey"), new TableField[] { Users.USERS.ID }, true);

    // -------------------------------------------------------------------------
    // FOREIGN KEY definitions
    // -------------------------------------------------------------------------

    public static final ForeignKey<AccountsRecord, UsersRecord> ACCOUNTS__ACCOUNTS_USER_ID_FKEY = Internal.createForeignKey(Accounts.ACCOUNTS, DSL.name("accounts_user_id_fkey"), new TableField[] { Accounts.ACCOUNTS.USER_ID }, Keys.USERS_PKEY, new TableField[] { Users.USERS.ID }, true);
    public static final ForeignKey<AuthenticationMethodsRecord, AccountsRecord> AUTHENTICATION_METHODS__AUTHENTICATION_METHODS_ACCOUNT_ID_FKEY = Internal.createForeignKey(AuthenticationMethods.AUTHENTICATION_METHODS, DSL.name("authentication_methods_account_id_fkey"), new TableField[] { AuthenticationMethods.AUTHENTICATION_METHODS.ACCOUNT_ID }, Keys.ACCOUNTS_PKEY, new TableField[] { Accounts.ACCOUNTS.ID }, true);
    public static final ForeignKey<EmailPasswordAuthenticationsRecord, AuthenticationMethodsRecord> EMAIL_PASSWORD_AUTHENTICATIONS__EMAIL_PASSWORD_AUTHENTICATIONS_AUTHENTICATION_METHOD_ID_FKEY = Internal.createForeignKey(EmailPasswordAuthentications.EMAIL_PASSWORD_AUTHENTICATIONS, DSL.name("email_password_authentications_authentication_method_id_fkey"), new TableField[] { EmailPasswordAuthentications.EMAIL_PASSWORD_AUTHENTICATIONS.AUTHENTICATION_METHOD_ID }, Keys.AUTHENTICATION_METHODS_PKEY, new TableField[] { AuthenticationMethods.AUTHENTICATION_METHODS.ID }, true);
}

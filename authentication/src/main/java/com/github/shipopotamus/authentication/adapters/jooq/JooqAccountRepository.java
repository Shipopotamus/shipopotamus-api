package com.github.shipopotamus.authentication.adapters.jooq;

import java.time.ZoneOffset;

import com.github.shipopotamus.authentication.adapters.jooq.model.tables.records.AccountsRecord;
import com.github.shipopotamus.authentication.adapters.jooq.model.tables.records.AuthenticationMethodsRecord;
import com.github.shipopotamus.authentication.adapters.jooq.model.tables.records.EmailPasswordAuthenticationsRecord;
import com.github.shipopotamus.authentication.domain.account.Account;
import com.github.shipopotamus.authentication.domain.account.AccountRepository;
import lombok.RequiredArgsConstructor;
import org.jooq.DSLContext;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class JooqAccountRepository implements AccountRepository {

    private final DSLContext dslContext;

    @Override
    public void save(Account account) {
        final var accountsRecord = new AccountsRecord(
                account.getId().value(),
                account.getUserId().value(),
                account.getEmail().getValue(),
                account.getCreatedAt().atOffset(ZoneOffset.UTC),
                account.getCreatedAt().atOffset(ZoneOffset.UTC)
        );

        final var authenticationMethods = account.getAuthenticationMethods();
        final var emailPasswordAuthenticationMethod = authenticationMethods.getEmailPasswordAuthenticationMethod();
        final var authenticationMethodsRecord = new AuthenticationMethodsRecord(
                emailPasswordAuthenticationMethod.getId().value(),
                account.getId().value(),
                emailPasswordAuthenticationMethod.getType().name(),
                account.getCreatedAt().atOffset(ZoneOffset.UTC)
        );
        final var emailPasswordAuthenticationsRecord = new EmailPasswordAuthenticationsRecord(
                emailPasswordAuthenticationMethod.getId().value(),
                emailPasswordAuthenticationMethod.getEmail().getValue(),
                emailPasswordAuthenticationMethod.getEncodedPassword().getValue(),
                account.getCreatedAt().atOffset(ZoneOffset.UTC)
        );

        dslContext.batchInsert(accountsRecord, authenticationMethodsRecord, emailPasswordAuthenticationsRecord).execute();
    }

}

package com.github.shipopotamus.authentication.domain;

import java.time.Clock;
import java.time.Instant;

import com.github.shipopotamus.authentication.domain.account.Account;
import com.github.shipopotamus.authentication.domain.account.AccountId;
import com.github.shipopotamus.authentication.domain.account.AccountRepository;
import com.github.shipopotamus.authentication.domain.account.authentication.method.AuthenticationMethods;
import com.github.shipopotamus.authentication.domain.account.authentication.method.emailpassword.EmailPasswordAuthenticationMethod;
import com.github.shipopotamus.authentication.domain.account.authentication.method.emailpassword.EncodedPassword;
import com.github.shipopotamus.authentication.domain.account.Email;
import com.github.shipopotamus.authentication.domain.user.UserId;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import static java.util.UUID.randomUUID;

@Service
@RequiredArgsConstructor
public class SignUpService {

    private final AccountRepository accountRepository;
    private final Clock clock;

    public void signUpWithEmailPassword(Email email, EncodedPassword encodedPassword) {
        final var userId = new UserId(randomUUID());
        final var accountId = new AccountId(randomUUID());

        final var createdAt = Instant.now(clock);

        final var emailPasswordAuthenticationMethod = EmailPasswordAuthenticationMethod.createNew(accountId, email, encodedPassword, createdAt);
        final var account = Account.of(accountId, userId, email, AuthenticationMethods.of(emailPasswordAuthenticationMethod), createdAt, createdAt);

        accountRepository.save(account);
    }

}

package com.github.shipopotamus.authentication.domain.account.authentication.method.emailpassword;

import java.time.Instant;
import java.util.UUID;

import com.github.shipopotamus.authentication.domain.account.AccountId;
import com.github.shipopotamus.authentication.domain.account.authentication.method.AuthenticationMethodId;
import com.github.shipopotamus.authentication.domain.account.authentication.method.AuthenticationMethodType;
import com.github.shipopotamus.authentication.domain.account.Email;
import lombok.NonNull;
import lombok.Value;

@Value(staticConstructor = "of")
public class EmailPasswordAuthenticationMethod {
    @NonNull AuthenticationMethodType type = AuthenticationMethodType.EMAIL_PASSWORD;
    @NonNull AuthenticationMethodId id;
    @NonNull AccountId accountId;
    @NonNull Email email;
    @NonNull EncodedPassword encodedPassword;
    @NonNull Instant createdAt;

    public static EmailPasswordAuthenticationMethod createNew(AccountId accountId,
                                                              Email email,
                                                              EncodedPassword encodedPassword,
                                                              Instant createdAt) {
        return new EmailPasswordAuthenticationMethod(
                new AuthenticationMethodId(UUID.randomUUID()),
                accountId,
                email,
                encodedPassword,
                createdAt
        );
    }

}

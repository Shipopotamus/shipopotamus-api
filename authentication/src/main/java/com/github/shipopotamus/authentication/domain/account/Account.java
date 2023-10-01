package com.github.shipopotamus.authentication.domain.account;

import java.time.Instant;

import com.github.shipopotamus.authentication.domain.account.authentication.method.AuthenticationMethods;
import com.github.shipopotamus.authentication.domain.user.UserId;
import lombok.NonNull;
import lombok.Value;

@Value(staticConstructor = "of")
public class Account {
    @NonNull AccountId id;
    @NonNull UserId userId;
    @NonNull Email email;
    @NonNull AuthenticationMethods authenticationMethods;
    @NonNull Instant createdAt;
    @NonNull Instant modifiedAt;
}

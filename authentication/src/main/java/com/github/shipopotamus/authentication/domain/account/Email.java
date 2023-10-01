package com.github.shipopotamus.authentication.domain.account;

import lombok.NonNull;
import lombok.Value;

@Value(staticConstructor = "of")
public class Email {
    @NonNull String value;
}

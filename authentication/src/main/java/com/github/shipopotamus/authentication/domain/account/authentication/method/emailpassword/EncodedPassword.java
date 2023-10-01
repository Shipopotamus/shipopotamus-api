package com.github.shipopotamus.authentication.domain.account.authentication.method.emailpassword;

import lombok.NonNull;
import lombok.Value;

@Value(staticConstructor = "of")
public class EncodedPassword {
    @NonNull String value;
}

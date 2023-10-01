package com.github.shipopotamus.authentication.domain.account.authentication.method;

import com.github.shipopotamus.authentication.domain.account.authentication.method.emailpassword.EmailPasswordAuthenticationMethod;
import lombok.NonNull;
import lombok.Value;

@Value(staticConstructor = "of")
public class AuthenticationMethods {
    @NonNull EmailPasswordAuthenticationMethod emailPasswordAuthenticationMethod;
}

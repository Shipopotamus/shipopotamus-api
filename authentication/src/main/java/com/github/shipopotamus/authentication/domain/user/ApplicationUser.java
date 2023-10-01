package com.github.shipopotamus.authentication.domain.user;

import com.github.shipopotamus.authentication.domain.account.Email;
import com.github.shipopotamus.authentication.domain.account.authentication.method.emailpassword.EncodedPassword;
import lombok.NonNull;
import lombok.Value;

@Value(staticConstructor = "of")
public class ApplicationUser {
    @NonNull UserId id;
    @NonNull Email email;
    @NonNull EncodedPassword encodedPassword;

}

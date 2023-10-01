package com.github.shipopotamus.authentication.application;

import java.time.Clock;

import com.github.shipopotamus.authentication.adapters.rest.registration.EmailPasswordSignUpDto;
import com.github.shipopotamus.authentication.domain.SignUpService;
import com.github.shipopotamus.authentication.domain.account.Email;
import com.github.shipopotamus.authentication.domain.account.authentication.method.emailpassword.EncodedPassword;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class SignUpApplicationService {

    private final SignUpService signUpService;
    private final PasswordEncoder passwordEncoder;

    @Transactional
    public void signUp(EmailPasswordSignUpDto emailPasswordSignUpDto) {
        final var email = Email.of(emailPasswordSignUpDto.getEmail());
        final var encodedPassword = EncodedPassword.of(passwordEncoder.encode(emailPasswordSignUpDto.getPassword()));

        signUpService.signUpWithEmailPassword(email, encodedPassword);
    }

}

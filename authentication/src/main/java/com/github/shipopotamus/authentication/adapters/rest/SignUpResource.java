package com.github.shipopotamus.authentication.adapters.rest;

import com.github.shipopotamus.authentication.adapters.rest.registration.EmailPasswordSignUpDto;
import com.github.shipopotamus.authentication.application.SignUpApplicationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class SignUpResource {
    private final SignUpApplicationService signUpApplicationService;

    @PostMapping("/sign-up")
    public ResponseEntity<Void> signUpWithEmailPassword(@RequestBody EmailPasswordSignUpDto emailPasswordSignUpDto) {
        signUpApplicationService.signUp(emailPasswordSignUpDto);
        return ResponseEntity.noContent().build();
    }

}

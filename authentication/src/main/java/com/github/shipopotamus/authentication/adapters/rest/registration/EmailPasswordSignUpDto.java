package com.github.shipopotamus.authentication.adapters.rest.registration;

import lombok.Data;

@Data
public class EmailPasswordSignUpDto {
    private String email;
    private String password;
}

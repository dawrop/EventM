package com.example.backend.payload.request;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.util.Set;

@Data
public class SignupRequest {
    @NotBlank
    private String name;

    @NotBlank
    private String password;

    @NotBlank
    private String repeatPassword;

    @NotBlank
    @Email
    private String email;

    @JsonIgnore
    private Set<String> role;
}

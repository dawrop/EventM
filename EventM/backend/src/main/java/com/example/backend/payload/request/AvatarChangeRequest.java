package com.example.backend.payload.request;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class AvatarChangeRequest {
    @NotBlank
    private String avatarUuid;
}

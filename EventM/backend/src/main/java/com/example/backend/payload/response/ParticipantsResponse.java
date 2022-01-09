package com.example.backend.payload.response;

import lombok.Data;

@Data
public class ParticipantsResponse {
    private long id;
    private String name;
    private String avatar;
    private String city;
}

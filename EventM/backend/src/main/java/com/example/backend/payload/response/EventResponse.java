package com.example.backend.payload.response;

import lombok.Data;

@Data
public class EventResponse {
    private Long id;
    private Long hostId;
    private String title;
    private String description;
    private String category;
    private String address;
    private String date;
    private String time;
    private String picture;

    public EventResponse(Long id, Long hostId, String title, String description, String category, String address, String date, String time, String picture) {
        this.id = id;
        this.hostId = hostId;
        this.title = title;
        this.description = description;
        this.category = category;
        this.address = address;
        this.date = date;
        this.time = time;
        this.picture = picture;
    }
}

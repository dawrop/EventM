package com.example.backend.payload.response;

import com.example.backend.models.Event;
import lombok.Data;

@Data
public class EventResp {
    private long id;
    private String title;
    private String picture;

    public EventResp(Event event){
        this.id = event.getId();
        this.title = event.getTitle();
        this.picture = event.getPicture();
    }
}

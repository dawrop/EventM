package com.example.backend.payload.response;

import com.example.backend.models.Event;
import lombok.Data;

import java.util.Date;

@Data
public class EventResp {
    private long id;
    private String title;
    private String picture;
    private String city;
    private Date date;
    private Date time;
    private String category;
    private String hostName;

    public EventResp(Event event){
        this.id = event.getId();
        this.title = event.getTitle();
        this.picture = event.getPicture();
        this.city = event.getCity();
        this.date = event.getDate();
        this.time = event.getTime();
        this.category = event.getCategory();
        this.hostName = event.getUser().getName();
    }
}

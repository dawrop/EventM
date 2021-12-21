package com.example.backend.models;

import lombok.Data;

import javax.persistence.*;
import java.sql.Struct;
import java.util.Set;

@Entity
@Table(name = "events")
@Data
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long hostId;
    private String title;
    private String description;
    private String category;
    private String city;
    private String address;
    private String date;
    private String time;
    private String picture;

    @ManyToMany(mappedBy = "goingEvents")
    private Set<User> goingEvents;

    protected Event() {}

    public Event(Long id, Long hostId, String title, String description, String category, String city, String address, String date, String time, String picture) {
        this.id = id;
        this.hostId = hostId;
        this.title = title;
        this.description = description;
        this.city = city;
        this.category = category;
        this.address = address;
        this.date = date;
        this.time = time;
        this.picture = picture;
    }
}

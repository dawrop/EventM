package com.example.backend.models;

import com.fasterxml.jackson.annotation.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Struct;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "events")
@Setter
@Getter
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String description;
    private String category;
    private String city;
    private String address;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    @Temporal(TemporalType.DATE)
    private Date date;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "HH:mm:ss")
    @Temporal(TemporalType.TIME)
    private Date time;
    private String picture;

    @ManyToMany(mappedBy = "userGoingEvents")
    @JsonIgnore
    private Set<User> userGoingEvents;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    protected Event() {}

    public Event(Long id, String title, String description, String category, String city, String address, Date date, Date time, String picture) {
        this.id = id;
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

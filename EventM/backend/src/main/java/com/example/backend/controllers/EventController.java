package com.example.backend.controllers;

import com.example.backend.models.Event;
import com.example.backend.payload.response.EventResp;
import com.example.backend.payload.response.EventResponse;
import com.example.backend.repositories.EventRepository;
import com.example.backend.repositories.UserRepository;
import com.example.backend.utils.JsonResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/events")
public class EventController {
    @Autowired
    EventRepository eventRepository;

    @Autowired
    UserRepository userRepository;

    @PostMapping("/events")
    public Object addEvent(@Valid @RequestBody Event reqEvent) {
        try {
            return eventRepository.save(reqEvent);
        } catch (DataAccessException e) {
            return JsonResponse.badRequest("Error");
        }
    }

    @GetMapping("/events")
    public Object getEvents() {
        return eventRepository.findAll().stream().map(EventResp::new);
    }

    @GetMapping("/events/{id}")
    public Object getEventById(@PathVariable Long id) {
        Optional<Event> eventEntity = eventRepository.findById(id);
        if (eventEntity.isPresent())
            return eventEntity.get();
        return JsonResponse.notFound("Event with this ID doesn't exist.");
    }
    
}

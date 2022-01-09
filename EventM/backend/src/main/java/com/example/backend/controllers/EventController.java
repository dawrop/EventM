package com.example.backend.controllers;

import com.example.backend.models.Event;
import com.example.backend.models.User;
import com.example.backend.payload.request.AddToGoingEventsRequest;
import com.example.backend.payload.response.EventResp;
import com.example.backend.payload.response.UserResponse;
import com.example.backend.repositories.EventRepository;
import com.example.backend.repositories.UserRepository;
import com.example.backend.security.services.UserDetailsImpl;
import com.example.backend.utils.JsonResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataAccessException;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.*;
import java.util.stream.Collectors;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/events")
public class EventController {
    private final EventRepository eventRepository;
    private final UserRepository userRepository;

    @PostMapping("/addEvent")
    public Object addEvent(@AuthenticationPrincipal UserDetailsImpl userDetails, @Valid @RequestBody Event reqEvent) {
        Event event = new Event(
                reqEvent.getId(),
                reqEvent.getTitle(),
                reqEvent.getDescription(),
                reqEvent.getCategory(),
                reqEvent.getCity(),
                reqEvent.getAddress(),
                reqEvent.getDate(),
                reqEvent.getTime(),
                reqEvent.getPicture()
        );
        User user = userRepository
                .findByEmail(userDetails.getEmail())
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));

        event.setUser(user);

        try {
            return eventRepository.save(event);
        } catch (DataAccessException e) {
            return JsonResponse.badRequest("Error");
        }
    }

    @GetMapping("/events")
    public Object getEvents() {
        Date date = new Date();

        return eventRepository.findAllByDateAfterOrderByDateAsc(date).stream().map(EventResp::new);
        //return eventRepository.findAllByDateBefore(date).stream().map(EventResp::new);
    }

    @GetMapping("/events/{id}")
    public Object getEventById(@PathVariable Long id) {
        Optional<Event> eventEntity = eventRepository.findById(id);
        if (eventEntity.isPresent())
            return eventEntity.get();
        return JsonResponse.notFound("Event with this ID doesn't exist.");
    }

    @GetMapping("/hostingEvents")
    public Object getHostingEvents(@AuthenticationPrincipal UserDetailsImpl userDetails) {
        User user = userRepository
                .findByEmail(userDetails.getEmail())
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));

        Date date = new Date();
        return eventRepository.findAllByDateAfterAndUser_IdOrderByDateAsc(date, user.getId());
    }

    @GetMapping("/hostedEvents")
    public Object getHostedEvents(@AuthenticationPrincipal UserDetailsImpl userDetails) {
        User user = userRepository
                .findByEmail(userDetails.getEmail())
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));

        Date date = new Date();
        return eventRepository.findAllByDateBeforeAndUser_IdOrderByDateDesc(date, user.getId());
    }

    @PostMapping("/goingEvents")
    public Object addGoingEvent(@AuthenticationPrincipal UserDetailsImpl userDetails, @RequestBody AddToGoingEventsRequest requestEvent) {
        User user = userRepository
                .findByEmail(userDetails.getEmail())
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));
        Optional<Event> newGoingEvent = eventRepository.findById(requestEvent.getId());

        if (newGoingEvent.isEmpty()){
            return JsonResponse.badRequest("Event doesn't exist.");
        } else if (user.getUserGoingEvents().contains(newGoingEvent.get()) && newGoingEvent.get().getUserGoingEvents().contains(user)) {
            return JsonResponse.badRequest("Event already added.");
        } else if (newGoingEvent.get().getUser().getId().equals(userDetails.getId())) {
            return JsonResponse.badRequest("Host cannot add own event.");
        } else {
            user.getUserGoingEvents().add(newGoingEvent.get());
            newGoingEvent.get().getUserGoingEvents().add(user);

            userRepository.save(user);
            return JsonResponse.ok("Added to going events.");
        }
    }

    @GetMapping("/goingEvents")
    public Object getGoingEvent(@AuthenticationPrincipal UserDetailsImpl userDetails) {
        User user = userRepository
                .findByEmail(userDetails.getEmail())
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));
        Date date = new Date();
        return eventRepository.findByDateAfterAndUserGoingEvents_IdOrderByDateAsc(date, user.getId()).stream().map(EventResp::new).collect(Collectors.toList());
    }

    @GetMapping("/wentEvents")
    public Object getWentEvent(@AuthenticationPrincipal UserDetailsImpl userDetails) {
        User user = userRepository
                .findByEmail(userDetails.getEmail())
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));
        Date date = new Date();
        return eventRepository.findByDateBeforeAndUserGoingEvents_IdOrderByDateDesc(date, user.getId()).stream().map(EventResp::new).collect(Collectors.toList());
    }

    @GetMapping("/eventParticipants/{id}")
    public Object getParticipants(@PathVariable Long id) {
        Optional<Event> eventEntity = eventRepository.findById(id);
        if (eventEntity.isPresent())
            return eventEntity.get().getUserGoingEvents()
                    .stream().map(user -> UserResponse.builder()
                            .id(user.getId())
                            .name(user.getName())
                            .email(user.getEmail())
                            .avatar(user.getAvatar())
                            .build())
                    .collect(Collectors.toList());

        return JsonResponse.notFound("Event with this ID doesn't exist.");
    }
}

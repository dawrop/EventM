package com.example.backend.repositories;

import com.example.backend.models.Event;
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.List;
import java.util.Optional;

public interface EventRepository extends JpaRepository<Event, Long> {
    @Override
    List<Event> findAll();
    Optional<Event> findById(Long id);


}

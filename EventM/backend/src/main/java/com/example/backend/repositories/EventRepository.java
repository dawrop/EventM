package com.example.backend.repositories;

import com.example.backend.models.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Repository
public interface EventRepository extends JpaRepository<Event, Long> {
    @Override
    List<Event> findAll();
    Optional<Event> findById(Long id);

    Long countByUserGoingEvents_Id(Long id);

    List<Event> findAllByDateAfterOrderByDateAsc(Date date);
    List<Event> findAllByDateBefore(Date date);

    List<Event> findAllByDateAfterAndUser_IdOrderByDateAsc(Date date, Long id);
    List<Event> findAllByDateBeforeAndUser_IdOrderByDateDesc(Date date, Long id);

    List<Event> findByDateAfterAndUserGoingEvents_IdOrderByDateAsc(Date date, Long id_user);
    List<Event> findByDateBeforeAndUserGoingEvents_IdOrderByDateDesc(Date date, Long id_user);
}

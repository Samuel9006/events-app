package com.unir.event.event_service.services;

import com.unir.event.event_service.domain.dtos.EventDTO;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;

public interface IEventService {
    

    List<EventDTO> findAll();

    Optional<EventDTO> findById(Long id);

    Optional<List<EventDTO>> findByTitle(String title);

    EventDTO save(EventDTO event);

    ResponseEntity<Void> delete(Long id);
}

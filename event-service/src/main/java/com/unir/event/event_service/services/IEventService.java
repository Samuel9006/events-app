package com.unir.event.event_service.services;

import com.unir.event.event_service.domain.dtos.EventDTO;

import java.util.List;
import java.util.Optional;

public interface IEventService {
    

    List<EventDTO> findAll();

    Optional<EventDTO> findById(Long id);

    List<EventDTO> findByTitle(String title);

    EventDTO save(EventDTO event);
    EventDTO update(Long id, EventDTO event);

    boolean delete(Long id);
}

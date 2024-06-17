package com.unir.event.event_service.services;

import com.unir.event.event_service.domain.dtos.EventDTO;

import java.util.List;
import java.util.Optional;

/**
 * Service for managing Events.
 */
public interface IEventService {


    /**
     * Retrieves all events.
     * @return a list of all events.
     */
    List<EventDTO> findAll();

    /**
     * Retrieves an event by ID.
     * @param id the ID of the event to retrieve.
     * @return an optional containing the event if found, or empty if not found.
     */
    Optional<EventDTO> findById(Long id);

    /**
     * Retrieves an event list by title.
     * @param title the title of the event to retrieve.
     * @return a list with all events by title
     */
    List<EventDTO> findByTitle(String title);

    /**
     * Creates a new event.
     * @param event the DTO of the event to create.
     * @return the created event.
     */
    EventDTO save(EventDTO event);

    /**
     * Updates an existing event.
     * @param id the ID of the event to update.
     * @param event the DTO of the updated event.
     * @return the updated event, or null if not found.
     */
    EventDTO update(Long id, EventDTO event);

    /**
     * Deletes an event by ID.
     * @param id the ID of the event to delete.
     * @return true if the event was deleted, false if not found.
     */
    boolean delete(Long id);
}

package com.unir.event.event_service.controllers;

import com.unir.event.event_service.domain.dtos.EventDTO;
import com.unir.event.event_service.services.IEventService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/event")
@AllArgsConstructor
public class EventController {


    private IEventService eventService;

    /**
     * Retrieves all events.
     * @return a list of all events.
     */
    @GetMapping
    public ResponseEntity<List<EventDTO>> getAllEvents() {
        return new ResponseEntity<>(eventService.findAll(), HttpStatus.OK);
    }

    /**
     * Retrieves a event by ID.
     * @param id the ID of the event to retrieve.
     * @return the event with the given ID.
     */
    @GetMapping("/{id}")
    public ResponseEntity<EventDTO> getEventById(@PathVariable Long id) {
        return eventService.findById(id)
        .map(ResponseEntity::ok)
        .orElseGet(() -> ResponseEntity.notFound().build());
    }

    /**
     * Retrieves a list of events by title.
     * @param title the title of the events to retrieve.
     * @return the list of events with the given title.
     */
    @GetMapping("/search")
    public ResponseEntity<List<EventDTO>> getEventsByTitle(@RequestParam String title) {
        if (eventService.findByTitle(title).isEmpty()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }else {
            return new ResponseEntity<>(eventService.findByTitle(title), HttpStatus.OK);
        }
    }

    /**
     * Creates a new event.
     * @param event the DTO of the event to create.
     * @return the created event.
     */
    @PostMapping
    public ResponseEntity<EventDTO> createEvent(@Valid @RequestBody EventDTO event) {
        return new ResponseEntity<>(eventService.save(event), HttpStatus.CREATED);
    }

    /**
     * Updates an existing event.
     * @param id the ID of the event to update.
     * @param eventDetails the DTO of the updated event.
     * @return the updated event.
     */
    @PutMapping("/{id}")
    public ResponseEntity<EventDTO> updateEvent(@PathVariable Long id, @RequestBody EventDTO eventDetails) {
        EventDTO updatedEvent = this.eventService.update(id, eventDetails);
        if (updatedEvent != null) {
            return ResponseEntity.ok(updatedEvent);
        } else {
            return ResponseEntity.notFound().build();
        }

    }

    /**
     * Deletes a event by ID.
     * @param id the ID of the event to delete.
     * @return a response indicating the outcome of the deletion.
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEvent(@PathVariable Long id) {
        boolean deleted = this.eventService.delete(id);
        if (deleted) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}

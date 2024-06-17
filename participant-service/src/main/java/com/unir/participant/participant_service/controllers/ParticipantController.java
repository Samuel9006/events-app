package com.unir.participant.participant_service.controllers;


import com.unir.participant.participant_service.domain.dtos.ParticipantDTO;
import com.unir.participant.participant_service.services.IParticipantService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * REST Controller for managing Participants.
 */
@RestController
@RequestMapping("/api/v1/participants")
public class ParticipantController {
    @Autowired
    private IParticipantService participantService;

    /**
     * Retrieves all participants.
     * @return a list of all participants.
     */
    @GetMapping
    public ResponseEntity<List<ParticipantDTO>> getAllParticipants() {
        return ResponseEntity.ok(participantService.findAll());
    }

    /**
     * Retrieves a participant by ID.
     * @param id the ID of the participant to retrieve.
     * @return the participant with the given ID.
     */
    @GetMapping("/{id}")
    public ResponseEntity<ParticipantDTO> getParticipantById(@PathVariable Long id) {
        return participantService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    /**
     * Creates a new participant.
     * @param participantDto the DTO of the participant to create.
     * @return the created participant.
     */
    @PostMapping
    public ResponseEntity<ParticipantDTO> createParticipant(@Valid @RequestBody ParticipantDTO participantDto) {
        return new ResponseEntity<>(participantService.createParticipant(participantDto), HttpStatus.CREATED);
    }

    /**
     * Updates an existing participant.
     * @param id the ID of the participant to update.
     * @param participantDto the DTO of the updated participant.
     * @return the updated participant.
     */
    @PutMapping("/{id}")
    public ResponseEntity<ParticipantDTO> updateParticipant(@PathVariable Long id, @Valid @RequestBody ParticipantDTO participantDto) {
        ParticipantDTO updatedParticipant = participantService.updateParticipant(id, participantDto);
        if (updatedParticipant != null) {
            return ResponseEntity.ok(updatedParticipant);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    /**
     * Deletes a participant by ID.
     * @param id the ID of the participant to delete.
     * @return a response indicating the outcome of the deletion.
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteParticipant(@PathVariable Long id) {
        boolean deleted = participantService.deleteParticipant(id);
        if (deleted) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}

package com.unir.participant.participant_service.services;

import com.unir.participant.participant_service.domain.dtos.ParticipantDTO;
import com.unir.participant.participant_service.domain.entities.ParticipantEntity;

import java.util.List;
import java.util.Optional;

/**
 * Service for managing Participants.
 */
public interface IParticipantService {


    /**
     * Retrieves all participants.
     * @return a list of all participants.
     */
     List<ParticipantDTO> findAll();

    /**
     * Retrieves a participant by ID.
     * @param id the ID of the participant to retrieve.
     * @return an optional containing the participant if found, or empty if not found.
     */
    Optional<ParticipantDTO> findById(Long id);

    /**
     * Creates a new participant.
     * @param participantDto the DTO of the participant to create.
     * @return the created participant.
     */
    ParticipantDTO createParticipant(ParticipantDTO participantDto);

    /**
     * Updates an existing participant.
     * @param id the ID of the participant to update.
     * @param participantDto the DTO of the updated participant.
     * @return the updated participant, or null if not found.
     */
    ParticipantDTO updateParticipant(Long id, ParticipantDTO participantDto);

    /**
     * Deletes a participant by ID.
     * @param id the ID of the participant to delete.
     * @return true if the participant was deleted, false if not found.
     */
      boolean deleteParticipant(Long id);

}

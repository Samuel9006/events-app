package com.unir.participant.participant_service.domain.repositories;

import com.unir.participant.participant_service.domain.entities.ParticipantEntity;
import org.springframework.data.repository.CrudRepository;

public interface ParticipantRepository extends CrudRepository<ParticipantEntity, Long> {
}

package com.unir.participant.participant_service.domain.mapper;

import com.unir.participant.participant_service.domain.dtos.ParticipantDTO;
import com.unir.participant.participant_service.domain.entities.ParticipantEntity;
import org.mapstruct.Mapper;

import java.util.List;


/**
 * Mapper to transform Participant entities and dtos
 */
@Mapper(componentModel = "spring")
public interface ParticipantMapper {

    /**
     * Mapp a ParticipantDTO to ParticipantEntity
     * @param participantDTO dto to mapper
     * @return an ParticipantEntity
     */
    ParticipantEntity toEntity(ParticipantDTO participantDTO);

    /**
     * Mapp a ParticipantEntity to ParticipantDTO
     * @param participantEntity entity to mapper
     * @return an ParticipantDTO
     */
    ParticipantDTO toDTO(ParticipantEntity participantEntity);

    /**
     * Mapp a ParticipantDTO to ParticipantEntity
     * @param participantEntityList entity list to mapper
     * @return an List<ParticipantDTO>
     */
    List<ParticipantDTO> toDTO(List<ParticipantEntity> participantEntityList);
}

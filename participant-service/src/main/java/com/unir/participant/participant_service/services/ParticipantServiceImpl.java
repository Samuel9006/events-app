package com.unir.participant.participant_service.services;

import com.unir.participant.participant_service.domain.dtos.ParticipantDTO;
import com.unir.participant.participant_service.domain.entities.ParticipantEntity;
import com.unir.participant.participant_service.domain.mapper.ParticipantMapper;
import com.unir.participant.participant_service.domain.repositories.ParticipantRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Service implementation for managing Participants.
 */
@Service
@AllArgsConstructor
public class ParticipantServiceImpl implements IParticipantService {

    private ParticipantRepository participantRepository;
    private ParticipantMapper participantMapper;


    @Override
    public List<ParticipantDTO> findAll() {
        List<ParticipantEntity> allParticipants = (List<ParticipantEntity>) participantRepository.findAll();
        return participantMapper.toDTO(allParticipants);
    }

    @Override
    public Optional<ParticipantDTO> findById(Long id) {
        return participantRepository.findById(id).map(participantMapper::toDTO);
    }

    @Override
    public ParticipantDTO createParticipant(ParticipantDTO participantDto) {
        ParticipantEntity participantSaved = participantRepository.save(participantMapper.toEntity(participantDto));
        return this.participantMapper.toDTO(participantSaved);
    }

    @Override
    public ParticipantDTO updateParticipant(Long id, ParticipantDTO participantDto) {
        Optional<ParticipantEntity> optionalParticipant = participantRepository.findById(id);
        if (optionalParticipant.isPresent()) {
            ParticipantEntity participant = optionalParticipant.get();
            participant.setName(participantDto.getName());
            participant.setEmail(participantDto.getEmail());
            ParticipantEntity participantUpdated = participantRepository.save(participant);
            return this.participantMapper.toDTO(participantUpdated);
        } else {
            return null;
        }
    }

    @Override
    public boolean deleteParticipant(Long id) {
        if (participantRepository.findById(id).isPresent()) {
            participantRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }
}

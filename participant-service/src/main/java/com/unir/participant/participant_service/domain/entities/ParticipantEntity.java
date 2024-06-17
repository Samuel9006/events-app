package com.unir.participant.participant_service.domain.entities;


import jakarta.persistence.*;
import lombok.Data;

/**
 * Entity class representing a Participant.
 */
@Entity
@Table(name = "Participant")
@Data
public class ParticipantEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String email;
}

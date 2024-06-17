package com.unir.participant.participant_service.domain.dtos;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Data Transfer Object for Participant.
 */
@Data
public class ParticipantDTO {

    private Long id;

    @NotEmpty(message = "Name is mandatory")
    @Size(max = 100, message = "Name must be less than 100 characters")
    private String name;

    @NotEmpty(message = "Email is mandatory")
    @Email(message = "Email should be valid")
    private String email;
}

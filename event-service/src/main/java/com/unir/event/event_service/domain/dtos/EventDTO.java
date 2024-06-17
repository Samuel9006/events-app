package com.unir.event.event_service.domain.dtos;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.Date;
import java.util.Set;

@Data
public class EventDTO {

    private Long eventId;

    @NotEmpty
    private String eventTitle;
    @NotEmpty
    private String description;
    @NotNull
    private Date eventDate;
    @NotEmpty
    private String eventLocation;
    private Set<Long> participantIds;
}

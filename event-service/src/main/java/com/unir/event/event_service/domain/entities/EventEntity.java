package com.unir.event.event_service.domain.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
public class EventEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String description;
    private Date date;
    private String location;

    @ElementCollection
    private Set<Long> participantIds = new HashSet<>();
}

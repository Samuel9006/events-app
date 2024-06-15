package com.unir.event.event_service.domain.repositories;

import com.unir.event.event_service.domain.entities.EventEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface EventRepository extends CrudRepository<EventEntity, Long> {

    List<EventEntity> findByTitle(String title);
}

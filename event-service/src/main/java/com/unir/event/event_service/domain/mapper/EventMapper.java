package com.unir.event.event_service.domain.mapper;

import com.unir.event.event_service.domain.dtos.EventDTO;
import com.unir.event.event_service.domain.entities.EventEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface EventMapper {

    @Mappings({
            @Mapping(source = "eventId", target = "id"),
            @Mapping(source = "eventTitle", target = "title"),
            @Mapping(source = "eventDate", target = "date"),
            @Mapping(source = "eventLocation", target = "location")
    })
    EventEntity toEvent(EventDTO eventDTO);

    @Mappings({
            @Mapping(source = "id", target = "eventId"),
            @Mapping(source = "title", target = "eventTitle"),
            @Mapping(source = "date", target = "eventDate"),
            @Mapping(source = "location", target = "eventLocation")
    })
    EventDTO toEventDto(EventEntity eventDTO);


    List<EventDTO> toEventsDto(List<EventEntity> eventDTO);
}

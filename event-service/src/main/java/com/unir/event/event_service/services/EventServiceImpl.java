package com.unir.event.event_service.services;

import com.unir.event.event_service.domain.dtos.EventDTO;

import com.unir.event.event_service.domain.entities.EventEntity;
import com.unir.event.event_service.domain.mapper.EventMapper;
import com.unir.event.event_service.domain.repositories.EventRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class EventServiceImpl implements IEventService{


    private EventRepository eventRepository;
    private EventMapper eventMapper;

    @Override
    public List<EventDTO> findAll() {
        List<EventEntity> allEvents = (List<EventEntity>) this.eventRepository.findAll();
        return this.eventMapper.toEventsDto(allEvents);
    }

    @Override
    public Optional<EventDTO> findById(Long id) {
        return this.eventRepository.findById(id).map(eventMapper::toEventDto);
    }

    @Override
    public List<EventDTO> findByTitle(String title) {
        List<EventEntity> byTitle = this.eventRepository.findByTitle(title);
        return this.eventMapper.toEventsDto(byTitle);
    }

    @Override
    public EventDTO save(EventDTO event) {
        EventEntity eventSaved = this.eventRepository.save(this.eventMapper.toEvent(event));
        return this.eventMapper.toEventDto(eventSaved);
    }

    @Override
    public EventDTO update(Long id, EventDTO eventDto) {
        Optional<EventEntity> optionalEvent = this.eventRepository.findById(id);
        if (optionalEvent.isPresent()) {
            EventEntity eventEntity = optionalEvent.get();
            eventEntity.setTitle(eventDto.getEventTitle());
            eventEntity.setDescription(eventDto.getDescription());
            eventEntity.setDate(eventDto.getEventDate());
            eventEntity.setLocation(eventDto.getEventLocation());
            eventEntity.setParticipantIds(eventDto.getParticipantIds());
            EventEntity eventUpdated = this.eventRepository.save(eventEntity);
            return this.eventMapper.toEventDto(eventUpdated);
        }else{
            return null;
        }

    }

    @Override
    public boolean delete(Long id) {
        if (eventRepository.findById(id).isPresent()) {
            eventRepository.deleteById(id);
            return true;
        } else {
            return false;
        }

    }

    
}

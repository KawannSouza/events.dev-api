package com.kawann.events.dev.service;

import com.kawann.events.dev.dto.EventRequestDTO;
import com.kawann.events.dev.dto.EventResponseDTO;
import com.kawann.events.dev.mapper.EventMapper;
import com.kawann.events.dev.model.Event;
import com.kawann.events.dev.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EventService {

    private final EventRepository eventRepository;
    private final EventMapper eventMapper;

    @Autowired
    public  EventService(EventRepository eventRepository, EventMapper eventMapper) {
        this.eventRepository = eventRepository;
        this.eventMapper = eventMapper;
    }

    public EventResponseDTO createEvent(EventRequestDTO requestDTO) {
        Event newEvent = new Event();
        newEvent.setName(requestDTO.name());
        newEvent.setDescription(requestDTO.description());
        newEvent.setDate(requestDTO.date());
        newEvent.setLocal(requestDTO.Local());

        Event savedEvent = eventRepository.save(newEvent);

        return eventMapper.toResponseDTO(savedEvent);
    }
}
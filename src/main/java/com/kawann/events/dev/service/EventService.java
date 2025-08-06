package com.kawann.events.dev.service;

import com.kawann.events.dev.dto.EventRequestDTO;
import com.kawann.events.dev.dto.EventResponseDTO;
import com.kawann.events.dev.mapper.EventMapper;
import com.kawann.events.dev.model.Event;
import com.kawann.events.dev.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

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

    public List<EventResponseDTO> getAllEvents() {
        return eventRepository.findAll()
                .stream()
                .map(eventMapper::toResponseDTO)
                .collect(Collectors.toList());
    }

    public EventResponseDTO getEventById(Long id) {
        Event event = eventRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Event not found."));

        return eventMapper.toResponseDTO(event);
    }

    public EventResponseDTO updateEvent(Long id, EventRequestDTO requestDTO) {
        Event existingEvent = eventRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Event not found."));

        existingEvent.setName(requestDTO.name());
        existingEvent.setDescription(requestDTO.description());
        existingEvent.setDate(requestDTO.date());
        existingEvent.setLocal(requestDTO.Local());

        Event updatedEvent = eventRepository.save(existingEvent);

        return eventMapper.toResponseDTO(updatedEvent);
    }
}
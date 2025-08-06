package com.kawann.events.dev.mapper;

import com.kawann.events.dev.dto.EventRequestDTO;
import com.kawann.events.dev.dto.EventResponseDTO;
import com.kawann.events.dev.model.Event;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface EventMapper {

    Event toEntity(EventRequestDTO requestDTO);

    EventResponseDTO toResponseDTO(Event event);

    void updateEntityFromDto(EventRequestDTO dto, @MappingTarget Event event);
}

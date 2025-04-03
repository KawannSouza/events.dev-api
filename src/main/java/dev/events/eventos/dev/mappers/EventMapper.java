package dev.events.eventos.dev.mappers;

import dev.events.eventos.dev.dtos.EventDTO;
import dev.events.eventos.dev.models.EventModel;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface EventMapper {
    EventMapper INSTANCE = Mappers.getMapper(EventMapper.class);

    EventDTO toDto(EventModel event);
    EventModel toEntity(EventDTO eventDTO);

}

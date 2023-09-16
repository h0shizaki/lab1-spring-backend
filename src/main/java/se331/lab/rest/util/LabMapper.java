package se331.lab.rest.util;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import se331.lab.rest.dto.EventDto;
import se331.lab.rest.entity.Event;

import java.util.List;

@Mapper
public interface LabMapper {
    LabMapper INSTANCE = Mappers.getMapper(LabMapper.class);
    EventDto getEventDTO(Event event);
    List<EventDto> getEventDTO(List<Event> events);
}

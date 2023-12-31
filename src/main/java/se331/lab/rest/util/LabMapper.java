package se331.lab.rest.util;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import se331.lab.rest.dto.EventDto;
import se331.lab.rest.dto.OrganizerAuthDto;
import se331.lab.rest.dto.OrganizerDto;
import se331.lab.rest.dto.ParticipantDto;
import se331.lab.rest.entity.Event;
import se331.lab.rest.entity.Organizer;
import se331.lab.rest.entity.Participant;

import java.util.List;

@Mapper
public interface LabMapper {
    LabMapper INSTANCE = Mappers.getMapper(LabMapper.class);
    EventDto getEventDTO(Event event);
    List<EventDto> getEventDTO(List<Event> events);
    OrganizerDto getOrganizerDTO(Organizer organizer);
    List<OrganizerDto> getOrganizerDTO(List<Organizer> organizers);
    ParticipantDto getParticipantDTO(Participant participant);
    List<ParticipantDto> getParticipantDTO(List<Participant> participants);

    @Mapping(target="roles", source = "user.roles")
    OrganizerAuthDto getOrganizerAuthDto(Organizer organizer);
}

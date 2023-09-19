package se331.lab.rest.config;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;
import se331.lab.rest.entity.Event;
import se331.lab.rest.entity.Organizer;
import se331.lab.rest.entity.Participant;
import se331.lab.rest.repository.EventRepository;
import se331.lab.rest.repository.OrganizerRepository;
import se331.lab.rest.repository.ParticipantRepository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


@Component
@RequiredArgsConstructor
public class InitApp implements ApplicationListener<ApplicationReadyEvent> {
    final EventRepository eventRepository;
    final OrganizerRepository organizerRepository;
    final ParticipantRepository participantRepository;

    @Override
    public void onApplicationEvent(ApplicationReadyEvent applicationReadyEvent) {
        Organizer org1, org2, org3;
        Participant participantA, participantB, participantC, participantD, participantE;
        participantA = participantRepository.save(
                Participant.builder()
                        .id(1L)
                        .name("Kan Katpark")
                        .telNo("1112")
                        .build()
        );
        participantB = participantRepository.save(
                Participant.builder()
                        .id(2L)
                        .name("Yuri Gagarin")
                        .telNo("1150")
                        .build()
        );
        participantC = participantRepository.save(
                Participant.builder()
                        .id(3L)
                        .name("John Smith")
                        .build()
        );
        participantD = participantRepository.save(
                Participant.builder()
                        .id(4L)
                        .name("Musashi Miyamoto")
                        .build()
        );
        participantE = participantRepository.save(
                Participant.builder()
                        .id(5L)
                        .name("Sun Tzu")
                        .build()
        );

        org1 = organizerRepository.save(
                Organizer.builder()
                        .organizationName("CAMT")
                        .address("CAMT CMU")
                        .build()
        );
        org2 = organizerRepository.save(
                Organizer.builder()
                        .organizationName("The standard oil")
                        .address("NYC USA")
                        .build()
        );
        org3 = organizerRepository.save(
                Organizer.builder()
                        .organizationName("Zaibatsu Group")
                        .address("TKY JP")
                        .build()
        );

        Event tempEvent;
        tempEvent = Event.builder()
                .id(123L)
                .category("animal welfare")
                .title("Cat adoption day")
                .description("Find your new feline friend at this event.")
                .location("Meow Town")
                .date("January 28, 2022")
                .time("12:00")
                .petAllowed(true)
                .organizer(org1)
                .build()
        ;
        addParticipantToEvent(participantA, participantB, participantC, tempEvent);
        org1.getOwnEvents().add(tempEvent);
        eventRepository.save(tempEvent);

        tempEvent = Event.builder()
                .id(456L)
                .category("food")
                .title("Community Gardening")
                .description("Join us as we tend to the community edible plants.")
                .location("Flora City")
                .date("March 14, 2022")
                .time("10:00")
                .petAllowed(true)
                .organizer(org1)
                .build()
        ;
        addParticipantToEvent(participantA, participantB, participantC, tempEvent);
        org1.getOwnEvents().add(tempEvent);
        eventRepository.save(tempEvent);

        tempEvent = Event.builder()
                .id(789L)
                .category("sustainability")
                .title("Beach Cleanup")
                .description("Help pick up trash along the shore.")
                .location("Playa Del Carmen")
                .date("July 22, 2022")
                .time("11:00")
                .petAllowed(false)
                .organizer(org1)
                .build()
        ;
        addParticipantToEvent(participantA, participantB, participantC, tempEvent);
        org1.getOwnEvents().add(tempEvent);
        eventRepository.save(tempEvent);

        tempEvent = Event.builder()
                .id(1001L)
                .category("animal welfare")
                .title("Dog Adoption Day")
                .description("Find your new canine friend at this event.")
                .location("Woof Town")
                .date("August 28, 2022")
                .time("12:00")
                .petAllowed(true)
                .organizer(org2)
                .build()
        ;
        addParticipantToEvent(participantD, participantE, participantC, tempEvent);
        org2.getOwnEvents().add(tempEvent);
        eventRepository.save(tempEvent);

        tempEvent = Event.builder()
                .id(1002L)
                .category("food")
                .title("Canned Food Drive")
                .description("Bring your canned food to donate to those in need.")
                .location("Tin City")
                .date("September 14, 2022")
                .time("15:00")
                .petAllowed(true)
                .organizer(org2)
                .build()
        ;
        addParticipantToEvent(participantC,participantD,participantE,tempEvent);
        org2.getOwnEvents().add(tempEvent);
        eventRepository.save(tempEvent);

        tempEvent = Event.builder()
                .id(1003L)
                .category("sustainability")
                .title("Highway Cleanup")
                .description("Help pick up trash along the highway.")
                .location("Highway 50")
                .date("July 22, 2022")
                .time("11:00")
                .petAllowed(false)
                .organizer(org3)
                .build()
        ;
        addParticipantToEvent(participantC,participantD,participantE,tempEvent);
        org3.getOwnEvents().add(tempEvent);
        eventRepository.save(tempEvent);

    }

    private void addParticipantToEvent(Participant participantA, Participant participantB, Participant participantC, Event tempEvent) {
        tempEvent.getParticipants().add(participantA);
        tempEvent.getParticipants().add(participantB);
        tempEvent.getParticipants().add(participantC);
        participantA.getEventHistory().add(tempEvent);
        participantB.getEventHistory().add(tempEvent);
        participantC.getEventHistory().add(tempEvent);
    }

}

package se331.lab.rest.config;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;
import se331.lab.rest.entity.Event;
import se331.lab.rest.entity.Organizer;
import se331.lab.rest.repository.EventRepository;
import se331.lab.rest.repository.OrganizerRepository;

@Component
@RequiredArgsConstructor
public class InitApp implements ApplicationListener<ApplicationReadyEvent> {
    final EventRepository eventRepository;
    final OrganizerRepository organizerRepository;

    @Override
    public void onApplicationEvent(ApplicationReadyEvent applicationReadyEvent) {
        eventRepository.save(Event.builder()
                .id(123L)
                .category("animal welfare")
                .title("Cat adoption day")
                .description("Find your new feline friend at this event.")
                .location("Meow Town")
                .date("January 28, 2022")
                .time("12:00")
                .petAllowed(true)
                .organizer("Kat Laydee")
                .build()
        );
        eventRepository.save(
                Event.builder()
                        .id(456L)
                        .category("food")
                        .title("Community Gardening")
                        .description("Join us as we tend to the community edible plants.")
                        .location("Flora City")
                        .date("March 14, 2022")
                        .time("10:00")
                        .petAllowed(true)
                        .organizer("Fern Pollin")
                        .build()
        );
        eventRepository.save(
                Event.builder()
                        .id(789L)
                        .category("sustainability")
                        .title("Beach Cleanup")
                        .description("Help pick up trash along the shore.")
                        .location("Playa Del Carmen")
                        .date("July 22, 2022")
                        .time("11:00")
                        .petAllowed(false)
                        .organizer("Carey Wales")
                        .build()
        );
        eventRepository.save(
                Event.builder()
                        .id(1001L)
                        .category("animal welfare")
                        .title("Dog Adoption Day")
                        .description("Find your new canine friend at this event.")
                        .location("Woof Town")
                        .date("August 28, 2022")
                        .time("12:00")
                        .petAllowed(true)
                        .organizer("Dawg Dahd")
                        .build()
        );
        eventRepository.save(
                Event.builder()
                        .id(1002L)
                        .category("food")
                        .title("Canned Food Drive")
                        .description("Bring your canned food to donate to those in need.")
                        .location("Tin City")
                        .date("September 14, 2022")
                        .time("15:00")
                        .petAllowed(true)
                        .organizer("Kahn Opiner")
                        .build()
        );
        eventRepository.save(
                Event.builder()
                        .id(1003L)
                        .category("sustainability")
                        .title("Highway Cleanup")
                        .description("Help pick up trash along the highway.")
                        .location("Highway 50")
                        .date("July 22, 2022")
                        .time("11:00")
                        .petAllowed(false)
                        .organizer("Brody Kill")
                        .build()
        );

        organizerRepository.save(
                Organizer.builder()
                        .id(111L)
                        .organizationName("Kat Laydee")
                        .address("Meow Town")
                        .build()
        );
        organizerRepository.save(
                Organizer.builder()
                        .id(222L)
                        .organizationName("Fern Pollin")
                        .address("Flora City")
                        .build()
        );
        organizerRepository.save(
                Organizer.builder()
                        .id(333L)
                        .organizationName("Carey Wales")
                        .address("Playa Del Carmen")
                        .build()
        );
        organizerRepository.save(
                Organizer.builder()
                        .id(444L)
                        .organizationName("Dawg Dahd")
                        .address("Woof Town")
                        .build()
        );
        organizerRepository.save(
                Organizer.builder()
                        .id(555L)
                        .organizationName("Kahn Opiner")
                        .address("Tin City")
                        .build()
        );
        organizerRepository.save(
                Organizer.builder()
                        .id(666L)
                        .organizationName("Brody Kill")
                        .address("Highway Town")
                        .build()
        );
    }

}

package se331.lab.rest.service;

import org.springframework.data.domain.Page;
import se331.lab.rest.entity.Organizer;

import java.util.List;
import java.util.Optional;

public interface OrganizerService {
    Integer getOrganizerSize();
    Page<Organizer> getOrganizers(Integer perPage, Integer page);
    List<Organizer> getAllOrganizer();
    Optional<Organizer> getOrganizer(Long id);
    Organizer save(Organizer organizer);
}

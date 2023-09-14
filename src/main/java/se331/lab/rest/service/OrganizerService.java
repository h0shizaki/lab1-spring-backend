package se331.lab.rest.service;

import se331.lab.rest.entity.Organizer;

import java.util.List;

public interface OrganizerService {
    Integer getOrganizerSize();
    List<Organizer> getOrganizerList(Integer perPage, Integer page);
    Organizer getOrganizer(Long id);
}

package se331.lab.rest.dao;

import se331.lab.rest.entity.Organizer;

import java.util.List;

public interface OrganizerDao {
    Integer getOrganizerSize();
    List<Organizer> getOrganizerList(Integer perPage, Integer page);
    Organizer getOrganizer(Long id);
}

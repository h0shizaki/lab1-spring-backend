package se331.lab.rest.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import se331.lab.rest.dao.EventDao;
import se331.lab.rest.dao.OrganizerDao;
import se331.lab.rest.entity.Event;
import se331.lab.rest.entity.Organizer;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EventServiceImpl implements EventService{
    final EventDao eventDao;
    final OrganizerDao organizerDao;

    @Override
    public Integer getEventSize() {
        return this.eventDao.getEventSize();
    }

    @Override
    public Page<Event> getEvents(Integer pageSize, Integer page){
        return this.eventDao.getEvents(pageSize, page);
    }

    @Override
    public Event getEvent(Long id){
        return this.eventDao.getEvent(id);
    }

    @Override
    public Event save(Event event) {
        Organizer organizer = organizerDao.findById(event.getOrganizer().getId()).orElse(null);
        event.setOrganizer(organizer);
        organizer.getOwnEvents().add(event);
        return eventDao.save(event);
    }

    @Override
    public Page<Event> getEvents(String title, Pageable pageable){
        return eventDao.getEvents(title, pageable);
    }

    @Override
    public Page<Event> getEventsByOrganizer(String org , Pageable pageable){
        return eventDao.getEventsByOrg(org, pageable);
    }
}

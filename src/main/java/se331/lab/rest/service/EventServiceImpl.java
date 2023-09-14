package se331.lab.rest.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import se331.lab.rest.dao.EventDao;
import se331.lab.rest.entity.Event;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EventServiceImpl implements EventService{
    final EventDao eventDao;

    @Override
    public Integer getEventSize() {
        return this.eventDao.getEventSize();
    }

    @Override
    public List<Event> getEventList(Integer pageSize, Integer page){
        return this.eventDao.getEventList(pageSize, page);
    }

    @Override
    public Event getEvent(Long id){
        return this.eventDao.getEvent(id);
    }
}

package se331.lab.rest.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import se331.lab.rest.dao.OrganizerDao;
import se331.lab.rest.entity.Organizer;

import java.util.List;
import java.util.Optional;


@Service
@RequiredArgsConstructor
public class OrganizerServiceImpl implements OrganizerService{
    final OrganizerDao organizerDao;

    @Override
    public Integer getOrganizerSize() {
        return organizerDao.getOrganizerSize();
    }

    @Override
    public Page<Organizer> getOrganizers(Integer perPage, Integer page) {
        return organizerDao.getOrganizers(PageRequest.of(page,perPage));
    }
    @Override
    public List<Organizer> getAllOrganizer() {
        return organizerDao.getOrganizers(Pageable.unpaged()).getContent();
    }
    @Override
    public Optional<Organizer> getOrganizer(Long id) {
        return organizerDao.findById(id);
    }

    @Override
    public Organizer save(Organizer organizer){
        return organizerDao.save(organizer);
    }

}

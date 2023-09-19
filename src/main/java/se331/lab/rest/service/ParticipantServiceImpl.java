package se331.lab.rest.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import se331.lab.rest.dao.ParticipantDao;
import se331.lab.rest.entity.Participant;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ParticipantServiceImpl implements ParticipantService{
    final ParticipantDao participantDao;
    @Override
    public List<Participant> getParticipants() {
        return participantDao.getParticipants(Pageable.unpaged()).getContent();
    }

    @Override
    public Optional<Participant> getParticipant(Long id) {
        return participantDao.findById(id);
    }
}

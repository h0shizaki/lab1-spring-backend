package se331.lab.rest.dao;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Profile;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;
import se331.lab.rest.entity.Participant;
import se331.lab.rest.repository.ParticipantRepository;

import java.util.Optional;

@Repository
@RequiredArgsConstructor
@Profile("db")
public class ParticipantDaoDbImpl implements ParticipantDao{
    final ParticipantRepository participantRepository;
    @Override
    public Integer getParticipantSize() {
        return Math.toIntExact(participantRepository.count());
    }

    @Override
    public Page<Participant> getParticipants(Pageable pageRequest) {
        return participantRepository.findAll(pageRequest);
    }

    @Override
    public Optional<Participant> findById(Long id) {
        return participantRepository.findById(id);
    }

    @Override
    public Participant save(Participant participant) {
        return participantRepository.save(participant);
    }
}

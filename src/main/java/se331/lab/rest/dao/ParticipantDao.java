package se331.lab.rest.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import se331.lab.rest.entity.Participant;

import java.util.Optional;

public interface ParticipantDao {
    Integer getParticipantSize();
    Page<Participant> getParticipants(Pageable pageRequest);
    Optional<Participant> findById(Long id);
    Participant save(Participant participant);
}

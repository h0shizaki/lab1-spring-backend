package se331.lab.rest.service;

import se331.lab.rest.entity.Participant;

import java.util.List;
import java.util.Optional;

public interface ParticipantService {
    List<Participant> getParticipants();
    Optional<Participant> getParticipant(Long id);
}

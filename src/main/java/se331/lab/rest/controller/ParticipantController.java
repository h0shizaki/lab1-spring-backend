package se331.lab.rest.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.server.ResponseStatusException;
import se331.lab.rest.entity.Participant;
import se331.lab.rest.service.ParticipantService;
import se331.lab.rest.util.LabMapper;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class ParticipantController {
    final ParticipantService participantService;

    @GetMapping("participants")
    public ResponseEntity<?> getParticipantList() {
        List<Participant> output = participantService.getParticipants();
        HttpHeaders responseHeader = new HttpHeaders();
        responseHeader.set("x-total-count", String.valueOf(output.size()));
        return new ResponseEntity<>(LabMapper.INSTANCE.getParticipantDTO(output), responseHeader, HttpStatus.OK);
    }

    @GetMapping("participants/{id}")
    public ResponseEntity<?> getParticipant(@PathVariable("id")Long id) {
        Participant participant = participantService.getParticipant(id).orElse(null);
        if(participant != null){
            return ResponseEntity.ok(LabMapper.INSTANCE.getParticipantDTO(participant));
        }else{
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "The given id is not found");
        }

    }
}

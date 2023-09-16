package se331.lab.rest.controller;

import lombok.RequiredArgsConstructor;
import org.aspectj.weaver.ast.Or;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import se331.lab.rest.entity.Organizer;
import se331.lab.rest.service.OrganizerService;
import se331.lab.rest.util.LabMapper;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class OrganizerController {
    final OrganizerService organizerService;

    @GetMapping("organizers")
    public ResponseEntity<?> getOrganizerList(@RequestParam(value = "_limit", required = false) Integer perPage, @RequestParam(value = "_page", required = false) Integer page){
        HttpHeaders responseHeader = new HttpHeaders();
        List<Organizer> output = organizerService.getAllOrganizer();
        responseHeader.set("x-total-count", String.valueOf(output.size()));
        return new ResponseEntity<>(LabMapper.INSTANCE.getOrganizerDTO(output), responseHeader, HttpStatus.OK);
    }


    @GetMapping("organizers/{id}")
    public ResponseEntity<?> getOrganizer(@PathVariable("id") Long id){
        Organizer organizer = organizerService.getOrganizer(id).orElse(null);
        if(organizer != null){
            return ResponseEntity.ok(LabMapper.INSTANCE.getOrganizerDTO(organizer));
        }else{
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "The given id is not found");
        }
    }

    @PostMapping("organizers")
    public ResponseEntity<?> addOrganizer(@RequestBody Organizer organizer){
        Organizer output = organizerService.save(organizer);
        return ResponseEntity.ok(LabMapper.INSTANCE.getOrganizerDTO(output));
    }
}

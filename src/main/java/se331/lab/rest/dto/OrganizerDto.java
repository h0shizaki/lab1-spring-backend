package se331.lab.rest.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OrganizerDto {
    Long id;
    String organizationName;
    String address;
    List<OrganizerOwnEventsDto> ownEvents = new ArrayList<>();
    List<String> images;

}

package se331.lab.rest.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import se331.lab.rest.security.user.Role;

import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OrganizerAuthDto {
    Long id;
    String organizationName;
    String address;
    List<Role> roles = new ArrayList<>();
}

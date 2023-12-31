package se331.lab.rest.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;


@Data
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Exclude
    Long id;
    String title;
    String category;
    String description;
    String location;
    String date;
    String time;
    Boolean petAllowed;
    @ManyToOne
    Organizer organizer;
    @ManyToMany()
    @Builder.Default
    List<Participant> participants = new ArrayList<>();

    @ElementCollection
    List<String> images;
}

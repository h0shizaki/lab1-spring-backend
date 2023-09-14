package se331.lab.rest.dao;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;
import se331.lab.rest.entity.Organizer;

import java.util.ArrayList;
import java.util.List;

@Repository
public class OrganizerImpl implements OrganizerDao{
    List<Organizer> organizerList;

    @PostConstruct
    public void init() {
        organizerList = new ArrayList<>();
        organizerList.add(Organizer.builder()
                .id(111L)
                .organizationName("Kat Laydee")
                .address("Meow Town")
                .build()
        );
        organizerList.add(Organizer.builder()
                .id(222L)
                .organizationName("Fern Pollin")
                .address("Flora City")
                .build()
        );
        organizerList.add(Organizer.builder()
                .id(333L)
                .organizationName("Carey Wales")
                .address("Playa Del Carmen")
                .build()
        );
        organizerList.add(Organizer.builder()
                .id(444L)
                .organizationName("Dawg Dahd")
                .address("Woof Town")
                .build()
        );
        organizerList.add(Organizer.builder()
                .id(555L)
                .organizationName("Kahn Opiner")
                .address("Tin City")
                .build()
        );
        organizerList.add(Organizer.builder()
                .id(666L)
                .organizationName("Brody Kill")
                .address("Highway Town")
                .build()
        );
    }

    @Override
    public Integer getOrganizerSize() {return this.organizerList.size();}

    @Override
    public List<Organizer> getOrganizerList(Integer perPage, Integer page) {
        perPage = perPage == null ? organizerList.size() : perPage;
        page = page == null? 1 : page;
        int firstIndex = (page -1) * perPage;
        return organizerList.subList(firstIndex, firstIndex+perPage);
    }

    @Override
    public Organizer getOrganizer(Long id) {
        return organizerList.stream().filter( org -> org.getId().equals(id)).findFirst().orElse(null);
    }
}

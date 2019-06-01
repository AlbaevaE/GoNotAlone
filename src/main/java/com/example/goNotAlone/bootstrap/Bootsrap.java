package com.example.goNotAlone.bootstrap;

import com.example.goNotAlone.model.*;
import com.example.goNotAlone.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class Bootsrap implements CommandLineRunner {
    @Autowired
    UserRepository userRepository;
    @Autowired
    EventRepository eventRepository;
    @Autowired
    EventProposalsRepository eventProposalsRepository;
    @Autowired
    PlaceRepository placeRepository;
    @Autowired
    SightsRepository sightsRepository;
    @Autowired
    RoleRepository roleRepository;


    @Override
    public void run(String... args) throws Exception {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        Role userRoles = new Role("ADMIN");
        User user1 = new User.UserBuild("Kate", "0778412796",
                "aelvira312@gmail.com", "elvira", "Babushka85").build();
        userRepository.save(user1);
        roleRepository.save(userRoles);
        Place p = new Place("Bishkek");
        placeRepository.save(p);
        Event ev = new Event.EventBuild("ballet", p).build();
        eventRepository.save(ev);
        EventProposals evp = new EventProposals.ProposalsBuild("ballet", user1, p).build();
        eventProposalsRepository.save(evp);

        Sights s = new Sights("theater", p);
        sightsRepository.save(s);

    }
}

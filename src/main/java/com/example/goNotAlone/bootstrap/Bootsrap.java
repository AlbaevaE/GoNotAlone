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
    TravelDealsRepository travelDealsRepository;
    @Autowired
    UserRolesRepository userRolesRepository;


    @Override
    public void run(String... args) throws Exception {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        UserRoles userRoles = new UserRoles("ADMIN");
        User user1 = new User.UserBuild("Kate", "0778412796",
                "aelvira312@gmail.com", "elvira", "Babushka85").build();
        userRepository.save(user1);
        userRolesRepository.save(userRoles);
        Place p = new Place("Bishkek");
        placeRepository.save(p);
        Event ev = new Event("ballet",p,"jjhfgkjhgsgeuh");
        eventRepository.save(ev);
        EventProposals evp = new EventProposals(user1,p,ev);
        eventProposalsRepository.save(evp);
        TravelDeals tr = new TravelDeals(user1,p,ev);
        travelDealsRepository.save(tr);
        Sights s = new Sights("theater",p);
        sightsRepository.save(s);

    }
}

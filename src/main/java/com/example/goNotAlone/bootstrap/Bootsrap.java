package com.example.goNotAlone.bootstrap;

import com.example.goNotAlone.config.BCryptSingleton;
import com.example.goNotAlone.enums.Category;
import com.example.goNotAlone.model.*;
import com.example.goNotAlone.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.HashSet;

@Component
public class Bootsrap implements CommandLineRunner {
    @Autowired
    UserRepository userRepository;
    @Autowired
    EventRepository eventRepository;

    @Autowired
    PlaceRepository placeRepository;
    @Autowired
    SightsRepository sightsRepository;
    @Autowired
    RoleRepository roleRepository;


    @Override
    public void run(String... args) throws Exception {


        Role userRoles = new Role("ROLE_ADMIN");
        User user1 = new User.UserBuild("Elvira", "98785933",
                "aelvira312@gmail.com", BCryptSingleton.getInstance().encode("Babushka85")).build();
        user1.setActive(1);
        user1.setRoles(new HashSet<Role>(Arrays.asList(userRoles)));
        userRepository.save(user1);
        roleRepository.save(userRoles);
        Place p = new Place("Bishkek");
        placeRepository.save(p);
        Event ev = new Event.EventBuild("Football match", p).withCategory(Category.SPORT).withUser(user1).build();
        eventRepository.save(ev);

        Event event = new Event.EventBuild("Birdman", null).withCategory(Category.MOVIE).withUser(user1).build();
        eventRepository.save(event);

        Sights s = new Sights("theater", p);
        sightsRepository.save(s);

    }
}

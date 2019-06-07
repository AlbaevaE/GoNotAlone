package com.example.goNotAlone.service;

import com.example.goNotAlone.enums.ApplicationStatus;
import com.example.goNotAlone.model.Application;
import com.example.goNotAlone.model.Event;
import com.example.goNotAlone.model.Role;
import com.example.goNotAlone.model.User;
import com.example.goNotAlone.repository.ApplicationRepository;
import com.example.goNotAlone.repository.EventRepository;
import com.example.goNotAlone.repository.RoleRepository;
import com.example.goNotAlone.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

@Service
public class UserServiceImpl implements GenericService<User>, UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private EventRepository eventRepository;
    @Autowired
    private ApplicationRepository applicationRepository;

    BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    public User findUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }


    @Override
    public User addG(User user) {
        return userRepository.save(user);
    }

    @Override
    public Application addApp(Long userId, Long eventId, String message) {
        Application a = new Application();
        User user = userRepository.findById(userId).get();
        Event event = eventRepository.findById(eventId).get();
        a.setUser(user);
        a.setEvent(event);
        a.setTime(LocalDateTime.now());
        a.setMessage(message);
        List<User> users = new ArrayList<>();
        a.setUserList(users);
        a.setStatus(ApplicationStatus.AWAITING);
        applicationRepository.save(a);
        return a;
    }


    @Override
    public User add(User user) {
        List<Role> roles = this.roleRepository.findAll();
        user.setIsActive(1);
//        user.setPassword(encoder.encode(user.getPassword()));
        boolean isRole = false;
        for (Role r : roles) {
            if (r.getRoleName().equals("USER")) {
                user.setRoles(new HashSet<Role>(Arrays.asList(r)));
                isRole = true;
                break;
            }
        }
        if (!isRole) {
            Role role = new Role();
            role.setRoleName("USER");
            user.setRoles(new HashSet<Role>(Arrays.asList(role)));
        }
        userRepository.save(user);
        return user;

    }

    @Override
    public User getById(Long id) {
        return this.userRepository.findById(id).get();
    }

    @Override
    public List<User> getAll() {
        return this.userRepository.findAll();
    }

    @Override
    public void deleteById(Long id) {
        this.userRepository.deleteById(id);
    }

    @Override
    public void deleteAll() {
        this.userRepository.deleteAll();
    }


}

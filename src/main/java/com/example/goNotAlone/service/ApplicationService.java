package com.example.goNotAlone.service;

import com.example.goNotAlone.enums.ApplicationStatus;
import com.example.goNotAlone.model.Application;
import com.example.goNotAlone.model.Event;
import com.example.goNotAlone.model.User;
import com.example.goNotAlone.repository.ApplicationRepository;
import com.example.goNotAlone.repository.EventRepository;
import com.example.goNotAlone.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class ApplicationService implements GenericService<Application>, ApplicationServiceInterface {
    @Autowired
    private ApplicationRepository applicationRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private EventRepository eventRepository;




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
    public Application confirmApp(Long userId, Long appId) {
        // User user = userRepository.findById(userId).get();
        Application app = applicationRepository.findById(appId).get();
        if (app.getEvent().getPlace() == null) {
            app.setStatus(ApplicationStatus.REJECTED);
        } else {
            app.setStatus(ApplicationStatus.APPROVED);
        }
        applicationRepository.save(app);
        return app;
    }


    @Override
    public Application addG(Application application) {
        return null;
    }

    @Override
    public Application getById(Long id) {
        return applicationRepository.findById(id).get();
    }

    @Override
    public List<Application> getAll() {
        return applicationRepository.findAll();
    }

    @Override
    public void deleteById(Long id) {
        applicationRepository.deleteById(id);
    }

    @Override
    public void deleteAll() {
        applicationRepository.deleteAll();
    }
}

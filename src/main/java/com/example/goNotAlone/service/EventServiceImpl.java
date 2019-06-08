package com.example.goNotAlone.service;

import com.example.goNotAlone.enums.ApplicationStatus;
import com.example.goNotAlone.enums.Category;
import com.example.goNotAlone.model.Application;
import com.example.goNotAlone.model.Event;
import com.example.goNotAlone.model.Place;
import com.example.goNotAlone.model.User;
import com.example.goNotAlone.repository.ApplicationRepository;
import com.example.goNotAlone.repository.EventRepository;
import com.example.goNotAlone.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.List;

@Service
public class EventServiceImpl implements GenericService<Event>, EventService {
    @Autowired
    private EventRepository activityRepository;
    @Autowired
    private ApplicationRepository applicationRepository;
    @Autowired
    private UserRepository userRepository;


    @Override
    public Event addG(Event activity) {
        return this.activityRepository.save(activity);
    }

    @Override
    public Event getById(Long id) {
        return this.activityRepository.findById(id).get();
    }

    @Override
    public List getAll() {
        return this.activityRepository.findAll();
    }

    @Override
    public void deleteById(Long id) {
        this.activityRepository.deleteById(id);
    }

    @Override
    public void deleteAll() {
        this.activityRepository.deleteAll();
    }

    @Override
    public List<Event> getEventByDate(Calendar calendar) {
        return null;
    }

    @Override
    public List<Event> getEventByCategory(String category,Long id) {

       // Event event = activityRepository.findAll();
        return null;
    }

    @Override
    public List<Event> getEventByUser(Long userId, Long eventId) {


        return null;
    }

    @Override
    public List<Event> getEventByPlace(String place) {
        return null;
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
    public Application click(Long userId, Long appId) {
        Application app = applicationRepository.findById(appId).get();
        List<User> users = app.getUserList();
        if (app.getStatus().equals(ApplicationStatus.APPROVED)) {
            users.add(userRepository.findById(userId).get());
            app.setUserList(users);
        }
        applicationRepository.save(app);
        return app;
    }

}

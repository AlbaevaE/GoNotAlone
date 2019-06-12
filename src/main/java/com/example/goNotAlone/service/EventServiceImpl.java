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


import java.util.List;
import java.util.stream.Collectors;

@Service
public class EventServiceImpl implements GenericService<Event>, EventService {
    @Autowired
    private EventRepository eventRepository;
    @Autowired
    private ApplicationRepository applicationRepository;
    @Autowired
    private UserRepository userRepository;


    @Override
    public Event addG(Event activity) {
        return this.eventRepository.save(activity);
    }

    @Override
    public Event getById(Long id) {
        return this.eventRepository.findById(id).get();
    }

    @Override
    public List getAll() {
        return this.eventRepository.findAll();
    }

    @Override
    public void deleteById(Long id) {
        this.eventRepository.deleteById(id);
    }

    @Override
    public void deleteAll() {
        this.eventRepository.deleteAll();
    }

    @Override
    public Event getEventByDate(String calendar) {
        return null;
        // return eventRepository.findAll().stream().filter(x -> x.getCalendar().equals(calendar)).collect(Collectors.toList());
    }

    @Override
    public List<Event> findByCategory(Long eventId,String category) {
        List<Event> ev = eventRepository.findByCategory(eventId,category);
        return ev;
        //return eventRepository.findAll().stream().filter(x -> x.getCategory().equals(category)).collect(Collectors.toList());
    }

//    @Override
//    public Event getEventByUser(Long userId,Long eventId) {
//        Event ev = eventRepository.findById(eventId).get();
//
//        return null;
//
//        //return eventRepository.findAll().stream().filter(x -> x.getUser().getId().equals(id)).collect(Collectors.toList());
//
//    }

//    @Override
//    public List<Event> getEventByPlace(Long id) {
//        return eventRepository.findAll().stream().filter(x -> x.getPlace().getId().equals(id)).collect(Collectors.toList());
//    }


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

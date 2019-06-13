package com.example.goNotAlone.service;

import com.example.goNotAlone.enums.ApplicationStatus;

import com.example.goNotAlone.enums.Category;
import com.example.goNotAlone.model.Event;

import com.example.goNotAlone.model.Place;
import com.example.goNotAlone.model.User;
import com.example.goNotAlone.repository.EventRepository;
import com.example.goNotAlone.repository.PlaceRepository;
import com.example.goNotAlone.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class EventServiceImpl implements GenericService<Event>, EventService {
    @Autowired
    private EventRepository eventRepository;
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PlaceRepository placeRepository;

    @Override
    public Event addApp(Long userId, String name, Long placeId, String description, Category category) {
        User user = userRepository.findById(userId).get();
        Event event = new Event();
        event.setUser(user);
        event.setName(name);
        Place place = placeRepository.findById(placeId).get();
        event.setPlace(place);
        event.setDescription(description);
        event.setCategory(category);
        event.setStatus(ApplicationStatus.AWAITING);
        eventRepository.save(event);
        return event;
    }

    @Override
    public Event confirmApp(Long userId, Long evId) {
        // User user = userRepository.findById(userId).get();
        Event ev = eventRepository.findById(evId).get();
        if (ev.getPlace() == null) {
            ev.setStatus(ApplicationStatus.REJECTED);
        } else {
            ev.setStatus(ApplicationStatus.APPROVED);
        }
        eventRepository.save(ev);
        return ev;
    }


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

//    @Override
//    public List<Event> findByCategory(Long eventId,String category) {
//        List<Event> ev = eventRepository.findByCategory(eventId,category);
//        return ev;
//        //return eventRepository.findAll().stream().filter(x -> x.getCategory().equals(category)).collect(Collectors.toList());
//    }

    @Override
    public Event getEventByUser(Long userId, Long eventId) {
        Event ev = eventRepository.findById(eventId).get();

        return null;

        // return eventRepository.findAll().stream().filter(x -> x.getUser().getId().equals(userId)).collect(Collectors.toList());

    }

//    @Override
//    public List<Event> getEventByPlace(Long id) {
//        return eventRepository.findAll().stream().filter(x -> x.getPlace().getId().equals(id)).collect(Collectors.toList());
//    }


    @Override
    public Event click(Long userId, Long appId) {
        Event app = eventRepository.findById(appId).get();
        List<User> users = app.getUserList();
        if (app.getStatus().equals(ApplicationStatus.APPROVED)) {
            users.add(userRepository.findById(userId).get());
            app.setUserList(users);
        }
        eventRepository.save(app);
        return app;
    }

}

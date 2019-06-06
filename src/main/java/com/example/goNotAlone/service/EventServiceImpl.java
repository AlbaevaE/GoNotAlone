package com.example.goNotAlone.service;

import com.example.goNotAlone.enums.Category;
import com.example.goNotAlone.model.Event;
import com.example.goNotAlone.model.Place;
import com.example.goNotAlone.model.User;
import com.example.goNotAlone.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.List;

@Service
public class EventServiceImpl implements GenericService<Event>,EventService {
    @Autowired
    private EventRepository activityRepository;


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
    public List<Event> getEventByCategory(Category category) {
        return null;
    }

    @Override
    public List<Event> getEventByUser(User user) {
        return null;
    }

    @Override
    public List<Event> getEventByPlace(Place place) {
        return null;
    }
}

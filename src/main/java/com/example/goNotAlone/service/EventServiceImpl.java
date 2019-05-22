package com.example.goNotAlone.service;

import com.example.goNotAlone.model.Event;
import com.example.goNotAlone.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventServiceImpl implements GenericService<Event> {
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
}

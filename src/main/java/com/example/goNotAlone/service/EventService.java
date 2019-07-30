package com.example.goNotAlone.service;


import com.example.goNotAlone.enums.Category;
import com.example.goNotAlone.model.Event;

public interface EventService {
    Event getEventByDate(String calendar);

    // List<Event> findByCategory(Long eventId,String category);

    Event getEventByUser(Long userId, Long eventId);

    // List<Event> getEventByPlace(Long id);


    Event click(Long userId, Long evId);

    Event addApp(Long userId, String name, Long placeId, String description, Category category);

    Event confirmApp(Long userId, Long evId);
}

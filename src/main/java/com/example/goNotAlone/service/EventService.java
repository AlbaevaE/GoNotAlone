package com.example.goNotAlone.service;


import com.example.goNotAlone.model.Application;
import com.example.goNotAlone.model.Event;

import com.example.goNotAlone.model.User;

import java.util.Calendar;
import java.util.List;

public interface EventService {
    List<Event> getEventByDate(String calendar);

    Event getEventByCategory(String category);

   // Event getEventByUser(Long userId,Long eventId);

    //List<Event> getEventByPlace(Long id);


    Application click(Long userId, Long appId);
}

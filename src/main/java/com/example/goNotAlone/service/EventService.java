package com.example.goNotAlone.service;

import com.example.goNotAlone.enums.Category;
import com.example.goNotAlone.model.Application;
import com.example.goNotAlone.model.Event;

import com.example.goNotAlone.model.User;

import java.util.Calendar;
import java.util.List;

public interface EventService {
    List<Event> getEventByDate(Calendar calendar);

    List<Event> getEventByCategory(Category category);

    List<Event> getEventByUser(User user);

    List<Event> getEventByPlace(String place);

    Application confirmApp(Long userId, Long appId);

    Application click(Long userId, Long appId);
}

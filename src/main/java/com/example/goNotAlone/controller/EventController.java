package com.example.goNotAlone.controller;

import com.example.goNotAlone.model.Application;
import com.example.goNotAlone.model.Event;
import com.example.goNotAlone.model.Response;
import com.example.goNotAlone.repository.EventRepository;
import com.example.goNotAlone.service.ApplicationService;
import com.example.goNotAlone.service.EventServiceImpl;
import com.example.goNotAlone.service.GenericService;
import com.example.goNotAlone.util.Confirm;
import com.example.goNotAlone.util.FindByCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/event")
public class EventController {
    @Autowired
    private GenericService<Event> genericService;
    @Autowired
    private EventServiceImpl eventService;

    @Autowired
    private EventRepository eventRepository;

    @GetMapping("/getEventById/{id}")
    public Event getEventById(@PathVariable Long id) {
        return this.genericService.getById(id);
    }

    @GetMapping("/getAllEvent")
    public List<Event> getAllEvent() {
        return this.genericService.getAll();
    }

    @PostMapping("/addEvent")
    @ResponseStatus(HttpStatus.CREATED)
    public Event createEvent(@RequestBody Event a) {
        return this.genericService.addG(a);
    }

    @DeleteMapping
    @RequestMapping("/deleteEvent/{id}")
    public void deleteEvent(@PathVariable Long id) {
        this.genericService.deleteById(id);
    }

    @DeleteMapping("/deleteAllEvent")
    public void deleteAllEvent() {
        this.genericService.deleteAll();
    }

    @PutMapping("/click")
    public Application click(@RequestBody Confirm u) {
        return this.eventService.click(u.getUserId(), u.getAppId());
    }

    @GetMapping("/getEventsByUser/{id}")
    public List<Event> getEventsByUserId(@PathVariable Long id) {
        return eventRepository.findByUserId(id);
    }

    @GetMapping("/getEventsByPlace/{id}")
    public List<Event> getEventByPlace(@PathVariable Long id) {
        return eventRepository.findByPlaceId(id);

    }

    @GetMapping("/getEventByCategory/{eventId}/{category}")
    public List<Event> findByCategory(@PathVariable Long eventId, @PathVariable String category) {
        return eventRepository.findByCategory(eventId, category);
    }
}

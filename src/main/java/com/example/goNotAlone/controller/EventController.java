package com.example.goNotAlone.controller;

import com.example.goNotAlone.model.Event;

import com.example.goNotAlone.repository.EventRepository;

import com.example.goNotAlone.repository.UserRepository;
import com.example.goNotAlone.service.EventServiceImpl;
import com.example.goNotAlone.service.GenericService;
import com.example.goNotAlone.util.AddApp;
import com.example.goNotAlone.util.Confirm;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;


import java.security.Principal;
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
    @Autowired
    private UserRepository userRepository;

    @Secured("ROLE_ADMIN")
    @GetMapping("/getEventById/{id}")
    public Event getEventById(@PathVariable Long id) {
        return this.genericService.getById(id);
    }


    @Secured("ROLE_USER")
    @GetMapping("/getAllEvent")
    public List<Event> getAllEvent() {
        return this.genericService.getAll();
    }

    @Secured("ROLE_USER")
    @PostMapping("/addEven")
    @ResponseStatus(HttpStatus.CREATED)
    public Event createEvent(Principal principal, @RequestBody Event a) {
        a.setUser(userRepository.findByName(principal.getName()));
        return this.genericService.addG(a);
    }

    @Secured("ROLE_ADMIN")
    @PutMapping("/confirm")
    public Event confirm(@RequestBody Confirm confirm) {
        return eventService.confirmApp(confirm.getUserId(), confirm.getAppId());
    }

    @Secured("ROLE_ADMIN")
    @PostMapping("/addEvent")
    @ResponseStatus(HttpStatus.CREATED)
    public Event add(@RequestBody AddApp a) {
        return eventService.addApp(a.getUserId(), a.getName(), a.getPlaceId(), a.getDescription(), a.getCategory());
    }

    @Secured("ROLE_ADMIN")
    @DeleteMapping
    @RequestMapping("/deleteEvent/{id}")
    public void deleteEvent(Principal principal, @PathVariable Long id) {
        this.genericService.deleteById(id);
    }

    @Secured("ROLE_ADMIN")
    @DeleteMapping("/deleteAllEvent")
    public void deleteAllEvent() {
        this.genericService.deleteAll();
    }

    @Secured("ROLE_ADMIN")
    @PutMapping("/click")
    public Event click(@RequestBody Confirm u) {
        return this.eventService.click(u.getUserId(), u.getAppId());
    }

    @Secured("ROLE_ADMIN")
    @GetMapping("/getEventsByUser/{id}")
    public List<Event> getEventsByUserId(@PathVariable Long id) {
        return eventRepository.findByUserId(id);
    }

    @Secured("ROLE_ADMIN")
    @GetMapping("/getEventsByPlace/{id}")
    public List<Event> getEventByPlace(@PathVariable Long id) {
        return eventRepository.findByPlaceId(id);

    }

}

package com.example.goNotAlone.controller;

import com.example.goNotAlone.model.Application;
import com.example.goNotAlone.model.Event;
import com.example.goNotAlone.service.ApplicationService;
import com.example.goNotAlone.service.EventServiceImpl;
import com.example.goNotAlone.service.GenericService;
import com.example.goNotAlone.util.Confirm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/event")
public class EventController {
    @Autowired
    private GenericService<Event> genericService;
    @Autowired
    private EventServiceImpl eventService;

    @GetMapping(path = "getEventById/{id}", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public Event getEventById(@PathVariable Long id) {
        return this.genericService.getById(id);
    }

    @GetMapping(produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public List<Event> getAllEvent() {
        return this.genericService.getAll();
    }

    @PostMapping(produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public Event createEvent(@RequestBody Event a) {
        return this.genericService.addG(a);
    }

    @DeleteMapping
    @RequestMapping(path = "deleteEvent/{id}", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public void deleteEvent(@PathVariable Long id) {
        this.genericService.deleteById(id);
    }

    @DeleteMapping(produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public void deleteAllEvent() {
        this.genericService.deleteAll();
    }

    @PutMapping("/click")
    public Application click(@RequestBody Confirm u) {
        return this.eventService.click(u.getUserId(), u.getAppId());
    }
}

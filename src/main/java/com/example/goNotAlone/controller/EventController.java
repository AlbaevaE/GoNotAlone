package com.example.goNotAlone.controller;

import com.example.goNotAlone.model.Event;
import com.example.goNotAlone.service.GenericService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(EventController.URL_EVENT)
public class EventController {
    public static final String URL_EVENT = "/goNotAlone/Event";
    @Autowired
    private GenericService<Event> genericService;

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
}

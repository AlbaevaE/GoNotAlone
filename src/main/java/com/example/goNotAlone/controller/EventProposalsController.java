package com.example.goNotAlone.controller;

import com.example.goNotAlone.model.EventProposals;
import com.example.goNotAlone.service.GenericService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(EventProposalsController.URL_EVENT_PROPOSALS)
public class EventProposalsController {
    public static final String URL_EVENT_PROPOSALS = "/goNotAlone/eventProposals";

    @Autowired
    private GenericService<EventProposals> genericService;

    @GetMapping(path = "getEventProposalsById/{id}", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public EventProposals getEventProposals(@PathVariable Long id) {
        return this.genericService.getById(id);
    }

    @GetMapping(produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public List<EventProposals> getAllEventProposals() {
        return this.genericService.getAll();
    }

    @PostMapping(produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public EventProposals createEventProposals(@RequestBody EventProposals e) {
        return this.genericService.addG(e);
    }

    @DeleteMapping
    @RequestMapping(path = "deleteEventProposalsById/{id}", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public void deleteEventProposals(@PathVariable Long id) {
        this.genericService.deleteById(id);
    }

    @DeleteMapping(produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public void deleteAllEventProposals() {
        this.genericService.deleteAll();
    }

}

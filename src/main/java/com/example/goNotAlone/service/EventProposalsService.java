package com.example.goNotAlone.service;

import com.example.goNotAlone.model.EventProposals;
import com.example.goNotAlone.repository.EventProposalsRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class EventProposalsService implements GenericService<EventProposals> {
    @Autowired
    private EventProposalsRepository eventProposalsRepository;


    @Override
    public EventProposals addG(EventProposals eventProposals) {
        return this.eventProposalsRepository.save(eventProposals);
    }

    @Override
    public EventProposals getById(Long id) {
        return this.eventProposalsRepository.findById(id).get();
    }

    @Override
    public List<EventProposals> getAll() {
        return this.eventProposalsRepository.findAll();
    }

    @Override
    public void deleteById(Long id) {
           this.eventProposalsRepository.deleteById(id);
    }

    @Override
    public void deleteAll() {
         this.eventProposalsRepository.deleteAll();
    }
}

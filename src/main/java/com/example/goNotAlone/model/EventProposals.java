package com.example.goNotAlone.model;

import lombok.Data;


import javax.persistence.*;
@Data

@Entity
@Table(name = "event_proposal")
public class EventProposals {//предложения по мероприятиям
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;
    @OneToOne
    @JoinColumn(name = "place_id")
    private Place place;
    @OneToOne
    @JoinColumn(name = "event_id")
    private Event event;

    public EventProposals() {
    }

    public EventProposals( User user, Place place, Event event) {
        this.user = user;
        this.place = place;
        this.event = event;
    }
}

package com.example.goNotAlone.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "event")
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    @OneToOne
    @JoinColumn(name = "place_id")
    private Place place;
    private String description;//описание
//время и дату
    //поиск по месту или дате или названию
    //категория мероприятия

    public Event() {
    }

    public Event(String name, Place place, String description) {
        this.id = id;
        this.name = name;
        this.place = place;
        this.description = description;
    }
}

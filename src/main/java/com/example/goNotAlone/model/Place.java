package com.example.goNotAlone.model;

import lombok.Data;


import javax.persistence.*;

@Data
@Entity
@Table(name = "place")
public class Place {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String place;//описание
    @OneToOne
    @JoinColumn(name = "map_id")
    private Map map;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

    //todo sort by place

    public Place() {
    }

    public Place(String place) {
        this.place = place;
    }
}

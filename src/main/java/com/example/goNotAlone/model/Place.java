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
    private String place;


    public Place() {
    }

    public Place(Long id, String place) {
        this.id = id;
        this.place = place;
    }
}

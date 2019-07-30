package com.example.goNotAlone.model;


import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "map")
public class Map {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Double longitude;//долгота
    private Double latitude;//широта


    public Map() {

    }

    public Map(double lat, double lon) {
        this.latitude = lat;
        this.longitude = lon;

    }



}

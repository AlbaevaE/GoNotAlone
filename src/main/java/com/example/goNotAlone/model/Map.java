package com.example.goNotAlone.model;


import javax.persistence.*;

@Entity
@Table(name = "map")
public class Map {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Double longitude;//долгота
    private Double latitude;//широта
    private Double h;

    public Map() {

    }

    public Map(double lat, double lon) {
        this.latitude = lat;
        this.longitude = lon;

    }

    public Map(double lat, double lon, double h) {
        this.latitude = lat;
        this.longitude = lon;
        this.h = h;
    }

}

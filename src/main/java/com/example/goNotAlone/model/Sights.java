package com.example.goNotAlone.model;


import lombok.Data;


import javax.persistence.*;

@Data
@Entity
@Table(name = "sights")
public class Sights {//достопримечательности
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    @OneToOne
    @JoinColumn(name = "place_id")
    private Place place;

    public Sights() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Place getPlace() {
        return place;
    }

    public void setPlace(Place place) {
        this.place = place;
    }

    public Sights(String name, Place place) {
        this.name = name;
        this.place = place;
    }
}

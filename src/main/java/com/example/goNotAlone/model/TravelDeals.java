package com.example.goNotAlone.model;


import lombok.Data;


import javax.persistence.*;

@Data
@Entity
@Table(name = "travel_deals")
public class TravelDeals {// предложения по поездкам
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
    private Event activity;

    public TravelDeals() {
    }

    public TravelDeals(User user, Place place, Event activity) {
        this.user = user;
        this.place = place;
        this.activity = activity;
    }
}

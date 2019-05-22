package com.example.goNotAlone.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Table;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "travel_deals")
public class TravelDeals extends AbstractSuggest {// предложения по поездкам


}

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
@Table(name = "event_proposal")
public class EventProposals extends AbstractSuggest {//предложения по мероприятиям
}

package com.example.goNotAlone.repository;


import com.example.goNotAlone.model.Event;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventRepository extends JpaRepository<Event,Long> { //поиск по месту или дате или названию
}

package com.example.goNotAlone.repository;


import com.example.goNotAlone.model.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


import java.util.List;

public interface EventRepository extends JpaRepository<Event,Long> { //поиск по месту или дате или названию

    @Query(value = "select * from event_1 e join user1 u on e.user_id = :id" , nativeQuery = true)
    List<Event> findByUserId(@Param("id") Long id);

    @Query(value = "select * from event_1 e join place p on e.place_id = :id" , nativeQuery = true)
    List<Event> findByPlaceId(@Param("id") Long id);




}

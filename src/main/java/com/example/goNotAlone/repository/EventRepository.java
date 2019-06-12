package com.example.goNotAlone.repository;


import com.example.goNotAlone.model.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


import java.util.List;

public interface EventRepository extends JpaRepository<Event,Long> { //поиск по месту или дате или названию

    @Query(value = "select * from event_1 e join usr u on e.user_id = :id" , nativeQuery = true)
    List<Event> findByUserId(@Param("id") Long id);

    @Query(value = "select * from event_1 e join place p on e.place_id = :id and " , nativeQuery = true)
    List<Event> findByPlaceId(@Param("id") Long id);
//
    @Query(value = "select e from event_1 e where e.event_id = :id and e.category = :category" , nativeQuery = true)
    List<Event> findByCategory(@Param("id") Long id , @Param("category")String category);


}

package com.example.goNotAlone.repository;


import com.example.goNotAlone.model.Activity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ActivityRepository extends JpaRepository<Activity,Long> {
}

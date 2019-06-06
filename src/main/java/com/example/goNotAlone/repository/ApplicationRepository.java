package com.example.goNotAlone.repository;

import com.example.goNotAlone.model.Application;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ApplicationRepository extends JpaRepository<Application,Long> {
}

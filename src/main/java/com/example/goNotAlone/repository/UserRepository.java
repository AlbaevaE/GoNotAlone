package com.example.goNotAlone.repository;

import com.example.goNotAlone.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
}

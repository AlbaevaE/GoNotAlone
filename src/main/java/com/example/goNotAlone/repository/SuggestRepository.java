package com.example.goNotAlone.repository;

import com.example.goNotAlone.model.AbstractSuggest;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SuggestRepository extends JpaRepository<AbstractSuggest,Long> {
}

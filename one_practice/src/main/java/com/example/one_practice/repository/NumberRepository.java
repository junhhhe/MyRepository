package com.example.one_practice.repository;

import com.example.one_practice.entity.Number;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface NumberRepository extends JpaRepository<Number, Long> {
    Optional<Number> findByName(String name);
}

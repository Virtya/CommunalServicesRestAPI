package com.example.comservices.repository;

import com.example.comservices.entity.Individual;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IndividualRepository extends JpaRepository<Individual,Long> {
    Optional<Individual> findByNumber(Long number);
}

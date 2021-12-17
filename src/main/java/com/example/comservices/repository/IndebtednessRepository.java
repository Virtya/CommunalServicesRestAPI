package com.example.comservices.repository;

import com.example.comservices.entity.Indebtedness;
import com.example.comservices.entity.Individual;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IndebtednessRepository extends JpaRepository<Indebtedness,Long> {
    boolean existsByIndividual(Individual individual);
}

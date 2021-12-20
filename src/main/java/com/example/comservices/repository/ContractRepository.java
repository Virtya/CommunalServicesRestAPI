package com.example.comservices.repository;

import com.example.comservices.entity.Contract;
import com.example.comservices.entity.Individual;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContractRepository extends JpaRepository<Contract,Long> {
    boolean existsByNumber(Long number);
}

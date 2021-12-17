package com.example.comservices.controller;

import com.example.comservices.entity.Contract;
import com.example.comservices.model.ContractModel;
import com.example.comservices.service.ComServicesServiceContract;
import com.example.comservices.serviceimpl.ComServicesServiceContractImpl;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@AllArgsConstructor
@RequestMapping("/contract")

public class ContractController {
    private final ComServicesServiceContractImpl comServicesServiceContract;
    @GetMapping("/{id}")
    public ResponseEntity<Contract> getContractById(@PathVariable Long id){
        return new ResponseEntity<>(comServicesServiceContract.getContractById(id), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity <List<Contract>> getContracts(){
        return new ResponseEntity<>(comServicesServiceContract.getContracts(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Contract> addContract(@RequestBody ContractModel contractModel){
        return new ResponseEntity<>(comServicesServiceContract.addContract(contractModel), HttpStatus.CREATED);
    }

    @PutMapping ("/{id}")
    public ResponseEntity<Contract> updateContract(@PathVariable Long id, @RequestBody ContractModel contractModel){
        return new ResponseEntity<>(comServicesServiceContract.updateContract(id, contractModel), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(value = HttpStatus.OK)
    public void deleteContractById(@PathVariable Long id){
       comServicesServiceContract.deleteContractById(id);
    }
}


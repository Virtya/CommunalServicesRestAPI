package com.example.comservices.controller;

import com.example.comservices.entity.Individual;
import com.example.comservices.model.IndividualModel;
import com.example.comservices.service.ComServicesServiceIndividual;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@AllArgsConstructor
@RequestMapping("/individual")

public class IndividualController {
    private final ComServicesServiceIndividual comServicesServiceIndividual;
    @GetMapping("/{id}")
    public ResponseEntity<Individual> getIndividualById(@PathVariable Long id){
        return new ResponseEntity<>(comServicesServiceIndividual.getIndividualById(id), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity <List<Individual>> getIndividuals(){
        return new ResponseEntity<>(comServicesServiceIndividual.getIndividuals(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Individual> addIndividual(@RequestBody IndividualModel individualModel){
        return new ResponseEntity<>(comServicesServiceIndividual.addIndividual(individualModel), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Individual> updateIndividual(@PathVariable Long id, @RequestBody IndividualModel individualModel){
        return new ResponseEntity<>(comServicesServiceIndividual.updateIndividual(id, individualModel), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(value = HttpStatus.OK)
    public void deleteIndividualById(@PathVariable Long id){
        comServicesServiceIndividual.deleteIndividualById(id);
    }
}


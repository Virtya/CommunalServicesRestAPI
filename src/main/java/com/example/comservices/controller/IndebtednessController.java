package com.example.comservices.controller;

import com.example.comservices.entity.Indebtedness;
import com.example.comservices.model.IndebtednessModel;
import com.example.comservices.service.ComServicesServiceIndebtedness;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@AllArgsConstructor
@RequestMapping("/indebtedness")

public class IndebtednessController {
    private final ComServicesServiceIndebtedness comServicesServiceIndebtedness;
    @GetMapping("/{id}")
    public ResponseEntity<Indebtedness> getIndebtednessById(@PathVariable Long id){
        return new ResponseEntity<>(comServicesServiceIndebtedness.getIndebtednessById(id), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity <List<Indebtedness>> getIndebtedness(){
        return new ResponseEntity<>(comServicesServiceIndebtedness.getIndebtedness(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Indebtedness> addIndebtedness(@RequestBody IndebtednessModel indebtednessModel){
        return new ResponseEntity<>(comServicesServiceIndebtedness.addIndebtedness(indebtednessModel), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Indebtedness> updateIndebtedness(@PathVariable Long id, @RequestBody IndebtednessModel indebtednessModel){
        return new ResponseEntity<>(comServicesServiceIndebtedness.updateIndebtedness(id, indebtednessModel), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(value = HttpStatus.OK)
    public void deleteIndebtednessById(@PathVariable Long id){
        comServicesServiceIndebtedness.deleteIndebtednessById(id);
    }
}

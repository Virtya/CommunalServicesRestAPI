package com.example.comservices.service;

import com.example.comservices.entity.Individual;
import com.example.comservices.model.IndividualModel;

import java.util.List;

public interface ComServicesServiceIndividual {

    Individual getIndividualById(Long id);

    List<Individual> getIndividuals();

    Individual addIndividual(IndividualModel individualModel);

    Individual updateIndividual(Long id, IndividualModel individualModel);

    void deleteIndividualById(Long id);
}

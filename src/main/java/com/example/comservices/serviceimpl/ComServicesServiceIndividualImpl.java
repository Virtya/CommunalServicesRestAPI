package com.example.comservices.serviceimpl;

import com.example.comservices.entity.Individual;
import com.example.comservices.exception.ResourceNotFoundException;
import com.example.comservices.model.IndividualModel;
import com.example.comservices.repository.IndividualRepository;
import com.example.comservices.service.ComServicesServiceIndividual;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ComServicesServiceIndividualImpl implements ComServicesServiceIndividual {
    private final IndividualRepository individualRepository;

    @Override
    public Individual getIndividualById(Long id) {
        return individualRepository.findByNumber(id).orElseThrow(() -> new ResourceNotFoundException("The individual with id="+id +" does not exist."));
    }

    @Override
    public List<Individual> getIndividuals() {
        return individualRepository.findAll();
    }

    @Override
    public Individual addIndividual(IndividualModel individualModel) {
        Individual individual =  Individual.builder()
                .fio(individualModel.getFio())
                .gender(individualModel.getGender())
                .birth_date(individualModel.getBirth_date())
                .build();
        individualRepository.save(individual);
        return individual;
    }

    @Override
    public Individual updateIndividual(Long id, IndividualModel individualModel) {
        Individual individual = individualRepository.findByNumber(id).orElseThrow(()->new ResourceNotFoundException(
                "The individual with id="+ id +" does not exist."));
        individual.setFio(individualModel.getFio());
        individual.setGender(individualModel.getGender());
        individual.setBirth_date(individualModel.getBirth_date());
        individualRepository.save(individual);
        return individual;
    }

    @Override
    public void deleteIndividualById(Long id) {
        individualRepository.deleteById(id);
    }
}

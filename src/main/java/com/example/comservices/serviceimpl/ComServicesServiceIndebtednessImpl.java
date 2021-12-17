package com.example.comservices.serviceimpl;

import com.example.comservices.entity.Contract;
import com.example.comservices.entity.Indebtedness;
import com.example.comservices.entity.Individual;
import com.example.comservices.exeption.ResourceAlreadyExistsException;
import com.example.comservices.exeption.ResourceNotFoundException;
import com.example.comservices.model.IndebtednessModel;
import com.example.comservices.repository.IndebtednessRepository;
import com.example.comservices.repository.IndividualRepository;
import com.example.comservices.service.ComServicesServiceIndebtedness;
import lombok.AllArgsConstructor;
import lombok.Builder;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

@Service
@AllArgsConstructor
public class ComServicesServiceIndebtednessImpl implements ComServicesServiceIndebtedness {
    private final IndebtednessRepository indebtednessRepository;
    private final IndividualRepository individualRepository;

    @Override
    public Indebtedness getIndebtednessById(Long id) {
        return indebtednessRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("The contract with id="+id +" does not exist."));
    }

    @Override
    public List<Indebtedness> getIndebtedness() {
        return indebtednessRepository.findAll();
    }

    @Override
    public Indebtedness addIndebtedness(IndebtednessModel indebtednessModel) {
        Individual individual = individualRepository.findByNumber(indebtednessModel.getNumber())
                .orElseThrow(()->new ResourceNotFoundException(
                        "The individual with number = "+indebtednessModel.getNumber()+" does not exist." ));
        /*if (indebtednessRepository.existsByIndividual(individual)){
            throw new ResourceAlreadyExistsException("The contract with such individual and id already exist.");
        }*/
        Indebtedness indebtedness =  Indebtedness.builder()
                .individual(individual)
                .sum(indebtednessModel.getSum())
                .build();
        indebtednessRepository.save(indebtedness);
        return indebtedness;
    }

    @Override
    public Indebtedness updateIndebtedness(Long id, IndebtednessModel indebtednessModel) {
        Individual individual = individualRepository.findByNumber(indebtednessModel.getNumber())
                .orElseThrow(()->new ResourceNotFoundException(
                        "The individual with number = "+indebtednessModel.getNumber()+" does not exist." ));

        Indebtedness indebtedness = indebtednessRepository.findById(id).orElseThrow(()->new ResourceNotFoundException(
                "The indebtedness with id="+ id +" does not exist."));
        indebtedness.setIndividual(individual);
        indebtedness.setSum(indebtednessModel.getSum());
        indebtednessRepository.save(indebtedness);
        return indebtedness;
    }

    @Override
    public void deleteIndebtednessById(Long id) {
        indebtednessRepository.deleteById(id);
    }
}

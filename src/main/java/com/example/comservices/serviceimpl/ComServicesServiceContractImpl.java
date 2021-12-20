package com.example.comservices.serviceimpl;

import com.example.comservices.entity.Contract;
import com.example.comservices.entity.Individual;
import com.example.comservices.exception.ResourceNotFoundException;
import com.example.comservices.model.ContractModel;
import com.example.comservices.repository.ContractRepository;
import com.example.comservices.repository.IndividualRepository;
import com.example.comservices.service.ComServicesServiceContract;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor

public class ComServicesServiceContractImpl implements ComServicesServiceContract {
    private final ContractRepository contractRepository;
    private final IndividualRepository individualRepository;

    @Override
    public Contract getContractById(Long id) {
        return contractRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("The contract with id="+id +" does not exist."));
    }

    @Override
    public List<Contract> getContracts() {
        return contractRepository.findAll();
    }

    @Override
    public Contract addContract(ContractModel contractModel) {
        Individual individual = individualRepository.findById(contractModel.getNumber())
                .orElseThrow(()->new ResourceNotFoundException(
                        "The individual with number = "+contractModel.getNumber()+" does not exist." ));
        Contract contract = Contract.builder()
                        .individual(individual)
                        .validity(contractModel.getValidity())
                        .region(contractModel.getRegion())
                        .federal_law(contractModel.getFederal_law())
                        .build();
        contractRepository.save(contract);
        return contract;
    }

    @Override
    public Contract updateContract(Long id, ContractModel contractModel) {
        Individual individual = individualRepository
                .findById(contractModel.getNumber())
                .orElseThrow(()->new ResourceNotFoundException(
                        "The individual with number = "+contractModel.getNumber()+" does not exist." ));
        Contract contract = contractRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("The contract with id="+ id +" does not exist."));
        contract.setIndividual(individual);
        contract.setValidity(contractModel.getValidity());
        contract.setRegion(contractModel.getRegion());
        contract.setFederal_law(contractModel.getFederal_law());
        contractRepository.save(contract);
        return contract;
    }

    @Override
    public void deleteContractById(Long id) {
        contractRepository.deleteById(id);
    }
}

package com.example.comservices.service;

import com.example.comservices.entity.Contract;
import com.example.comservices.model.ContractModel;

import java.util.List;

public interface ComServicesServiceContract {

    Contract getContractById(Long id);

    List<Contract> getContracts();

    Contract addContract(ContractModel contractModel);

    Contract updateContract(Long id, ContractModel contractModel);

    void deleteContractById(Long id);
}

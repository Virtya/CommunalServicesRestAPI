package com.example.comservices.service;

import com.example.comservices.entity.Indebtedness;
import com.example.comservices.model.IndebtednessModel;

import java.util.List;

public interface ComServicesServiceIndebtedness {

    Indebtedness getIndebtednessById(Long id);

    List<Indebtedness> getIndebtedness();

    Indebtedness addIndebtedness(IndebtednessModel indebtednessModel);

    Indebtedness updateIndebtedness(Long id, IndebtednessModel indebtednessModel);

    void deleteIndebtednessById(Long id);
}

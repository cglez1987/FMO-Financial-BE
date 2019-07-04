/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dcarlidev.fmo.financial.services;

import com.dcarlidev.fmo.financial.beans.InsuranceType;
import com.dcarlidev.fmo.financial.repositories.InsuranceTypeRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author carlos
 */
@Service
public class InsuranceTypeService {

    @Autowired
    private InsuranceTypeRepository insuranceTypeRepo;

    public InsuranceType saveInsuranceType(InsuranceType insuranceType) {
        return this.insuranceTypeRepo.save(insuranceType);
    }

    public List<InsuranceType> getAllInsuranceTypes() {
        List<InsuranceType> insurances = new ArrayList<>();
        this.insuranceTypeRepo.findAll().forEach(e -> insurances.add(e));
        return insurances;
    }

    public InsuranceType findById(int id) {
        Optional<InsuranceType> insuranceType = this.insuranceTypeRepo.findById(id);
        if (insuranceType.isPresent()) {
            return insuranceType.get();
        } else {
            return null;
        }
    }

    public boolean editInsuranceType(InsuranceType insuranceType, int id) {
        if (this.insuranceTypeRepo.existsById(id)) {
            insuranceType.setId(id);
            this.insuranceTypeRepo.save(insuranceType);
            return true;
        } else {
            return false;
        }
    }

    public boolean deleteInsuranceType(int id) {
        if (this.insuranceTypeRepo.existsById(id)) {
            this.insuranceTypeRepo.deleteById(id);
            return true;
        } else {
            return false;
        }
    }

}

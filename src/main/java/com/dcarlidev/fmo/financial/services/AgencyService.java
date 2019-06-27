/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dcarlidev.fmo.financial.services;

import com.dcarlidev.fmo.financial.beans.Agency;
import com.dcarlidev.fmo.financial.repositories.AgencyRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author lisbet
 */
@Service
public class AgencyService {

    @Autowired
    private AgencyRepository agencyRepo;

    public Agency saveAgency(Agency agency) {
        return this.agencyRepo.save(agency);
    }

    public List<Agency> getAllAgencies() {
        List<Agency> agencies = new ArrayList<>();
        this.agencyRepo.findAll().forEach(e -> agencies.add(e));
        return agencies;
    }

    public Agency findById(int id) {
        Optional<Agency> agency = this.agencyRepo.findById(id);
        if (agency.isPresent()) {
            return agency.get();
        } else {
            return null;
        }
    }

    public boolean editAgency(Agency agency, int id) {
        Optional<Agency> temp = this.agencyRepo.findById(id);
        if (temp.isPresent()) {
            Agency a = temp.get();
            a.setId(id);
            this.agencyRepo.save(a);
            return true;
        } else {
            return false;
        }
    }

    public boolean deleteAgency(int id) {
        if (this.agencyRepo.existsById(id)) {
            this.agencyRepo.deleteById(id);
            return true;
        } else {
            return false;
        }
    }
}

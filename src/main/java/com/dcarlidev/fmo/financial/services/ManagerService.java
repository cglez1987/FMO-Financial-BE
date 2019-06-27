/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dcarlidev.fmo.financial.services;

import com.dcarlidev.fmo.financial.beans.Manager;
import com.dcarlidev.fmo.financial.repositories.ManagerRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author lisbet
 */
public class ManagerService {

    @Autowired
    private ManagerRepository managerRepo;

    public Manager saveManager(Manager manager) {
        return this.managerRepo.save(manager);
    }

    public List<Manager> getAllManagers() {
        List<Manager> managers = new ArrayList<>();
        this.managerRepo.findAll().forEach(e -> managers.add(e));
        return managers;
    }

    public Manager findById(int id) {
        Optional<Manager> manager = this.managerRepo.findById(id);
        if (manager.isPresent()) {
            return manager.get();
        } else {
            return null;
        }
    }

    public boolean editManager(Manager manager, int id) {
        Optional<Manager> temp = this.managerRepo.findById(id);
        if (temp.isPresent()) {
            Manager a = temp.get();
            a.setId(id);
            this.managerRepo.save(a);
            return true;
        } else {
            return false;
        }
    }

    public boolean deleteManager(int id) {
        if (this.managerRepo.existsById(id)) {
            this.managerRepo.deleteById(id);
            return true;
        } else {
            return false;
        }
    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dcarlidev.fmo.financial.repositories;

import com.dcarlidev.fmo.financial.beans.Manager;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author lisbet
 */
public interface ManagerRepository extends CrudRepository<Manager, Integer>{
    
}

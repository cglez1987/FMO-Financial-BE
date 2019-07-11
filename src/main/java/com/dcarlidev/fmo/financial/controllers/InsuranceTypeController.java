/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dcarlidev.fmo.financial.controllers;

import com.dcarlidev.fmo.financial.beans.InsuranceType;
import com.dcarlidev.fmo.financial.services.InsuranceTypeService;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author carlos
 */
@RestController
@RequestMapping(path = "/insuranceTypes")
public class InsuranceTypeController {

    @Autowired
    private InsuranceTypeService insuranceTypeService;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<InsuranceType>> getAllInsuranceTypes() {
        List<InsuranceType> listInsuranceTypes = this.insuranceTypeService.getAllInsuranceTypes();
        return new ResponseEntity(listInsuranceTypes, HttpStatus.OK);
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<InsuranceType> getInsuranceTypeById(@PathVariable int id) {
        ResponseEntity response;
        InsuranceType a = this.insuranceTypeService.findById(id);
        if (a == null) {
            response = new ResponseEntity(HttpStatus.NOT_FOUND);
        } else {
            response = new ResponseEntity(a, HttpStatus.OK);
        }
        return response;
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<InsuranceType> saveInsuranceType(@Valid @RequestBody InsuranceType insuranceType) {
        InsuranceType a = this.insuranceTypeService.saveInsuranceType(insuranceType);
        return new ResponseEntity(a, HttpStatus.OK);
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity editInsuranceType(@Valid
            @RequestBody InsuranceType insuranceType, @PathVariable int id) {
        ResponseEntity response;
        if (this.insuranceTypeService.editInsuranceType(insuranceType, id)) {
            response = new ResponseEntity(HttpStatus.OK);
        } else {
            response = new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return response;
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity deleteInsuranceType(@PathVariable int id) {
        ResponseEntity response;
        if (this.insuranceTypeService.deleteInsuranceType(id)) {
            response = new ResponseEntity(HttpStatus.OK);
        } else {
            response = new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return response;
    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dcarlidev.fmo.financial.controllers;

import com.dcarlidev.fmo.financial.beans.Agency;
import com.dcarlidev.fmo.financial.services.AgencyService;
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
@RequestMapping(path = "/agencies")
public class AgencyController {

    @Autowired
    private AgencyService agencyService;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<Agency>> getAllAgencies() {
        List<Agency> listAgencies = this.agencyService.getAllAgencies();
        return new ResponseEntity(listAgencies, HttpStatus.OK);
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Agency> getAgencyById(@PathVariable int id) {
        ResponseEntity response;
        Agency a = this.agencyService.findById(id);
        if (a == null) {
            response = new ResponseEntity(HttpStatus.NOT_FOUND);
        } else {
            response = new ResponseEntity(a, HttpStatus.OK);
        }
        return response;
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Agency> saveAgency(@Valid @RequestBody Agency agency) {
        Agency a = this.agencyService.saveAgency(agency);
        return new ResponseEntity(a, HttpStatus.OK);
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity editAgency(@Valid
            @RequestBody Agency agency, @PathVariable int id) {
        ResponseEntity response;
        if (this.agencyService.editAgency(agency, id)) {
            response = new ResponseEntity(HttpStatus.OK);
        } else {
            response = new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return response;
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity deleteAgency(@PathVariable int id) {
        ResponseEntity response;
        if (this.agencyService.deleteAgency(id)) {
            response = new ResponseEntity(HttpStatus.OK);
        } else {
            response = new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return response;
    }

}

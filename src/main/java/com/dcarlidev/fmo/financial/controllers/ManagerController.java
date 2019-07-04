/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dcarlidev.fmo.financial.controllers;

import com.dcarlidev.fmo.financial.beans.Manager;
import com.dcarlidev.fmo.financial.services.ManagerService;
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
@RequestMapping(path = "/managers")
public class ManagerController {

    @Autowired
    private ManagerService managerService;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<Manager>> getAllManagers() {
        List<Manager> listManagers = this.managerService.getAllManagers();
        return new ResponseEntity(listManagers, HttpStatus.OK);
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Manager> getManagerById(@PathVariable int id) {
        ResponseEntity response;
        Manager a = this.managerService.findById(id);
        if (a == null) {
            response = new ResponseEntity(HttpStatus.NOT_FOUND);
        } else {
            response = new ResponseEntity(a, HttpStatus.OK);
        }
        return response;
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.POST)
    public ResponseEntity<Manager> saveManager(@Valid @RequestBody Manager manager) {
        Manager a = this.managerService.saveManager(manager);
        return new ResponseEntity(a, HttpStatus.OK);
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity editManager(@Valid
            @RequestBody Manager manager, @PathVariable int id) {
        ResponseEntity response;
        if (this.managerService.editManager(manager, id)) {
            response = new ResponseEntity(HttpStatus.OK);
        } else {
            response = new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return response;
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity deleteManager(@PathVariable int id) {
        ResponseEntity response;
        if (this.managerService.deleteManager(id)) {
            response = new ResponseEntity(HttpStatus.OK);
        } else {
            response = new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return response;
    }
}

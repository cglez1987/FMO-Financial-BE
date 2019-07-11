/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dcarlidev.fmo.financial.controllers;

import com.dcarlidev.fmo.financial.beans.Agent;
import com.dcarlidev.fmo.financial.services.AgentService;
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
@RequestMapping(path = "/agents")
public class AgentController {

    @Autowired
    private AgentService agentService;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<Agent>> getAllAgents() {
        List<Agent> listAgents = this.agentService.getAllAgents();
        return new ResponseEntity(listAgents, HttpStatus.OK);
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Agent> getAgentById(@PathVariable int id) {
        ResponseEntity response;
        Agent a = this.agentService.findById(id);
        if (a == null) {
            response = new ResponseEntity(HttpStatus.NOT_FOUND);
        } else {
            response = new ResponseEntity(a, HttpStatus.OK);
        }
        return response;
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Agent> saveAgent(@Valid @RequestBody Agent agent) {
        Agent a = this.agentService.saveAgent(agent);
        return new ResponseEntity(a, HttpStatus.OK);
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity editAgent(@Valid
            @RequestBody Agent agent, @PathVariable int id) {
        ResponseEntity response;
        if (this.agentService.editAgent(agent, id)) {
            response = new ResponseEntity(HttpStatus.OK);
        } else {
            response = new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return response;
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity deleteAgent(@PathVariable int id) {
        ResponseEntity response;
        if (this.agentService.deleteAgent(id)) {
            response = new ResponseEntity(HttpStatus.OK);
        } else {
            response = new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return response;
    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dcarlidev.fmo.financial.services;

import com.dcarlidev.fmo.financial.beans.Agent;
import com.dcarlidev.fmo.financial.repositories.AgentRepository;
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
public class AgentService {

    @Autowired
    private AgentRepository agentRepo;

    public Agent saveAgent(Agent agent) {
        return this.agentRepo.save(agent);
    }

    public List<Agent> getAllAgents() {
        List<Agent> agents = new ArrayList<>();
        this.agentRepo.findAll().forEach(e -> agents.add(e));
        return agents;
    }

    public Agent findById(int id) {
        Optional<Agent> agent = this.agentRepo.findById(id);
        if (agent.isPresent()) {
            return agent.get();
        } else {
            return null;
        }
    }

    public boolean editAgent(Agent agent, int id) {
        Optional<Agent> temp = this.agentRepo.findById(id);
        if (temp.isPresent()) {
            Agent a = temp.get();
            a.setId(id);
            this.agentRepo.save(a);
            return true;
        } else {
            return false;
        }
    }

    public boolean deleteAgent(int id) {
        if (this.agentRepo.existsById(id)) {
            this.agentRepo.deleteById(id);
            return true;
        } else {
            return false;
        }
    }
}

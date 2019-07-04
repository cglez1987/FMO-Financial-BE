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
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import static org.mockito.ArgumentMatchers.any;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

/**
 *
 * @author carlos
 */
@RunWith(MockitoJUnitRunner.class)
public class AgentServiceTest {

    @Mock
    private AgentRepository repo;
    @InjectMocks
    private AgentService agentService;

    public AgentServiceTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of saveAgent method, of class AgentService.
     */
    @Test
    public void whenCallSaveAgentCorrectly_thenReturnSameAgent() {
        System.out.println("whensaveAgentCorrectly_thenReturnSameAgent");
        Agent agent = new Agent("TestName", "TestIdentificationNumber");
        Mockito.when(repo.save(any(Agent.class))).thenReturn(agent);
        Agent result = agentService.saveAgent(agent);
        assertEquals(agent, result);
    }

    /**
     * Test of getAllAgents method, of class AgentService.
     */
    @Test
    public void whenCallGetAllAgentsWithData_thenReturnListAllAgents() {
        System.out.println("whenCallGetAllAgentsWithData_thenReturnListAllAgents");
        List<Agent> expResult = new ArrayList<>();
        expResult.add(new Agent("Test1", "Identification1"));
        expResult.add(new Agent("Test2", "Identification2"));
        expResult.add(new Agent("Test3", "Identification3"));
        Mockito.when(repo.findAll()).thenReturn(expResult);
        List<Agent> result = agentService.getAllAgents();
        Assert.assertTrue(result.size() == 3);
    }

    /**
     * Test of findById method, of class AgentService.
     */
    @Test
    public void whenFindById_ExistId_thenReturnAgent() {
        System.out.println("whenFindById_ExistId_thenReturnAgent");
        Agent expResult = new Agent("TestName", "TestIdentification");
        Mockito.when(repo.findById(2)).thenReturn(Optional.of(new Agent("TestName", "TestIdentification")));
        Agent result = agentService.findById(2);
        assertEquals(expResult, result);
    }

    /**
     * Test of editAgent method, of class AgentService.
     */
    @Test
    public void whenEditCorrectlyAgent_thenReturnTrue() {
        System.out.println("whenEditCorrectlyAgent_thenReturnTrue");
        boolean expResult = true;
        Agent agent = new Agent("TestName", "TestIdentification");
        Mockito.when(repo.findById(2)).thenReturn(Optional.of(new Agent("TestName", "TestIdentification")));
        boolean result = agentService.editAgent(agent, 2);
        assertEquals(expResult, result);
    }

    /**
     * Test of editAgent method, of class AgentService.
     */
    @Test
    public void whenCallEditAgent_NotFoundAgent_thenReturnFalse() {
        System.out.println("whenCallEditAgent_NotFoundAgent_thenReturnFalse");
        Agent agent = new Agent("TestName", "TestIdentification");
        Mockito.when(repo.findById(2)).thenReturn(Optional.empty());
        boolean result = agentService.editAgent(agent, 2);
        Assert.assertFalse(result);
    }

    /**
     * Test of deleteAgent method, of class AgentService.
     */
    @Test
    public void whenDeleteAgentCorrectly_thenReturnTrue() {
        System.out.println("whenDeleteAgentCorrectly_thenReturnTrue");
        boolean expResult = true;
        Mockito.when(repo.existsById(2)).thenReturn(true);
        boolean result = agentService.deleteAgent(2);
        assertEquals(expResult, result);
    }

}

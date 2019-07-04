/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.dcarlidev.fmo.financial.controllers;

import com.dcarlidev.fmo.financial.beans.Agent;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.springframework.http.ResponseEntity;

/**
 *
 * @author carlos
 */
public class AgentControllerTest {

    public AgentControllerTest() {
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
     * Test of getAllAgents method, of class AgentController.
     */
    @Test
    public void testGetAllAgents() {
        System.out.println("getAllAgents");
        AgentController instance = new AgentController();
        ResponseEntity<List<Agent>> expResult = null;
        ResponseEntity<List<Agent>> result = instance.getAllAgents();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getAgentById method, of class AgentController.
     */
    @Test
    public void testGetAgentById() {
        System.out.println("getAgentById");
        int id = 0;
        AgentController instance = new AgentController();
        ResponseEntity<Agent> expResult = null;
        ResponseEntity<Agent> result = instance.getAgentById(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of saveAgent method, of class AgentController.
     */
    @Test
    public void testSaveAgent() {
        System.out.println("saveAgent");
        Agent agent = null;
        AgentController instance = new AgentController();
        ResponseEntity<Agent> expResult = null;
        ResponseEntity<Agent> result = instance.saveAgent(agent);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of editAgent method, of class AgentController.
     */
    @Test
    public void testEditAgent() {
        System.out.println("editAgent");
        Agent agent = null;
        int id = 0;
        AgentController instance = new AgentController();
        ResponseEntity expResult = null;
        ResponseEntity result = instance.editAgent(agent, id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of deleteAgent method, of class AgentController.
     */
    @Test
    public void testDeleteAgent() {
        System.out.println("deleteAgent");
        int id = 0;
        AgentController instance = new AgentController();
        ResponseEntity expResult = null;
        ResponseEntity result = instance.deleteAgent(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

}
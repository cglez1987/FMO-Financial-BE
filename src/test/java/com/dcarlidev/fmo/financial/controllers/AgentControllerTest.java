/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dcarlidev.fmo.financial.controllers;

import com.dcarlidev.fmo.financial.beans.Agent;
import com.dcarlidev.fmo.financial.services.AgentService;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

/**
 *
 * @author carlos
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class AgentControllerTest {

    @MockBean
    private AgentService agentService;
    @Autowired
    private MockMvc mockMvc;
    private final ObjectMapper mapper;

    public AgentControllerTest() {
        mapper = new ObjectMapper();
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
    public void testGetAllAgents() throws Exception {
        System.out.println("testGetAllAgents");
        List<Agent> listTemp = new ArrayList<>();
        listTemp.add(new Agent("TestName", "TestIdentification1"));
        listTemp.add(new Agent("TestName2", "TestIdentification2"));
        Mockito.when(agentService.getAllAgents()).thenReturn(listTemp);
        this.mockMvc.perform(MockMvcRequestBuilders.get("/agents"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$").isArray());
    }

    /**
     * Test of getAgentById method, of class AgentController.
     *
     * @throws java.lang.Exception
     */
    @Test
    public void testGetAgentById() throws Exception {
        System.out.println("testGetAgentById");
        Mockito.when(agentService.findById(1)).thenReturn(new Agent("TestName", "TestIdentification"));
        this.mockMvc.perform(MockMvcRequestBuilders.get("/agents/1"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("name").value("TestName"));
    }

    /**
     * Test of saveAgent method, of class AgentController.
     *
     * @throws java.lang.Exception
     */
    @Test
    public void testSaveAgent() throws Exception {
        System.out.println("testSaveAgent");
        Agent agent = new Agent("TestName", "TestIdentificationNumber");
        Mockito.when(agentService.saveAgent(agent)).thenReturn(agent);
        mockMvc.perform(MockMvcRequestBuilders.post("/agents")
                .content(mapper.writeValueAsString(agent))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("identificationNumber").value("TestIdentificationNumber"));
    }

    /**
     * Test of editAgent method, of class AgentController.
     *
     * @throws java.lang.Exception
     */
    @Test
    public void testEditAgent() throws Exception {
        System.out.println("testEditAgent");
        Agent agent = new Agent("TestName", "TestIdentification");
        Mockito.when(agentService.editAgent(agent, 1)).thenReturn(true);
        this.mockMvc.perform(MockMvcRequestBuilders.put("/agents/1")
                .content(mapper.writeValueAsString(agent))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    /**
     * Test of deleteAgent method, of class AgentController.
     * @throws java.lang.Exception
     */
    @Test
    public void testDeleteAgent() throws Exception {
        System.out.println("testDeleteAgent");
        Mockito.when(agentService.deleteAgent(1)).thenReturn(true);
        this.mockMvc.perform(MockMvcRequestBuilders.delete("/agents/1"))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

}

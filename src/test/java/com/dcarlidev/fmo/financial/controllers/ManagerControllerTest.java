/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dcarlidev.fmo.financial.controllers;

import com.dcarlidev.fmo.financial.beans.Manager;
import com.dcarlidev.fmo.financial.services.ManagerService;
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
@AutoConfigureMockMvc
@SpringBootTest
public class ManagerControllerTest {

    @MockBean
    private ManagerService managerService;
    @Autowired
    private MockMvc mockMvc;
    private final ObjectMapper mapper;

    public ManagerControllerTest() {
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
     * Test of getAllManagers method, of class ManagerController.
     * @throws java.lang.Exception
     */
    @Test
    public void testGetAllManagers() throws Exception {
        System.out.println("testGetAllManagers");
        List<Manager> listTemp = new ArrayList<>();
        listTemp.add(new Manager("TestName", "TestIdentification"));
        listTemp.add(new Manager("TestName1", "TestIdentification1"));
        Mockito.when(managerService.getAllManagers()).thenReturn(listTemp);
        mockMvc.perform(MockMvcRequestBuilders.get("/managers"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$").isArray());
    }

    /**
     * Test of getManagerById method, of class ManagerController.
     * @throws java.lang.Exception
     */
    @Test
    public void testGetManagerById() throws Exception {
        System.out.println("testGetManagerById");
        Mockito.when(managerService.findById(1)).thenReturn(new Manager("TestName", "TestIdentification"));
        this.mockMvc.perform(MockMvcRequestBuilders.get("/managers/1"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("identification").value("TestIdentification"));
    }

    /**
     * Test of saveManager method, of class ManagerController.
     * @throws java.lang.Exception
     */
    @Test
    public void testSaveManager() throws Exception {
        System.out.println("testSaveManager");
        Manager manager = new Manager("TestName", "TestIdentification");
        Mockito.when(managerService.saveManager(manager)).thenReturn(manager);
        mockMvc.perform(MockMvcRequestBuilders.post("/managers")
                .content(mapper.writeValueAsString(manager))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("name").value("TestName"));
    }

    /**
     * Test of editManager method, of class ManagerController.
     * @throws java.lang.Exception
     */
    @Test
    public void testEditManager() throws Exception {
        System.out.println("testEditManager");
        Manager manager = new Manager("TestName", "TestIdentification");
        Mockito.when(managerService.editManager(manager, 2)).thenReturn(true);
        this.mockMvc.perform(MockMvcRequestBuilders.put("/managers/2")
                .content(mapper.writeValueAsString(manager))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    /**
     * Test of deleteManager method, of class ManagerController.
     * @throws java.lang.Exception
     */
    @Test
    public void testDeleteManager() throws Exception {
        System.out.println("testDeleteManager");
        Mockito.when(managerService.deleteManager(1)).thenReturn(true);
        this.mockMvc.perform(MockMvcRequestBuilders.delete("/managers/1"))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

}

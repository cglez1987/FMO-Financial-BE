/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dcarlidev.fmo.financial.controllers;

import com.dcarlidev.fmo.financial.beans.InsuranceType;
import com.dcarlidev.fmo.financial.services.InsuranceTypeService;
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
public class InsuranceTypeControllerTest {

    private final ObjectMapper mapper;
    @MockBean
    private InsuranceTypeService insuranceTypeService;
    @Autowired
    private MockMvc mockMvc;

    public InsuranceTypeControllerTest() {
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
     * Test of getAllInsuranceTypes method, of class InsuranceTypeController.
     * @throws java.lang.Exception
     */
    @Test
    public void testGetAllInsuranceTypes() throws Exception {
        System.out.println("testGetAllInsuranceTypes");
        List<InsuranceType> listTemp = new ArrayList<>();
        listTemp.add(new InsuranceType("TestName", "TestDescription"));
        listTemp.add(new InsuranceType("TestName1", "TestDescription1"));
        Mockito.when(insuranceTypeService.getAllInsuranceTypes()).thenReturn(listTemp);
        this.mockMvc.perform(MockMvcRequestBuilders.get("/insuranceTypes"))
                .andExpect(MockMvcResultMatchers.status().isOk())
//                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.jsonPath("$").isArray());
    }

    /**
     * Test of getInsuranceTypeById method, of class InsuranceTypeController.
     * @throws java.lang.Exception
     */
    @Test
    public void testGetInsuranceTypeById() throws Exception {
        System.out.println("testGetInsuranceTypeById");
        Mockito.when(insuranceTypeService.findById(1)).thenReturn(new InsuranceType("TestName", "TestDescription"));
        this.mockMvc.perform(MockMvcRequestBuilders.get("/insuranceTypes/1"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("description").value("TestDescription"));
    }

    /**
     * Test of saveInsuranceType method, of class InsuranceTypeController.
     * @throws java.lang.Exception 
     */
    @Test
    public void testSaveInsuranceType() throws Exception {
        System.out.println("testSaveInsuranceType");
        InsuranceType insuranceType = new InsuranceType("TestName", "TestDescription");
        Mockito.when(insuranceTypeService.saveInsuranceType(insuranceType)).thenReturn(insuranceType);
        mockMvc.perform(MockMvcRequestBuilders.post("/insuranceTypes")
                .content(mapper.writeValueAsString(insuranceType))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("name").value("TestName"));
    }

    /**
     * Test of editInsuranceType method, of class InsuranceTypeController.
     * @throws java.lang.Exception
     */
    @Test
    public void testEditInsuranceType() throws Exception {
        System.out.println("testEditInsuranceType");
        InsuranceType insuranceType = new InsuranceType("TestName", "TestDescription");
        Mockito.when(insuranceTypeService.editInsuranceType(insuranceType, 2)).thenReturn(true);
        this.mockMvc.perform(MockMvcRequestBuilders.put("/insuranceTypes/2")
                .content(mapper.writeValueAsString(insuranceType))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    /**
     * Test of deleteInsuranceType method, of class InsuranceTypeController.
     * @throws java.lang.Exception
     */
    @Test
    public void testDeleteInsuranceType() throws Exception {
        System.out.println("testDeleteInsuranceType");
        Mockito.when(insuranceTypeService.deleteInsuranceType(1)).thenReturn(true);
        this.mockMvc.perform(MockMvcRequestBuilders.delete("/insuranceTypes/1"))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

}

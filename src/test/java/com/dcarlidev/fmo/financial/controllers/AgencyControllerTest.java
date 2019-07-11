/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dcarlidev.fmo.financial.controllers;

import com.dcarlidev.fmo.financial.beans.Agency;
import com.dcarlidev.fmo.financial.services.AgencyService;
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
//@WebMvcTest(controllers = AgencyController.class)
public class AgencyControllerTest {

    @MockBean
    private AgencyService agencyService;
    @Autowired
    private MockMvc mockMvc;
    private final ObjectMapper mapper;

    public AgencyControllerTest() {
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
     * Test of getAllAgencies method, of class AgencyController.
     *
     * @throws java.lang.Exception
     */
    @Test
    public void it_should_return_aListOfAgencies() throws Exception {
        System.out.println("should_return_aListOfAgencies");
        List<Agency> listTemp = new ArrayList<>();
        listTemp.add(new Agency("TestName", "TestAddress"));
        listTemp.add(new Agency("TestName1", "TestAddress1"));
        Mockito.when(agencyService.getAllAgencies()).thenReturn(listTemp);
        this.mockMvc.perform(MockMvcRequestBuilders.get("/agencies"))
                .andExpect(MockMvcResultMatchers.status().isOk())
//                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.jsonPath("$").isArray());
    }

    /**
     * Test of getAgencyById method, of class AgencyController.
     * @throws java.lang.Exception
     */
    @Test
    public void whenCallGetAgencyById_ifExists_thenReturnAgency() throws Exception {
        System.out.println("whenCallGetAgencyById_ifExists_thenReturnAgency");
        Mockito.when(agencyService.findById(1)).thenReturn(new Agency("TestName", "TestAddress"));
        this.mockMvc.perform(MockMvcRequestBuilders.get("/agencies/1"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("address").value("TestAddress"));
    }

    /**
     * Test of saveAgency method, of class AgencyController.
     *
     * @throws java.lang.Exception
     */
    @Test
    public void it_should_return_theSameAgency_whenSaveOneAgency() throws Exception {
        System.out.println("it_should_return_theSameAgency_whenSaveOneAgency");
        Agency agency = new Agency("TestName", "TestAddress");
        Mockito.when(agencyService.saveAgency(agency)).thenReturn(agency);
        mockMvc.perform(MockMvcRequestBuilders.post("/agencies")
                .content(mapper.writeValueAsString(agency))
                .contentType(MediaType.APPLICATION_JSON))
//                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("name").value("TestName"));
    }

    /**
     * Test of editAgency method, of class AgencyController.
     *
     * @throws java.lang.Exception
     */
    @Test
    public void whenCallEditAgencyCorrectly_thenReturn_ResponseOk() throws Exception {
        System.out.println("whenCallEditAgencyCorrectly_thenReturn_ResponseOk");
        Agency agency = new Agency("TestName", "TestAddress");
        Mockito.when(agencyService.editAgency(agency, 2)).thenReturn(true);
        this.mockMvc.perform(MockMvcRequestBuilders.put("/agencies/2")
                .content(mapper.writeValueAsString(agency))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    /**
     * Test of deleteAgency method, of class AgencyController.
     * @throws java.lang.Exception
     */
    @Test
    public void it_should_delete_agency_ifExistId() throws Exception {
        System.out.println("it_should_delete_agency_ifExistId");
        Mockito.when(agencyService.deleteAgency(1)).thenReturn(true);
        this.mockMvc.perform(MockMvcRequestBuilders.delete("/agencies/1"))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dcarlidev.fmo.financial.controllers;

import com.dcarlidev.fmo.financial.beans.Payment;
import com.dcarlidev.fmo.financial.services.PaymentService;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
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
public class PaymentControllerTest {

    private final ObjectMapper mapper;
    @MockBean
    private PaymentService paymentService;
    @Autowired
    private MockMvc mockMvc;

    public PaymentControllerTest() {
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
     * Test of getAllPayments method, of class PaymentController.
     * @throws java.lang.Exception
     */
    @Test
    public void testGetAllPayments() throws Exception {
        System.out.println("testGetAllPayments");
        List<Payment> listTemp = new ArrayList<>();
        listTemp.add(new Payment());
        listTemp.add(new Payment());
        Mockito.when(paymentService.getAllPayments()).thenReturn(listTemp);
        this.mockMvc.perform(MockMvcRequestBuilders.get("/payments"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$").isArray());
    }

    /**
     * Test of getPaymentById method, of class PaymentController.
     * @throws java.lang.Exception
     */
    @Test
    public void testGetPaymentById() throws Exception {
        System.out.println("testGetPaymentById");
        Mockito.when(paymentService.findById(1)).thenReturn(new Payment(java.sql.Date.valueOf(LocalDate.now()), java.sql.Date.valueOf(LocalDate.now())));
        this.mockMvc.perform(MockMvcRequestBuilders.get("/payments/1"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("periodEnding").value(java.sql.Date.valueOf(LocalDate.now())));
    }

    /**
     * Test of savePayment method, of class PaymentController.
     * @throws java.lang.Exception
     */
    @Test
    public void testSavePayment() throws Exception {
        System.out.println("testSavePayment");
        Payment payment = new Payment(new Date(16052019), new Date(16052019));
        Mockito.when(paymentService.savePayment(payment)).thenReturn(payment);
        mockMvc.perform(MockMvcRequestBuilders.post("/payments")
                .content(mapper.writeValueAsString(payment))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("dateReceived").value(new Date(16052019)));
    }

    /**
     * Test of editPayment method, of class PaymentController.
     * @throws java.lang.Exception
     */
    @Test
    public void testEditPayment() throws Exception {
        System.out.println("testEditPayment");
        Payment payment = new Payment(new Date(16052019), new Date(16052019));
        Mockito.when(paymentService.editPayment(payment, 2)).thenReturn(true);
        this.mockMvc.perform(MockMvcRequestBuilders.put("/payments/2")
                .content(mapper.writeValueAsString(payment))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    /**
     * Test of deletePayment method, of class PaymentController.
     * @throws java.lang.Exception
     */
    @Test
    public void testDeletePayment() throws Exception {
        System.out.println("testDeletePayment");
        Mockito.when(paymentService.deletePayment(1)).thenReturn(true);
        this.mockMvc.perform(MockMvcRequestBuilders.delete("/payments/1"))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

}

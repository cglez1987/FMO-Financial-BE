/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.dcarlidev.fmo.financial.controllers;

import com.dcarlidev.fmo.financial.beans.Payment;
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
public class PaymentControllerTest {

    public PaymentControllerTest() {
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
     */
    @Test
    public void testGetAllPayments() {
        System.out.println("getAllPayments");
        PaymentController instance = new PaymentController();
        ResponseEntity<List<Payment>> expResult = null;
        ResponseEntity<List<Payment>> result = instance.getAllPayments();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPaymentById method, of class PaymentController.
     */
    @Test
    public void testGetPaymentById() {
        System.out.println("getPaymentById");
        int id = 0;
        PaymentController instance = new PaymentController();
        ResponseEntity<Payment> expResult = null;
        ResponseEntity<Payment> result = instance.getPaymentById(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of savePayment method, of class PaymentController.
     */
    @Test
    public void testSavePayment() {
        System.out.println("savePayment");
        Payment payment = null;
        PaymentController instance = new PaymentController();
        ResponseEntity<Payment> expResult = null;
        ResponseEntity<Payment> result = instance.savePayment(payment);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of editPayment method, of class PaymentController.
     */
    @Test
    public void testEditPayment() {
        System.out.println("editPayment");
        Payment payment = null;
        int id = 0;
        PaymentController instance = new PaymentController();
        ResponseEntity expResult = null;
        ResponseEntity result = instance.editPayment(payment, id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of deletePayment method, of class PaymentController.
     */
    @Test
    public void testDeletePayment() {
        System.out.println("deletePayment");
        int id = 0;
        PaymentController instance = new PaymentController();
        ResponseEntity expResult = null;
        ResponseEntity result = instance.deletePayment(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

}
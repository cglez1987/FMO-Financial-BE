/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.dcarlidev.fmo.financial.controllers;

import com.dcarlidev.fmo.financial.beans.InsuranceType;
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
public class InsuranceTypeControllerTest {

    public InsuranceTypeControllerTest() {
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
     */
    @Test
    public void testGetAllInsuranceTypes() {
        System.out.println("getAllInsuranceTypes");
        InsuranceTypeController instance = new InsuranceTypeController();
        ResponseEntity<List<InsuranceType>> expResult = null;
        ResponseEntity<List<InsuranceType>> result = instance.getAllInsuranceTypes();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getInsuranceTypeById method, of class InsuranceTypeController.
     */
    @Test
    public void testGetInsuranceTypeById() {
        System.out.println("getInsuranceTypeById");
        int id = 0;
        InsuranceTypeController instance = new InsuranceTypeController();
        ResponseEntity<InsuranceType> expResult = null;
        ResponseEntity<InsuranceType> result = instance.getInsuranceTypeById(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of saveInsuranceType method, of class InsuranceTypeController.
     */
    @Test
    public void testSaveInsuranceType() {
        System.out.println("saveInsuranceType");
        InsuranceType insuranceType = null;
        InsuranceTypeController instance = new InsuranceTypeController();
        ResponseEntity<InsuranceType> expResult = null;
        ResponseEntity<InsuranceType> result = instance.saveInsuranceType(insuranceType);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of editInsuranceType method, of class InsuranceTypeController.
     */
    @Test
    public void testEditInsuranceType() {
        System.out.println("editInsuranceType");
        InsuranceType insuranceType = null;
        int id = 0;
        InsuranceTypeController instance = new InsuranceTypeController();
        ResponseEntity expResult = null;
        ResponseEntity result = instance.editInsuranceType(insuranceType, id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of deleteInsuranceType method, of class InsuranceTypeController.
     */
    @Test
    public void testDeleteInsuranceType() {
        System.out.println("deleteInsuranceType");
        int id = 0;
        InsuranceTypeController instance = new InsuranceTypeController();
        ResponseEntity expResult = null;
        ResponseEntity result = instance.deleteInsuranceType(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

}
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.dcarlidev.fmo.financial.controllers;

import com.dcarlidev.fmo.financial.beans.Manager;
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
public class ManagerControllerTest {

    public ManagerControllerTest() {
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
     */
    @Test
    public void testGetAllManagers() {
        System.out.println("getAllManagers");
        ManagerController instance = new ManagerController();
        ResponseEntity<List<Manager>> expResult = null;
        ResponseEntity<List<Manager>> result = instance.getAllManagers();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getManagerById method, of class ManagerController.
     */
    @Test
    public void testGetManagerById() {
        System.out.println("getManagerById");
        int id = 0;
        ManagerController instance = new ManagerController();
        ResponseEntity<Manager> expResult = null;
        ResponseEntity<Manager> result = instance.getManagerById(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of saveManager method, of class ManagerController.
     */
    @Test
    public void testSaveManager() {
        System.out.println("saveManager");
        Manager manager = null;
        ManagerController instance = new ManagerController();
        ResponseEntity<Manager> expResult = null;
        ResponseEntity<Manager> result = instance.saveManager(manager);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of editManager method, of class ManagerController.
     */
    @Test
    public void testEditManager() {
        System.out.println("editManager");
        Manager manager = null;
        int id = 0;
        ManagerController instance = new ManagerController();
        ResponseEntity expResult = null;
        ResponseEntity result = instance.editManager(manager, id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of deleteManager method, of class ManagerController.
     */
    @Test
    public void testDeleteManager() {
        System.out.println("deleteManager");
        int id = 0;
        ManagerController instance = new ManagerController();
        ResponseEntity expResult = null;
        ResponseEntity result = instance.deleteManager(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

}
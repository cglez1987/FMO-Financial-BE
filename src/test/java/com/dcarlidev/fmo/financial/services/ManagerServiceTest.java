/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dcarlidev.fmo.financial.services;

import com.dcarlidev.fmo.financial.beans.Manager;
import com.dcarlidev.fmo.financial.repositories.ManagerRepository;
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
public class ManagerServiceTest {

    @Mock
    private ManagerRepository repo;
    @InjectMocks
    private ManagerService managerService;

    public ManagerServiceTest() {
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
     * Test of saveManager method, of class ManagerService.
     */
    @Test
    public void whenCallSaveManagerCorrectly_thenReturnSameManager() {
        System.out.println("whenCallSaveManagerCorrectly_thenReturnSameManager");
        Manager manager = new Manager("TestName", "TestIdentification");
        Mockito.when(repo.save(any(Manager.class))).thenReturn(manager);
        Manager result = managerService.saveManager(manager);
        assertEquals(manager, result);
    }

    /**
     * Test of getAllManagers method, of class ManagerService.
     */
    @Test
    public void whenCallGetAllManagersWithData_thenReturnListAllManagers() {
        System.out.println("whenCallGetAllManagersWithData_thenReturnListAllManagers");
        List<Manager> expResult = new ArrayList<>();
        expResult.add(new Manager("Test1", "Identification1"));
        expResult.add(new Manager("Test2", "Identification2"));
        Mockito.when(repo.findAll()).thenReturn(expResult);
        List<Manager> result = managerService.getAllManagers();
        Assert.assertTrue(result.size() == 2);
    }

    /**
     * Test of findById method, of class ManagerService.
     */
    @Test
    public void whenFindById_ExistId_thenReturnManager() {
        System.out.println("whenFindById_ExistId_thenReturnManager");
        Manager expResult = new Manager("TestName", "TestIdentification");
        Mockito.when(repo.findById(2)).thenReturn(Optional.of(new Manager("TestName", "TestIdentification")));
        Manager result = managerService.findById(2);
        assertEquals(expResult, result);
    }

    /**
     * Test of editManager method, of class ManagerService.
     */
    @Test
    public void whenEditCorrectlyManager_thenReturnTrue() {
        System.out.println("whenEditCorrectlyManager_thenReturnTrue");
        boolean expResult = true;
        Manager manager = new Manager("TestName", "TestIdentification");
        Mockito.when(repo.existsById(2)).thenReturn(true);
        boolean result = managerService.editManager(manager, 2);
        assertEquals(expResult, result);
    }

    /**
     * Test of editManager method, of class ManagerService.
     */
    @Test
    public void whenCallEditManager_NotFoundManager_thenReturnFalse() {
        System.out.println("whenCallEditManager_NotFoundManager_thenReturnFalse");
        Manager manager = new Manager("TestName", "TestIdentification");
        Mockito.when(repo.existsById(2)).thenReturn(false);
        boolean result = managerService.editManager(manager, 2);
        Assert.assertFalse(result);
    }

    /**
     * Test of deleteManager method, of class ManagerService.
     */
    @Test
    public void whenDeleteManagerCorrectly_thenReturnTrue() {
        System.out.println("whenDeleteManagerCorrectly_thenReturnTrue");
        boolean expResult = true;
        Mockito.when(repo.existsById(2)).thenReturn(true);
        boolean result = managerService.deleteManager(2);
        assertEquals(expResult, result);
    }

}

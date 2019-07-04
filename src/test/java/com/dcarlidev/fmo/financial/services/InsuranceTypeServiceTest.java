/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dcarlidev.fmo.financial.services;

import com.dcarlidev.fmo.financial.beans.InsuranceType;
import com.dcarlidev.fmo.financial.repositories.InsuranceTypeRepository;
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
public class InsuranceTypeServiceTest {

    @Mock
    private InsuranceTypeRepository repo;
    @InjectMocks
    private InsuranceTypeService insuranceTypeService;

    public InsuranceTypeServiceTest() {
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
     * Test of saveInsuranceType method, of class InsuranceTypeService.
     */
    @Test
    public void whenCallSaveInsuranceTypeCorrectly_thenReturnSameInsuranceType() {
        System.out.println("whenCallSaveInsuranceTypeCorrectly_thenReturnSameInsuranceType");
        InsuranceType insuranceType = new InsuranceType("TestName", "TestDescription");
        Mockito.when(repo.save(any(InsuranceType.class))).thenReturn(insuranceType);
        InsuranceType result = insuranceTypeService.saveInsuranceType(insuranceType);
        assertEquals(insuranceType, result);
    }

    /**
     * Test of getAllInsuranceTypes method, of class InsuranceTypeService.
     */
    @Test
    public void whenCallGetAllInsuranceTypesWithData_thenReturnListAllInsuranceTypes() {
        System.out.println("whenCallGetAllInsuranceTypesWithData_thenReturnListAllInsuranceTypes");
        List<InsuranceType> expResult = new ArrayList<>();
        expResult.add(new InsuranceType("Test1", "Description1"));
        expResult.add(new InsuranceType("Test2", "Description2"));
        Mockito.when(repo.findAll()).thenReturn(expResult);
        List<InsuranceType> result = insuranceTypeService.getAllInsuranceTypes();
        Assert.assertTrue(result.size() == 2);
    }

    /**
     * Test of findById method, of class InsuranceTypeService.
     */
    @Test
    public void whenFindById_ExistId_thenReturnInsuranceType() {
        System.out.println("whenFindById_ExistId_thenReturnInsuranceType");
        InsuranceType expResult = new InsuranceType("TestName", "TestDescription");
        Mockito.when(repo.findById(2)).thenReturn(Optional.of(new InsuranceType("TestName", "TestDescription")));
        InsuranceType result = insuranceTypeService.findById(2);
        assertEquals(expResult, result);
    }

    /**
     * Test of editInsuranceType method, of class InsuranceTypeService.
     */
    @Test
    public void whenEditCorrectlyInsuranceType_thenReturnTrue() {
        System.out.println("whenEditCorrectlyInsuranceType_thenReturnTrue");
        boolean expResult = true;
        InsuranceType insuranceType = new InsuranceType("TestName", "TestDescription");
        Mockito.when(repo.existsById(2)).thenReturn(true);
        boolean result = insuranceTypeService.editInsuranceType(insuranceType, 2);
        assertEquals(expResult, result);
    }

    /**
     * Test of editInsuranceType method, of class InsuranceTypeService.
     */
    @Test
    public void whenCallEditInsuranceType_NotFoundInsuranceType_thenReturnFalse() {
        System.out.println("whenCallEditInsuranceType_NotFoundInsuranceType_thenReturnFalse");
        InsuranceType insuranceType = new InsuranceType("TestName", "TestIdentification");
        Mockito.when(repo.existsById(2)).thenReturn(false);
        boolean result = insuranceTypeService.editInsuranceType(insuranceType, 2);
        Assert.assertFalse(result);
    }

    /**
     * Test of deleteInsuranceType method, of class InsuranceTypeService.
     */
    @Test
    public void whenDeleteInsuranceTypeCorrectly_thenReturnTrue() {
        System.out.println("whenDeleteInsuranceTypeCorrectly_thenReturnTrue");
        boolean expResult = true;
        Mockito.when(repo.existsById(2)).thenReturn(true);
        boolean result = insuranceTypeService.deleteInsuranceType(2);
        assertEquals(expResult, result);
    }

}

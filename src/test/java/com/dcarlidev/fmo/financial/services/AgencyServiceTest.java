/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dcarlidev.fmo.financial.services;

import com.dcarlidev.fmo.financial.beans.Agency;
import com.dcarlidev.fmo.financial.repositories.AgencyRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
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
public class AgencyServiceTest {

    @Mock
    private AgencyRepository repo;
    @InjectMocks
    private AgencyService instance;

    public AgencyServiceTest() {

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
     * Test of saveAgency method, of class AgencyService.
     */
    @Test
    public void whensaveAgencyCorrectly_thenReturnSameAgency() {
        System.out.println("whensaveAgencyCorrectly_thenReturnSameAgency");
        Agency agency = new Agency("TestName", "TestAddress");
        Mockito.when(repo.save(any(Agency.class))).thenReturn(agency);
        Agency result = instance.saveAgency(agency);
        assertEquals(agency, result);
    }

    /**
     * Test of getAllAgencies method, of class AgencyService.
     */
    @Test
    public void whenCallGetAllAgenciesWithData_thenReturnListAllAgencies() {
        System.out.println("whenCallGetAllAgenciesWithData_thenReturnListAllAgencies");
        List<Agency> expResult = new ArrayList<>();
        expResult.add(new Agency("Test1", "DescriptionTest1"));
        expResult.add(new Agency("Test2", "DescriptionTest2"));
        Mockito.when(repo.findAll()).thenReturn(expResult);
        List<Agency> result = instance.getAllAgencies();
        Assert.assertTrue(result.size() == 2);
    }

    /**
     * Test of findById method, of class AgencyService.
     */
    @Test
    public void whenFindById_thenReturnAgency() {
        System.out.println("whenFindById_thenReturnAgency");
        Agency expResult = new Agency("TestName", "TestAddress");
        Mockito.when(repo.findById(1)).thenReturn(Optional.of(new Agency("TestName", "TestAddress")));
        Agency result = instance.findById(1);
        assertEquals(expResult, result);
    }

    /**
     * Test of editAgency method, of class AgencyService.
     */
    @Test
    public void whenEditCorrectlyAgency_thenReturnTrue() {
        System.out.println("whenEditCorrectlyAgency_thenReturnTrue");
        boolean expResult = true;
        Agency agency = new Agency("TestName", "TestAddress");
        Mockito.when(repo.findById(1)).thenReturn(Optional.of(new Agency("TestName", "TestAddress")));
        boolean result = instance.editAgency(agency, 1);
        assertEquals(expResult, result);
    }

    /**
     * Test of editAgency method, of class AgencyService.
     */
    @Test
    public void whenCallEditAgency_NotFoundAgency_thenReturnFalse() {
        System.out.println("whenCallEditAgency_NotFoundAgency_thenReturnFalse");
        Agency agency = new Agency("TestName", "TestAddress");
        Mockito.when(repo.findById(1)).thenReturn(Optional.empty());
        boolean result = instance.editAgency(agency, 1);
        Assert.assertFalse(result);
    }

    /**
     * Test of deleteAgency method, of class AgencyService.
     */
    @Test
    public void whenDeleteAgencyCorrectly_thenReturnTrue() {
        System.out.println("deleteAgencyTest");
        boolean expResult = true;
        Mockito.when(repo.existsById(1)).thenReturn(true);
        boolean result = instance.deleteAgency(1);
        assertEquals(expResult, result);
    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dcarlidev.fmo.financial.services;

import com.dcarlidev.fmo.financial.beans.Payment;
import com.dcarlidev.fmo.financial.beans.PaymentDetail;
import com.dcarlidev.fmo.financial.repositories.PaymentRepository;
import java.util.ArrayList;
import java.util.Date;
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
public class PaymentServiceTest {

    @Mock
    private PaymentRepository repo;
    @InjectMocks
    private PaymentService paymentService;

    public PaymentServiceTest() {
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
     * Test of savePayment method, of class PaymentService.
     */
    @Test
    public void whenCallSavePaymentCorrectly_thenReturnSamePayment() {
        System.out.println("whenCallSavePaymentCorrectly_thenReturnSamePayment");
        Payment payment = new Payment(new Date(19871213), new Date(19871213));
        payment.setPaymentDetail(new PaymentDetail());
        Mockito.when(repo.save(any(Payment.class))).thenReturn(payment);
        Payment result = paymentService.savePayment(payment);
        assertEquals(payment, result);
    }

    /**
     * Test of getAllPayments method, of class PaymentService.
     */
    @Test
    public void whenCallGetAllPaymentsWithData_thenReturnListAllPayments() {
        System.out.println("whenCallGetAllPaymentsWithData_thenReturnListAllPayments");
        List<Payment> expResult = new ArrayList<>();
        expResult.add(new Payment(new Date(19871214), new Date(19871213)));
        expResult.add(new Payment(new Date(), new Date()));
        Mockito.when(repo.findAll()).thenReturn(expResult);
        List<Payment> result = paymentService.getAllPayments();
        Assert.assertTrue(result.size() == 2);
    }

    /**
     * Test of findById method, of class PaymentService.
     */
    @Test
    public void whenFindById_ExistId_thenReturnPayment() {
        System.out.println("whenFindById_ExistId_thenReturnPayment");
        Payment expResult = new Payment(new Date(19871213), new Date(19871213));
        expResult.setPaymentDetail(new PaymentDetail());
        Mockito.when(repo.findById(2)).thenReturn(Optional.of(expResult));
        Payment result = paymentService.findById(2);
        assertEquals(expResult, result);
    }

    /**
     * Test of editPayment method, of class PaymentService.
     */
    @Test
    public void whenEditCorrectlyPayment_thenReturnTrue() {
        System.out.println("whenEditCorrectlyPayment_thenReturnTrue");
        boolean expResult = true;
        Payment payment = new Payment(new Date(19871213), new Date(19871213));
        Mockito.when(repo.existsById(2)).thenReturn(true);
        boolean result = paymentService.editPayment(payment, 2);
        assertEquals(expResult, result);
    }

    /**
     * Test of editPayment method, of class PaymentService.
     */
    @Test
    public void whenCallEditPayment_NotFoundPayment_thenReturnFalse() {
        System.out.println("whenCallEditPayment_NotFoundPayment_thenReturnFalse");
        Payment payment = new Payment(new Date(19871213), new Date(19871213));
        Mockito.when(repo.existsById(2)).thenReturn(false);
        boolean result = paymentService.editPayment(payment, 2);
        Assert.assertFalse(result);
    }
    /**
     * Test of deletePayment method, of class PaymentService.
     */
    @Test
    public void whenDeletePaymentCorrectly_thenReturnTrue() {
        System.out.println("whenDeletePaymentCorrectly_thenReturnTrue");
        boolean expResult = true;
        Mockito.when(repo.existsById(2)).thenReturn(true);
        boolean result = paymentService.deletePayment(2);
        assertEquals(expResult, result);
    }

}

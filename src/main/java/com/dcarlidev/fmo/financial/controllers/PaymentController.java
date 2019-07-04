/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dcarlidev.fmo.financial.controllers;

import com.dcarlidev.fmo.financial.beans.Payment;
import com.dcarlidev.fmo.financial.services.PaymentService;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author carlos
 */
@RestController
@RequestMapping(path = "/payments")
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<Payment>> getAllPayments() {
        List<Payment> listPayments = this.paymentService.getAllPayments();
        return new ResponseEntity(listPayments, HttpStatus.OK);
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Payment> getPaymentById(@PathVariable int id) {
        ResponseEntity response;
        Payment a = this.paymentService.findById(id);
        if (a == null) {
            response = new ResponseEntity(HttpStatus.NOT_FOUND);
        } else {
            response = new ResponseEntity(a, HttpStatus.OK);
        }
        return response;
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.POST)
    public ResponseEntity<Payment> savePayment(@Valid @RequestBody Payment payment) {
        Payment a = this.paymentService.savePayment(payment);
        return new ResponseEntity(a, HttpStatus.OK);
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity editPayment(@Valid
            @RequestBody Payment payment, @PathVariable int id) {
        ResponseEntity response;
        if (this.paymentService.editPayment(payment, id)) {
            response = new ResponseEntity(HttpStatus.OK);
        } else {
            response = new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return response;
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity deletePayment(@PathVariable int id) {
        ResponseEntity response;
        if (this.paymentService.deletePayment(id)) {
            response = new ResponseEntity(HttpStatus.OK);
        } else {
            response = new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return response;
    }

}

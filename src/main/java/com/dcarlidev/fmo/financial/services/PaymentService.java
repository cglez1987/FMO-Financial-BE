/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dcarlidev.fmo.financial.services;

import com.dcarlidev.fmo.financial.beans.Payment;
import com.dcarlidev.fmo.financial.repositories.PaymentRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author carlos
 */
@Service
public class PaymentService {

    @Autowired
    private PaymentRepository paymentRepo;

    public Payment savePayment(Payment payment) {
        return this.paymentRepo.save(payment);
    }

    public List<Payment> getAllPayments() {
        List<Payment> payments = new ArrayList<>();
        this.paymentRepo.findAll().forEach(e -> payments.add(e));
        return payments;
    }

    public Payment findById(int id) {
        Optional<Payment> payment = this.paymentRepo.findById(id);
        if (payment.isPresent()) {
            return payment.get();
        } else {
            return null;
        }
    }

    public boolean editPayment(Payment payment, int id) {
        if (paymentRepo.existsById(id)) {
            payment.setId(id);
            this.paymentRepo.save(payment);
            return true;
        } else {
            return false;
        }
    }

    public boolean deletePayment(int id) {
        if (this.paymentRepo.existsById(id)) {
            this.paymentRepo.deleteById(id);
            return true;
        } else {
            return false;
        }
    }

}

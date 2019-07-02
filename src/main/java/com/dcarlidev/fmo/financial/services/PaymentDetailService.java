/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dcarlidev.fmo.financial.services;

import com.dcarlidev.fmo.financial.beans.PaymentDetail;
import com.dcarlidev.fmo.financial.repositories.PaymentDetailRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author lisbet
 */
@Service
public class PaymentDetailService {

    @Autowired
    private PaymentDetailRepository paymentDetailRepo;

    public PaymentDetail savePaymentDetail(PaymentDetail paymentDetail) {
        return this.paymentDetailRepo.save(paymentDetail);
    }

    public List<PaymentDetail> getAllAgencies() {
        List<PaymentDetail> payments = new ArrayList<>();
        this.paymentDetailRepo.findAll().forEach(e -> payments.add(e));
        return payments;
    }

    public PaymentDetail findById(int id) {
        Optional<PaymentDetail> payment = this.paymentDetailRepo.findById(id);
        if (payment.isPresent()) {
            return payment.get();
        } else {
            return null;
        }
    }

    public boolean editPaymentDetail(PaymentDetail paymentDetail, int id) {
        Optional<PaymentDetail> temp = this.paymentDetailRepo.findById(id);
        if (temp.isPresent()) {
            PaymentDetail a = temp.get();
            a.setId(id);
            this.paymentDetailRepo.save(a);
            return true;
        } else {
            return false;
        }
    }

    public boolean deletePaymentDetail(int id) {
        if (this.paymentDetailRepo.existsById(id)) {
            this.paymentDetailRepo.deleteById(id);
            return true;
        } else {
            return false;
        }
    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dcarlidev.fmo.financial.beans;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

/**
 *
 * @author lisbet
 */
@Entity
@Table(name = "Payment")
public class Payment implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "periodEnding")
    @Temporal(TemporalType.DATE)
    private Date periodEnding;
    @Basic(optional = false)
    @NotNull
    @Column(name = "dateReceived")
    @Temporal(TemporalType.DATE)
    private Date dateReceived;
    @JoinColumn(name = "paymentDetailId", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private PaymentDetail paymentDetailId;

    public Payment() {
    }

    public Payment(Integer id) {
        this.id = id;
    }

    public Payment(Integer id, Date periodEnding, Date dateReceived) {
        this.id = id;
        this.periodEnding = periodEnding;
        this.dateReceived = dateReceived;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getPeriodEnding() {
        return periodEnding;
    }

    public void setPeriodEnding(Date periodEnding) {
        this.periodEnding = periodEnding;
    }

    public Date getDateReceived() {
        return dateReceived;
    }

    public void setDateReceived(Date dateReceived) {
        this.dateReceived = dateReceived;
    }

    public PaymentDetail getPaymentDetailId() {
        return paymentDetailId;
    }

    public void setPaymentDetailId(PaymentDetail paymentDetailId) {
        this.paymentDetailId = paymentDetailId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Payment)) {
            return false;
        }
        Payment other = (Payment) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.dcarlidev.fmo.financial.beans.Payment[ id=" + id + " ]";
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dcarlidev.fmo.financial.beans;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author lisbet
 */
@Entity
@Table(name = "PaymentDetail")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PaymentDetail.findAll", query = "SELECT p FROM PaymentDetail p"),
    @NamedQuery(name = "PaymentDetail.findById", query = "SELECT p FROM PaymentDetail p WHERE p.id = :id"),
    @NamedQuery(name = "PaymentDetail.findByTrackingCode", query = "SELECT p FROM PaymentDetail p WHERE p.trackingCode = :trackingCode"),
    @NamedQuery(name = "PaymentDetail.findByProducerTin", query = "SELECT p FROM PaymentDetail p WHERE p.producerTin = :producerTin"),
    @NamedQuery(name = "PaymentDetail.findByProducerName", query = "SELECT p FROM PaymentDetail p WHERE p.producerName = :producerName"),
    @NamedQuery(name = "PaymentDetail.findByState", query = "SELECT p FROM PaymentDetail p WHERE p.state = :state"),
    @NamedQuery(name = "PaymentDetail.findByType", query = "SELECT p FROM PaymentDetail p WHERE p.type = :type"),
    @NamedQuery(name = "PaymentDetail.findByPolicyNumber", query = "SELECT p FROM PaymentDetail p WHERE p.policyNumber = :policyNumber"),
    @NamedQuery(name = "PaymentDetail.findByProductType", query = "SELECT p FROM PaymentDetail p WHERE p.productType = :productType"),
    @NamedQuery(name = "PaymentDetail.findByCo", query = "SELECT p FROM PaymentDetail p WHERE p.co = :co"),
    @NamedQuery(name = "PaymentDetail.findByGroupName", query = "SELECT p FROM PaymentDetail p WHERE p.groupName = :groupName"),
    @NamedQuery(name = "PaymentDetail.findByComEffDate", query = "SELECT p FROM PaymentDetail p WHERE p.comEffDate = :comEffDate"),
    @NamedQuery(name = "PaymentDetail.findByTierLevel", query = "SELECT p FROM PaymentDetail p WHERE p.tierLevel = :tierLevel"),
    @NamedQuery(name = "PaymentDetail.findByAorChange", query = "SELECT p FROM PaymentDetail p WHERE p.aorChange = :aorChange"),
    @NamedQuery(name = "PaymentDetail.findByCommType", query = "SELECT p FROM PaymentDetail p WHERE p.commType = :commType"),
    @NamedQuery(name = "PaymentDetail.findByOi", query = "SELECT p FROM PaymentDetail p WHERE p.oi = :oi"),
    @NamedQuery(name = "PaymentDetail.findBySplitAmt", query = "SELECT p FROM PaymentDetail p WHERE p.splitAmt = :splitAmt"),
    @NamedQuery(name = "PaymentDetail.findByDueDate", query = "SELECT p FROM PaymentDetail p WHERE p.dueDate = :dueDate"),
    @NamedQuery(name = "PaymentDetail.findByNoMos", query = "SELECT p FROM PaymentDetail p WHERE p.noMos = :noMos"),
    @NamedQuery(name = "PaymentDetail.findByMbrCnt", query = "SELECT p FROM PaymentDetail p WHERE p.mbrCnt = :mbrCnt"),
    @NamedQuery(name = "PaymentDetail.findByIntPrm", query = "SELECT p FROM PaymentDetail p WHERE p.intPrm = :intPrm"),
    @NamedQuery(name = "PaymentDetail.findByAdvBal", query = "SELECT p FROM PaymentDetail p WHERE p.advBal = :advBal"),
    @NamedQuery(name = "PaymentDetail.findByPremiumReceived", query = "SELECT p FROM PaymentDetail p WHERE p.premiumReceived = :premiumReceived"),
    @NamedQuery(name = "PaymentDetail.findByStlToDtPremium", query = "SELECT p FROM PaymentDetail p WHERE p.stlToDtPremium = :stlToDtPremium"),
    @NamedQuery(name = "PaymentDetail.findByStlToDtCommission", query = "SELECT p FROM PaymentDetail p WHERE p.stlToDtCommission = :stlToDtCommission"),
    @NamedQuery(name = "PaymentDetail.findByCurrentCommission", query = "SELECT p FROM PaymentDetail p WHERE p.currentCommission = :currentCommission"),
    @NamedQuery(name = "PaymentDetail.findByComments", query = "SELECT p FROM PaymentDetail p WHERE p.comments = :comments"),
    @NamedQuery(name = "PaymentDetail.findByTotalCommissionByType", query = "SELECT p FROM PaymentDetail p WHERE p.totalCommissionByType = :totalCommissionByType"),
    @NamedQuery(name = "PaymentDetail.findByTotalCommissionByProducer", query = "SELECT p FROM PaymentDetail p WHERE p.totalCommissionByProducer = :totalCommissionByProducer"),
    @NamedQuery(name = "PaymentDetail.findByPaymentId", query = "SELECT p FROM PaymentDetail p WHERE p.paymentId = :paymentId")})
public class PaymentDetail implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "trackingCode")
    private String trackingCode;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "producerTin")
    private String producerTin;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "producerName")
    private String producerName;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "state")
    private String state;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "type")
    private String type;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "policyNumber")
    private String policyNumber;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "productType")
    private String productType;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "co")
    private String co;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "groupName")
    private String groupName;
    @Basic(optional = false)
    @NotNull
    @Column(name = "comEffDate")
    @Temporal(TemporalType.DATE)
    private Date comEffDate;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "tierLevel")
    private String tierLevel;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "aorChange")
    private String aorChange;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "commType")
    private String commType;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "oi")
    private String oi;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "splitAmt")
    private String splitAmt;
    @Basic(optional = false)
    @NotNull
    @Column(name = "dueDate")
    @Temporal(TemporalType.DATE)
    private Date dueDate;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "noMos")
    private String noMos;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "MbrCnt")
    private String mbrCnt;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "intPrm")
    private String intPrm;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "advBal")
    private String advBal;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "premiumReceived")
    private String premiumReceived;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "stlToDtPremium")
    private String stlToDtPremium;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "stlToDtCommission")
    private String stlToDtCommission;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "currentCommission")
    private String currentCommission;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "comments")
    private String comments;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "totalCommissionByType")
    private String totalCommissionByType;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "totalCommissionByProducer")
    private String totalCommissionByProducer;
    @Basic(optional = false)
    @NotNull
    @Column(name = "paymentId")
    private int paymentId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "paymentDetailId", fetch = FetchType.LAZY)
    private Collection<Payment> paymentCollection;

    public PaymentDetail() {
    }

    public PaymentDetail(Integer id) {
        this.id = id;
    }

    public PaymentDetail(Integer id, String trackingCode, String producerTin, String producerName, String state, String type, String policyNumber, String productType, String co, String groupName, Date comEffDate, String tierLevel, String aorChange, String commType, String oi, String splitAmt, Date dueDate, String noMos, String mbrCnt, String intPrm, String advBal, String premiumReceived, String stlToDtPremium, String stlToDtCommission, String currentCommission, String comments, String totalCommissionByType, String totalCommissionByProducer, int paymentId) {
        this.id = id;
        this.trackingCode = trackingCode;
        this.producerTin = producerTin;
        this.producerName = producerName;
        this.state = state;
        this.type = type;
        this.policyNumber = policyNumber;
        this.productType = productType;
        this.co = co;
        this.groupName = groupName;
        this.comEffDate = comEffDate;
        this.tierLevel = tierLevel;
        this.aorChange = aorChange;
        this.commType = commType;
        this.oi = oi;
        this.splitAmt = splitAmt;
        this.dueDate = dueDate;
        this.noMos = noMos;
        this.mbrCnt = mbrCnt;
        this.intPrm = intPrm;
        this.advBal = advBal;
        this.premiumReceived = premiumReceived;
        this.stlToDtPremium = stlToDtPremium;
        this.stlToDtCommission = stlToDtCommission;
        this.currentCommission = currentCommission;
        this.comments = comments;
        this.totalCommissionByType = totalCommissionByType;
        this.totalCommissionByProducer = totalCommissionByProducer;
        this.paymentId = paymentId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTrackingCode() {
        return trackingCode;
    }

    public void setTrackingCode(String trackingCode) {
        this.trackingCode = trackingCode;
    }

    public String getProducerTin() {
        return producerTin;
    }

    public void setProducerTin(String producerTin) {
        this.producerTin = producerTin;
    }

    public String getProducerName() {
        return producerName;
    }

    public void setProducerName(String producerName) {
        this.producerName = producerName;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPolicyNumber() {
        return policyNumber;
    }

    public void setPolicyNumber(String policyNumber) {
        this.policyNumber = policyNumber;
    }

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

    public String getCo() {
        return co;
    }

    public void setCo(String co) {
        this.co = co;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public Date getComEffDate() {
        return comEffDate;
    }

    public void setComEffDate(Date comEffDate) {
        this.comEffDate = comEffDate;
    }

    public String getTierLevel() {
        return tierLevel;
    }

    public void setTierLevel(String tierLevel) {
        this.tierLevel = tierLevel;
    }

    public String getAorChange() {
        return aorChange;
    }

    public void setAorChange(String aorChange) {
        this.aorChange = aorChange;
    }

    public String getCommType() {
        return commType;
    }

    public void setCommType(String commType) {
        this.commType = commType;
    }

    public String getOi() {
        return oi;
    }

    public void setOi(String oi) {
        this.oi = oi;
    }

    public String getSplitAmt() {
        return splitAmt;
    }

    public void setSplitAmt(String splitAmt) {
        this.splitAmt = splitAmt;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    public String getNoMos() {
        return noMos;
    }

    public void setNoMos(String noMos) {
        this.noMos = noMos;
    }

    public String getMbrCnt() {
        return mbrCnt;
    }

    public void setMbrCnt(String mbrCnt) {
        this.mbrCnt = mbrCnt;
    }

    public String getIntPrm() {
        return intPrm;
    }

    public void setIntPrm(String intPrm) {
        this.intPrm = intPrm;
    }

    public String getAdvBal() {
        return advBal;
    }

    public void setAdvBal(String advBal) {
        this.advBal = advBal;
    }

    public String getPremiumReceived() {
        return premiumReceived;
    }

    public void setPremiumReceived(String premiumReceived) {
        this.premiumReceived = premiumReceived;
    }

    public String getStlToDtPremium() {
        return stlToDtPremium;
    }

    public void setStlToDtPremium(String stlToDtPremium) {
        this.stlToDtPremium = stlToDtPremium;
    }

    public String getStlToDtCommission() {
        return stlToDtCommission;
    }

    public void setStlToDtCommission(String stlToDtCommission) {
        this.stlToDtCommission = stlToDtCommission;
    }

    public String getCurrentCommission() {
        return currentCommission;
    }

    public void setCurrentCommission(String currentCommission) {
        this.currentCommission = currentCommission;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public String getTotalCommissionByType() {
        return totalCommissionByType;
    }

    public void setTotalCommissionByType(String totalCommissionByType) {
        this.totalCommissionByType = totalCommissionByType;
    }

    public String getTotalCommissionByProducer() {
        return totalCommissionByProducer;
    }

    public void setTotalCommissionByProducer(String totalCommissionByProducer) {
        this.totalCommissionByProducer = totalCommissionByProducer;
    }

    public int getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(int paymentId) {
        this.paymentId = paymentId;
    }

    @XmlTransient
    public Collection<Payment> getPaymentCollection() {
        return paymentCollection;
    }

    public void setPaymentCollection(Collection<Payment> paymentCollection) {
        this.paymentCollection = paymentCollection;
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
        if (!(object instanceof PaymentDetail)) {
            return false;
        }
        PaymentDetail other = (PaymentDetail) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.dcarlidev.fmo.financial.beans.PaymentDetail[ id=" + id + " ]";
    }
    
}

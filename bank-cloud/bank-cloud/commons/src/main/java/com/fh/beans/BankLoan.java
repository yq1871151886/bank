package com.fh.beans;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

@TableName("bank_loan")
public class BankLoan implements Serializable {

    @TableId(value = "trans_id",type= IdType.INPUT)
    private String transId;

    @TableField("cust_id")
    private String custId;

    @TableField("account")
    private String account;

    @TableField("trans_date")
    private String transDate;

    @TableField("loan_amount")
    private Double loanAmount;

    @TableField("ins_count")
    private Short insCount;

    @TableField("loan_interest")
    private Double loanInterest;

    @TableField("loan_amount_sum")
    private Double loanAmountSum;

    @TableField("expiration_date")
    private String expirationDate;

    @TableField("recovered_amount")
    private Double recoveredAmount;

    @TableField("loan_status")
    private String loanStatus;

    @TableField("reviewer_id")
    private String reviewerId;

    @TableField("loan_type_name")
    private String loanTypeName;

    public String getTransId() {
        return transId;
    }

    public void setTransId(String transId) {
        this.transId = transId == null ? null : transId.trim();
    }

    public String getCustId() {
        return custId;
    }

    public void setCustId(String custId) {
        this.custId = custId == null ? null : custId.trim();
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account == null ? null : account.trim();
    }

    public String getTransDate() {
        return transDate;
    }

    public void setTransDate(String transDate) {
        this.transDate = transDate == null ? null : transDate.trim();
    }

    public Double getLoanAmount() {
        return loanAmount;
    }

    public void setLoanAmount(Double loanAmount) {
        this.loanAmount = loanAmount;
    }

    public Short getInsCount() {
        return insCount;
    }

    public void setInsCount(Short insCount) {
        this.insCount = insCount;
    }

    public Double getLoanInterest() {
        return loanInterest;
    }

    public void setLoanInterest(Double loanInterest) {
        this.loanInterest = loanInterest;
    }

    public Double getLoanAmountSum() {
        return loanAmountSum;
    }

    public void setLoanAmountSum(Double loanAmountSum) {
        this.loanAmountSum = loanAmountSum;
    }

    public String getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(String expirationDate) {
        this.expirationDate = expirationDate == null ? null : expirationDate.trim();
    }

    public Double getRecoveredAmount() {
        return recoveredAmount;
    }

    public void setRecoveredAmount(Double recoveredAmount) {
        this.recoveredAmount = recoveredAmount;
    }

    public String getLoanStatus() {
        return loanStatus;
    }

    public void setLoanStatus(String loanStatus) {
        this.loanStatus = loanStatus == null ? null : loanStatus.trim();
    }

    public String getReviewerId() {
        return reviewerId;
    }

    public void setReviewerId(String reviewerId) {
        this.reviewerId = reviewerId == null ? null : reviewerId.trim();
    }

    public String getLoanTypeName() {
        return loanTypeName;
    }

    public void setLoanTypeName(String loanTypeName) {
        this.loanTypeName = loanTypeName == null ? null : loanTypeName.trim();
    }



}
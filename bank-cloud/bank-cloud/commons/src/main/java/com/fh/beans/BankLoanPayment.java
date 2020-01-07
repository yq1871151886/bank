package com.fh.beans;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

@TableName("bank_loan_payment")
public class BankLoanPayment {

    @TableId(value = "payment_id",type = IdType.INPUT)
    private String paymentId;

    @TableField("trans_id")
    private String transId;

    @TableField("ins_num")
    private Short insNum;

    @TableField("payment_amount")
    private Double paymentAmount;

    @TableField("payment_date")
    private String paymentDate;

    @TableField("is_finished")
    private String isFinished;

    @TableField("fine_rate")
    private Double fineRate;

    @TableField("all_payment_amount")
    private Double allPaymentAmount;

    @TableField("reimbursement")
    private Double reimbursement;



    public String getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(String paymentId) {
        this.paymentId = paymentId == null ? null : paymentId.trim();
    }

    public String getTransId() {
        return transId;
    }

    public void setTransId(String transId) {
        this.transId = transId == null ? null : transId.trim();
    }

    public Short getInsNum() {
        return insNum;
    }

    public void setInsNum(Short insNum) {
        this.insNum = insNum;
    }

    public Double getPaymentAmount() {
        return paymentAmount;
    }

    public void setPaymentAmount(Double paymentAmount) {
        this.paymentAmount = paymentAmount;
    }

    public String getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(String paymentDate) {
        this.paymentDate = paymentDate == null ? null : paymentDate.trim();
    }

    public String getIsFinished() {
        return isFinished;
    }

    public void setIsFinished(String isFinished) {
        this.isFinished = isFinished == null ? null : isFinished.trim();
    }

    public Double getFineRate() {
        return fineRate;
    }

    public void setFineRate(Double fineRate) {
        this.fineRate = fineRate;
    }

    public Double getAllPaymentAmount() {
        return allPaymentAmount;
    }

    public void setAllPaymentAmount(Double allPaymentAmount) {
        this.allPaymentAmount = allPaymentAmount;
    }

    public Double getReimbursement() {
        return reimbursement;
    }

    public void setReimbursement(Double reimbursement) {
        this.reimbursement = reimbursement;
    }
}
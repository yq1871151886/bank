package com.fh.beans;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@TableName("bank_loan_paylog")
public class BankLoanPaylog {

    @TableId(value = "paylog_id",type =IdType.INPUT)
    private String paylogId;

    @TableField("trans_id")
    private String transId;
    @TableField("pay_amount")
    private Double payAmount;
    @TableField("pay_date")
    private String payDate;
    @TableField("account")
    private String account;


    public String getPaylogId() {
        return paylogId;
    }

    public void setPaylogId(String paylogId) {
        this.paylogId = paylogId == null ? null : paylogId.trim();
    }

    public String getTransId() {
        return transId;
    }

    public void setTransId(String transId) {
        this.transId = transId == null ? null : transId.trim();
    }

    public Double getPayAmount() {
        return payAmount;
    }

    public void setPayAmount(Double payAmount) {
        this.payAmount = payAmount;
    }

    public String getPayDate() {
        return payDate;
    }

    public void setPayDate(String payDate) {
        this.payDate = payDate == null ? null : payDate.trim();
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account == null ? null : account.trim();
    }
}
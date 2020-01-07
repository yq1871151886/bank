package com.fh.beans;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;

@TableName("bank_loan_type")
public class BankLoanType {

    @TableField("loan_type_name")
    private String loanTypeName;

    @TableField("period_one")
    private Double periodOne;

    @TableField("period_two")
    private Double periodTwo;

    @TableField("period_three")
    private Double periodThree;

    @TableField("fine_rate")
    private Double fineRate;



    public String getLoanTypeName() {
        return loanTypeName;
    }

    public void setLoanTypeName(String loanTypeName) {
        this.loanTypeName = loanTypeName == null ? null : loanTypeName.trim();
    }

    public Double getPeriodOne() {
        return periodOne;
    }

    public void setPeriodOne(Double periodOne) {
        this.periodOne = periodOne;
    }

    public Double getPeriodTwo() {
        return periodTwo;
    }

    public void setPeriodTwo(Double periodTwo) {
        this.periodTwo = periodTwo;
    }

    public Double getPeriodThree() {
        return periodThree;
    }

    public void setPeriodThree(Double periodThree) {
        this.periodThree = periodThree;
    }

    public Double getFineRate() {
        return fineRate;
    }

    public void setFineRate(Double fineRate) {
        this.fineRate = fineRate;
    }
}
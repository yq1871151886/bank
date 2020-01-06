package com.fh.beans;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

@Data
@TableName("bank_loan")
public class BankLoan implements Serializable {

    @TableId(value = "trans_id",type= IdType.INPUT)
    private String transId;

    @TableField("")
    private String custId;

    private String account;

    private String transDate;

    private Double loanAmount;

    private Short insCount;

    private Double loanInterest;

    private Double loanAmountSum;

    private String expirationDate;

    private Double recoveredAmount;

    private String loanStatus;

    private String reviewerId;

    private String loanTypeName;


}
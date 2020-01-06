package com.fh.beans;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@TableName("bank_customer")
@Data
public class BankCustomer {

    @TableId(value = "cust_id",type = IdType.INPUT)
    private String custId;

    @TableField(value = "cust_name")
    private String custName;

    @TableField(value = "password")
    private String password;

    @TableField(value = "identity_card")
    private String identityCard;

    @TableField(value = "cust_type")
    private String custType;

    @TableField(value = "sex")
    private Boolean sex;

    @TableField(value = "phone")
    private String phone;

    @TableField(value = "address")
    private String address;

    @TableField(value = "email")
    private String email;

    @TableField(value = "credit")
    private String credit;

}
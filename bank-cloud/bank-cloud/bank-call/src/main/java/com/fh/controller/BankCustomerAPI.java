package com.fh.controller;

import com.fh.beans.BankCustomer;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(value = "bank-customer")
@RequestMapping("customfeign")
public interface BankCustomerAPI {

    @GetMapping("/{custId}")
    BankCustomer getCustomerById(@PathVariable(value = "custId") String custId);


    BankCustomer selectByPrimaryKey(String custId);
}

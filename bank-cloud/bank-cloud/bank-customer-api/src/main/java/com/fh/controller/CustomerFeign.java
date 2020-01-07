package com.fh.controller;

import com.fh.beans.BankCustomer;
import com.fh.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("customfeign")
public class CustomerFeign {

    @Autowired
    private CustomerService customerService;

    /**
     * 根据主键获取客户信息
     * @param custId
     * @return
     */
    @GetMapping("/{custId}")
    public BankCustomer getCustomerById(@PathVariable(value = "custId") String custId){
        BankCustomer customerById = customerService.getCustomerById(custId);
        return customerById;
    }


}

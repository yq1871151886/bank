package com.fh.controller;

import com.fh.beans.BankAccount;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(value = "bank-account")
@RequestMapping("account")
public interface BankAccountAPI {


    @GetMapping(value = "/{remitOutAccount}")
    BankAccount selectByPrimaryKey(@PathVariable(value = "remitOutAccount") String remitOutAccount);

    @PostMapping(value = "/{bankAccount}")
    void updateByPrimaryKey(@PathVariable(value = "bankAccount") BankAccount bankAccount);

    void updateByPrimaryKeySelective(BankAccount bankAccount);
}

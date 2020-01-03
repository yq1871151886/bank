package com.fh.controller;

import com.fh.beans.BankDeposit;
import com.fh.enumbean.ResponseServer;
import com.fh.service.DepositService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/deposit")
public class DepositController {
    @Autowired
    private DepositService depositService;

    //Deposit records查询存款记录
    @PostMapping("/queryDepositRecords")
    public List<BankDeposit> queryDepositRecords(String account){
        List<BankDeposit> list = depositService.queryDepositRecords(account);
        return list;
    }





}

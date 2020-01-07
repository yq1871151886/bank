package com.fh.controller;

import com.fh.beans.loan.BankLoanApplyInfo;
import com.fh.beans.loan.BankLoanPaymentInfo;
import com.fh.enumbean.ResponseServer;
import com.fh.service.LoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/BankLoan")
public class LoanController {

    @Autowired
    private LoanService loanService;

    //贷款申请
    @PostMapping
    public ResponseServer applyLoan(BankLoanApplyInfo bankLoanApplyInfo) {
        System.out.println(bankLoanApplyInfo.toString());
        return loanService.dealApplyment(bankLoanApplyInfo);
    }

    //获取所有的贷款信息
    @GetMapping
    public ResponseServer getAllRecords() {
        return loanService.sentAllRecords();
    }

    //获取单个贷款信息
    @GetMapping("/{id}")
    public ResponseServer getOneRecord(@PathVariable("id")String id) {
        return loanService.sentOneRecord(id);
    }



}

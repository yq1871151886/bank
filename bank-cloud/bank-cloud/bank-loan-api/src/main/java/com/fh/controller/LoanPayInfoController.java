package com.fh.controller;

import com.fh.beans.loan.BankLoanPaymentInfo;
import com.fh.enumbean.ResponseServer;
import com.fh.service.LoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/PayInfo")
public class LoanPayInfoController {

    @Autowired
    private LoanService loanService;

    //还款信息获取
    @GetMapping("/{transId}")
    public ResponseServer getPaymentOneInfo(@PathVariable("transId")String transId) {
        return loanService.getPaymentOneInfo(transId);
    }

    //还款信息登记
    @PostMapping
    public ResponseServer payForLoan(BankLoanPaymentInfo bankLoanPaymentInfo) {
        return loanService.payForLoan(bankLoanPaymentInfo);
    }
}

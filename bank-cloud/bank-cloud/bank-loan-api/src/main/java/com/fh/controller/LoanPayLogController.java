package com.fh.controller;

import com.fh.beans.loan.BankLoanPaymentInfo;
import com.fh.enumbean.ResponseServer;
import com.fh.service.LoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/LoanPayLog")
public class LoanPayLogController {

    @Autowired
    private LoanService loanService;

    //获取还款日志
    @GetMapping("/{value}")
    public ResponseServer getPayLog(@PathVariable("value")String value) {
        return loanService.getPaylog(value);
    }


}

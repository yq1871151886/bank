package com.fh.controller;

import com.fh.enumbean.ResponseServer;
import com.fh.service.LoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/LoanMent")
public class LoanMentController {

    @Autowired
    private LoanService loanService;

    //获取利率信息
    @GetMapping
    public ResponseServer getInterestRate() {
        return loanService.getInterestRate();
    }

    //获取利率信息
    @GetMapping("/{value}")
    public ResponseServer getInterestOneRate(@PathVariable("value")int value) {
        return loanService.getInterestOneRate(value);
    }
}

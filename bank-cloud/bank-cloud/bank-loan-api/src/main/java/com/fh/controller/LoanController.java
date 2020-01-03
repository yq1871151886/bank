package com.fh.controller;

import com.fh.service.LoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/bank_loan")
public class LoanController {

    @Autowired
    private LoanService loanService;

}

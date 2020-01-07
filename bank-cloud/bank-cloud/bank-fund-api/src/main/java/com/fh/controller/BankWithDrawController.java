package com.fh.controller;

import com.fh.beans.BankUser;
import com.fh.beans.BankWithdraw;
import com.fh.enumbean.ResponseServer;
import com.fh.service.BankWithDrawService;
import org.apache.http.annotation.Contract;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.math.BigDecimal;

/**
 * 取款业务
 */
@Controller
@RequestMapping("bankWithDrawController")
public class BankWithDrawController {
    @Autowired
    private BankWithDrawService bankWithDrawService;

    /**
     *取款
     */
    @RequestMapping("withDrawal")
    public ResponseServer withDrawal(HttpServletRequest request, BankWithdraw bankWithdraw, String account){
        BankUser bankUser = (BankUser) request.getAttribute("user");
        return bankWithDrawService.withDrawal(bankUser.getUserId(),bankWithdraw,account);
    }

    /**
     *查询余额
     */
    @RequestMapping()
    public ResponseServer selectBalances(String cust_id){
        return bankWithDrawService.selectBalances(cust_id);
    }

}

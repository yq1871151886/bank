package com.fh.controller;

import com.fh.beans.BankFundHold;
import com.fh.beans.BankFundLog;
import com.fh.beans.BankUser;
import com.fh.enumbean.ResponseServer;
import com.fh.service.FundHoldService;
import com.fh.utils.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * 基金持有
 */
@RestController
@RequestMapping("foudHoldController")
public class FundHoldController {

    @Autowired
    private FundHoldService fundHoldService;

    /**
     * 查询用户所拥有的全部基金
     */
    @RequestMapping("selectFoudByUserId")
    public ResponseServer selectFoudByUserId(String cust_id){
        List<BankFundHold> list =  fundHoldService.selectFoudByUserId(cust_id);
        return ResponseServer.success(list);
    }
    /**
     *查询所有的基金交易记录
     * 需要传参 分页工具bean
     */
    @RequestMapping("selectFundLogList")
    public ResponseServer selectFundLogList(HttpServletRequest request){
        BankUser bankUser = (BankUser) request.getAttribute("user");
        List<BankFundLog> logs= fundHoldService.selectFundLogList(bankUser.getUserId());
        return ResponseServer.success(logs);
    }
    /**
     * 根据id查询基金交易记录
     * 需要传参 基金交易流水号fund_tx_id
     */
    @RequestMapping("selectFundLogById")
    public ResponseServer selectFundLogById(HttpServletRequest request,String fund_tx_id){
        BankUser bankUser = (BankUser) request.getAttribute("user");
        BankFundLog bankFundLog = fundHoldService.selectFundLogById(bankUser.getUserId(),fund_tx_id);
        return ResponseServer.success(bankFundLog);
    }
}

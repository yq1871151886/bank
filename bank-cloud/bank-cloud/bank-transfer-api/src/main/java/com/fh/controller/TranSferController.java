package com.fh.controller;

import com.fh.beans.BankTransferLog;
import com.fh.beans.BankUser;
import com.fh.enumbean.ResponseServer;
import com.fh.service.TransferService;
import com.fh.utils.UtilsTools;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping
public class TranSferController {
    @Autowired
    private TransferService transferService;

    /**
     * 创建转账记录
     */
    public ResponseServer createTransfer(BankTransferLog bankTransferLog) {
        return transferService.createTransfer(bankTransferLog);
    }

    /**
     * 查询自己转出的转账记录
     */
    public ResponseServer selectOutTransferLog(HttpServletRequest request,String account){
        return transferService.selectOutTransferLog(account);
    }
    /**
     * 查询自己收到的转账记录
     */
    public ResponseServer selectInTransferLog(HttpServletRequest request,String account){
        return transferService.selectInTransferLog(account);
    }
    /**
     * 根据转账记录id查询具体的转账记录
     */
    public ResponseServer selectTransferLogById(String id){
        return transferService.selectTransferLogById(id);
    }
}

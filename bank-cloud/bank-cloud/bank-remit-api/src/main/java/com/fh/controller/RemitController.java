package com.fh.controller;

import com.fh.beans.BankRemitLog;
import com.fh.enumbean.ResponseServer;
import com.fh.service.RemitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("remit")
@CrossOrigin(maxAge = 3600,origins = "http://localhost:8080",exposedHeaders = "NOLOGIN")
public class RemitController {


    @Autowired
    private RemitService remitService;

    @PutMapping
    public ResponseServer createRemit(String name, String phone, String remitOutAccount, String remitInAccount, String password, double amount){
        ResponseServer remit = remitService.createRemit(name, phone, remitOutAccount, remitInAccount, password, amount);
        return remit;
    }

    @GetMapping("getRemit")
    public ResponseServer getRemit(String remitInAccount, String remitId){
        ResponseServer remit = remitService.getRemit(remitInAccount, remitId);
        return remit;
    }

    @GetMapping("getRemitLogs")
    public List<BankRemitLog> getRemitLogs(){
        List<BankRemitLog> remitLogs = remitService.getRemitLogs();
        return remitLogs;
    }

    @GetMapping("getOneRemitLog")
    public ResponseServer getOneRemitLog(String remitId){
        ResponseServer oneRemitLog = remitService.getOneRemitLog(remitId);
        return oneRemitLog;
    }
}

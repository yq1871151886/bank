package com.fh.service.impl;

import com.fh.beans.BankTransferLog;
import com.fh.dao.TransferDao;
import com.fh.enumbean.ResponseServer;
import com.fh.service.TransferService;
import com.fh.utils.UtilsTools;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
public class TransferServiceImpl implements TransferService {
    @Autowired
    private TransferDao transferDao;
    @Override
    public ResponseServer createTransfer(BankTransferLog bankTransferLog) {
        bankTransferLog.setReceiveDate(new Date().toString());
        bankTransferLog.setTransferId(UtilsTools.getOrderId());
        transferDao.createTransfer(bankTransferLog);
        return ResponseServer.success();
    }


    @Override
    public ResponseServer selectOutTransferLog(String account) {
        List<BankTransferLog > logs = transferDao.selectOutTransferLog(account);
        return ResponseServer.success(logs);
    }

    @Override
    public ResponseServer selectInTransferLog(String account) {
        List<BankTransferLog > logs = transferDao.selectInTransferLog(account);
        return ResponseServer.success(logs);
    }

    @Override
    public ResponseServer selectTransferLogById(String id) {
       BankTransferLog bankTransferLog =  transferDao.selectTransferLogById(id);
        return ResponseServer.success(bankTransferLog);
    }
}

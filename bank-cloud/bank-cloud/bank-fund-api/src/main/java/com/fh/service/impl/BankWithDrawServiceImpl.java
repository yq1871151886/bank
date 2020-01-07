package com.fh.service.impl;

import com.fh.beans.BankWithdraw;
import com.fh.dao.BankWithDrawDao;
import com.fh.enumbean.ResponseServer;
import com.fh.service.BankWithDrawService;
import com.fh.utils.UtilsTools;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.Date;

@Service
public class BankWithDrawServiceImpl implements BankWithDrawService {
    @Autowired
    private BankWithDrawDao bankWithDrawDao;
    @Override
    @Transactional
    public ResponseServer withDrawal(String userId, BankWithdraw bankWithdraw, String account) {
        bankWithdraw.setAccount(account);
        bankWithdraw.setArriveTime(new Date().toString());
        bankWithdraw.setWithdrawId(UtilsTools.getOrderId());
       bankWithdraw.setReviewerId(userId);
        bankWithDrawDao.insertBankWithDraw(bankWithdraw);
        bankWithDrawDao.updateBalances(bankWithdraw.getCustId(),bankWithdraw.getWithdrawMoney());
        return ResponseServer.success();
    }

    @Override
    public ResponseServer selectBalances(String cust_id) {
        Double money = bankWithDrawDao.selectBalances(cust_id);
        return ResponseServer.success(money);
    }
}

package com.fh.service;

import com.fh.beans.BankDeposit;
import com.fh.dao.DepositDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepositServiceImpl implements DepositService {
    @Autowired
    private DepositDao depositDao;
    @Override
    public List<BankDeposit> queryDepositRecords(String account) {
        return depositDao.queryDepositRecords(account);
    }
}

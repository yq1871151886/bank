package com.fh.service.impl;

import com.fh.beans.BankFundHold;
import com.fh.beans.BankFundLog;
import com.fh.beans.BankUser;
import com.fh.dao.FundHoldDao;
import com.fh.service.FundHoldService;
import com.fh.utils.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FundHoldServiceImpl implements FundHoldService {
    @Autowired
    private FundHoldDao foudHoldDao;

    @Override
    public List<BankFundHold> selectFoudByUserId(String cust_id) {
       /* pageBean.setRecordsFiltered(foudHoldDao.selectFoudCount(userId));
        pageBean.setRecordsTotal(foudHoldDao.selectFoudCount(userId));*/

        return foudHoldDao.selectFoudList(cust_id);
    }

    @Override
    public  List<BankFundLog> selectFundLogList(String cust_id) {
        return foudHoldDao.selectFundLogList(cust_id);
    }

    @Override
    public BankFundLog selectFundLogById(String cust_id, String fund_tx_id) {
        BankFundLog bankFundLog =  foudHoldDao.selectFundLogById(cust_id,fund_tx_id);
        return bankFundLog;
    }
}

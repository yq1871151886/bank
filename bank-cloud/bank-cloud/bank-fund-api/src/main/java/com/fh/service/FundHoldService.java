package com.fh.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.fh.beans.BankFundHold;
import com.fh.beans.BankFundLog;
import com.fh.beans.BankUser;
import com.fh.utils.PageBean;

import java.util.List;

public interface FundHoldService {

    List<BankFundHold> selectFoudByUserId(String cust_id);

    List<BankFundLog> selectFundLogList(String cust_id);

    BankFundLog selectFundLogById(String cust_id,String fund_tx_id);
}

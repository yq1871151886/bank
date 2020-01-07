package com.fh.service;

import com.fh.beans.BankWithdraw;
import com.fh.enumbean.ResponseServer;

import java.math.BigDecimal;

public interface BankWithDrawService {
    ResponseServer withDrawal(String userId, BankWithdraw bankWithdraw, String account);

    ResponseServer selectBalances(String cust_id);
}

package com.fh.service;


import com.fh.beans.BankDepositRate;
import com.fh.utils.BankResult;

public interface BankDepositRateService {

    BankResult insert(BankDepositRate bankDepositRate);

    BankResult update(BankDepositRate bankDepositRate);

    BankResult getAllRate();
}

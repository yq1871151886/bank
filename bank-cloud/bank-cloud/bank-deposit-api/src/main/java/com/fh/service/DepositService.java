package com.fh.service;

import com.fh.beans.BankDeposit;

import java.util.List;

public interface DepositService {
    List<BankDeposit> queryDepositRecords(String account);
}

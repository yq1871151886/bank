package com.fh.service;

import com.fh.beans.loan.BankLoanApplyInfo;
import com.fh.beans.loan.BankLoanPaymentInfo;
import com.fh.enumbean.ResponseServer;

public interface LoanService {

    ResponseServer dealApplyment(BankLoanApplyInfo bankLoanApplyInfo);
    ResponseServer sentAllRecords();
    ResponseServer payForLoan(BankLoanPaymentInfo bankLoanPaymentInfo);
    ResponseServer sentOneRecord(String transId);
    ResponseServer getInterestRate();
    ResponseServer getInterestOneRate(int value);
    ResponseServer getPaylog(String value);
    ResponseServer getPaymentOneInfo(String value);
}

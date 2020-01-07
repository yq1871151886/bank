package com.fh.service;

import com.fh.beans.BankRemitLog;
import com.fh.enumbean.ResponseServer;

import java.util.List;

public interface RemitService {
    ResponseServer createRemit(String name, String phone, String remitOutAccount, String remitInAccount, String password, double amount);
    ResponseServer getRemit(String remitInAccount, String remitId);
    List<BankRemitLog> getRemitLogs();
    ResponseServer getOneRemitLog(String remitId);

}

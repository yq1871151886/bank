package com.fh.service;

import com.fh.beans.BankTransferLog;
import com.fh.enumbean.ResponseServer;

public interface TransferService {
    ResponseServer createTransfer(BankTransferLog bankTransferLog);


    ResponseServer selectOutTransferLog(String account);

    ResponseServer selectInTransferLog(String account);

    ResponseServer selectTransferLogById(String id);
}

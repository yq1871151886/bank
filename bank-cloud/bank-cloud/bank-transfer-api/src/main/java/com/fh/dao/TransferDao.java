package com.fh.dao;

import com.fh.beans.BankTransferLog;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.Mapping;

import java.util.List;

@Repository
@Mapper
public interface TransferDao {
    void createTransfer(BankTransferLog bankTransferLog);

    List<BankTransferLog> selectOutTransferLog(String account);

    List<BankTransferLog> selectInTransferLog(String account);

    BankTransferLog selectTransferLogById(String id);
}

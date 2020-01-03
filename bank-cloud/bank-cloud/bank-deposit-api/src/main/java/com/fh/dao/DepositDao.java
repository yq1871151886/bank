package com.fh.dao;

import com.fh.beans.BankDeposit;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface DepositDao {
    List<BankDeposit> queryDepositRecords(String account);
}

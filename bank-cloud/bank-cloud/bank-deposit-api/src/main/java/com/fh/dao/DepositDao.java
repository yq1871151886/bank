package com.fh.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.fh.beans.BankDeposit;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface DepositDao extends BaseMapper<BankDeposit> {
    List<BankDeposit> queryDepositRecords(String account);
}

package com.fh.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.fh.beans.BankFundLog;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface FundLogDao extends BaseMapper<BankFundLog> {
    void insertBankFundLog(BankFundLog bankFundLog);
}

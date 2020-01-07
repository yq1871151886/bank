package com.fh.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.fh.beans.BankFundHold;
import com.fh.beans.BankFundLog;
import com.fh.beans.BankUser;
import com.fh.utils.PageBean;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface FundHoldDao extends BaseMapper<BankFundHold> {

    Long selectFoudCount(String cust_id);

    List selectFoudList(String cust_id);

    Long selectFundLogCount( String cust_id);

    List selectFundLogList(String cust_id);

    BankFundLog selectFundLogById(@Param("cust_id") String userId,@Param("fund_tx_id") String fund_tx_id);

    void insertfundHold(BankFundHold bankFundHold);
}

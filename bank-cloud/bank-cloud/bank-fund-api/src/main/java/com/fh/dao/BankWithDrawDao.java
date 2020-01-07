package com.fh.dao;

import com.fh.beans.BankWithdraw;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface BankWithDrawDao {
    void insertBankWithDraw(BankWithdraw bankWithdraw);

    void updateBalances(@Param("userId") String userId, @Param("withdrawMoney") Double withdrawMoney);

    Double selectBalances(String cust_id);
}

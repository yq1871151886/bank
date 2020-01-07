package com.fh.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.fh.beans.BankLoan;
import com.fh.beans.BankLoanExample;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface BankLoanMapper extends BaseMapper<BankLoan> {


    void updateByPrimaryKey(BankLoan bankLoan);

    List<BankLoan> selectByExample(BankLoanExample bankLoanExample);

    BankLoan selectByPrimaryKey(String transId);
}

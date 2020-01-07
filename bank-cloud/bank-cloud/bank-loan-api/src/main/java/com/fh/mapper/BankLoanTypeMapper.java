package com.fh.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.fh.beans.BankLoanType;
import com.fh.beans.BankLoanTypeExample;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface BankLoanTypeMapper extends BaseMapper<BankLoanType> {
    int countByExample(BankLoanTypeExample example);

    int deleteByExample(BankLoanTypeExample example);

    int deleteByPrimaryKey(String loanTypeName);

    int insert(BankLoanType record);

    int insertSelective(BankLoanType record);

    List<BankLoanType> selectByExample(BankLoanTypeExample example);

    BankLoanType selectByPrimaryKey(String loanTypeName);

    int updateByExampleSelective(@Param("record") BankLoanType record, @Param("example") BankLoanTypeExample example);

    int updateByExample(@Param("record") BankLoanType record, @Param("example") BankLoanTypeExample example);

    int updateByPrimaryKeySelective(BankLoanType record);

    int updateByPrimaryKey(BankLoanType record);
}
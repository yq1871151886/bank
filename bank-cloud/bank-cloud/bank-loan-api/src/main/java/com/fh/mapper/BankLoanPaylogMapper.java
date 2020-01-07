package com.fh.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.fh.beans.BankLoanPaylog;
import com.fh.beans.BankLoanPaylogExample;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Mapper
@Repository
public interface BankLoanPaylogMapper extends BaseMapper<BankLoanPaylog> {
    int countByExample(BankLoanPaylogExample example);

    int deleteByExample(BankLoanPaylogExample example);

    int deleteByPrimaryKey(String paylogId);

    int insert(BankLoanPaylog record);

    int insertSelective(BankLoanPaylog record);

    List<BankLoanPaylog> selectByExample(BankLoanPaylogExample example);

    BankLoanPaylog selectByPrimaryKey(String paylogId);

    int updateByExampleSelective(@Param("record") BankLoanPaylog record, @Param("example") BankLoanPaylogExample example);

    int updateByExample(@Param("record") BankLoanPaylog record, @Param("example") BankLoanPaylogExample example);

    int updateByPrimaryKeySelective(BankLoanPaylog record);

    int updateByPrimaryKey(BankLoanPaylog record);
}
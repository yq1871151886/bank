package com.fh.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.fh.beans.BankAccount;
import com.fh.beans.BankAccountExample;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface BankAccounMapper extends BaseMapper<BankAccount> {

 int countByExample(BankAccountExample example);

 int deleteByExample(BankAccountExample example);

 int deleteByPrimaryKey(String account);

 int insert(BankAccount record);

 int insertSelective(BankAccount record);

 List<BankAccount> selectByExample(BankAccountExample example);

 BankAccount selectByPrimaryKey(String account);

 int updateByExampleSelective(@Param("record") BankAccount record, @Param("example") BankAccountExample example);

 int updateByExample(@Param("record") BankAccount record, @Param("example") BankAccountExample example);

 int updateByPrimaryKeySelective(BankAccount record);

 int updateByPrimaryKey(BankAccount record);

}

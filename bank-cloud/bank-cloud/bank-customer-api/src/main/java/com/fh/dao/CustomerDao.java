package com.fh.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.fh.beans.BankCustomer;
import com.fh.beans.BankCustomerPo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface CustomerDao extends BaseMapper<BankCustomer> {
    List<BankCustomer> selectByPo(BankCustomerPo customerPo);
    List<BankCustomer> selectByPo();
}

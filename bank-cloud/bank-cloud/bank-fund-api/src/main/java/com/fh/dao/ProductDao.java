package com.fh.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.fh.beans.BankFundProduct;
import com.fh.utils.PageBean;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface ProductDao extends BaseMapper<BankFundProduct> {
    List<BankFundProduct> selectProductAll(@Param("pageBean") PageBean pageBean, @Param("product") BankFundProduct product);

    Long selectProductCount(BankFundProduct product);

    BankFundProduct selectProductById(String id);
}

package com.fh.service;

import com.fh.beans.BankCustomer;
import com.fh.beans.BankCustomerPo;
import com.fh.enumbean.ResponseServer;

import java.util.List;

public interface CustomerService {
    /**
     * 验证客户名是否存在
     * @param custName
     * @return
     */
    boolean isExist(String custName);

    /**
     * 插入客户信息
     * @param customer
     */
    ResponseServer add(BankCustomer customer);

    /**
     * 根据主键删除客户信息（实际只修改用户状态）
     * @param cust_id
     */
    ResponseServer delete(String cust_id);

    /**
     * 根据主键获取客户信息
     * @param custId
     * @return
     */
    BankCustomer getCustomerById(String custId);

    /**
     * 根据客户名获取客户信息
     * @param custName
     * @return
     */
    ResponseServer getCustomerByCustName(String custName);

    /**
     * 获取所有客户
     * @return
     */
    List<BankCustomer> getCustomers();

    /**
     * 获取符合条件的客户
     * @param example
     * @return
     */
    List<BankCustomer> getCustomers(BankCustomerPo example);

    /**
     * 更新
     * @param customer
     */
    boolean update(BankCustomer customer);
}

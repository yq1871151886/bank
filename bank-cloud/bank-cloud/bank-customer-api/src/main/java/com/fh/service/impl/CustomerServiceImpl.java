package com.fh.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.fh.beans.BankCustomer;
import com.fh.beans.BankCustomerPo;
import com.fh.dao.CustomerDao;
import com.fh.enumbean.ResponseEnum;
import com.fh.enumbean.ResponseServer;
import com.fh.service.CustomerService;
import com.fh.utils.MD5Util;
import com.fh.utils.UtilsTools;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerDao customerDao;

    /**
     * 验证客户名是否存在
     * @param custName
     * @return
     */
    @Override
    public boolean isExist(String custName) {
        QueryWrapper<BankCustomer> wrapper = new QueryWrapper<BankCustomer>();
        wrapper.eq("",custName);
        List<BankCustomer> bankCustomers = customerDao.selectList(wrapper);
        if (bankCustomers.isEmpty()){
            return false;
        }else {
            return false;
        }
    }

    /**
     * 插入客户信息
     * @param customer
     */
    @Override
    public ResponseServer add(BankCustomer customer) {
        customer.setCustId(UtilsTools.getSnowId());
        //使用MD5进行加密
        String md5 = MD5Util.getMD5(customer.getPassword());
        customer.setPassword(md5);
        customerDao.insert(customer);
        return ResponseServer.success(ResponseEnum.CUSTOMER_ADD_SUCCESS);
    }


    /**
     * 根据主键删除客户信息（实际只修改用户状态）
     * @param cust_id
     */
    @Override
    public ResponseServer delete(String cust_id) {
        customerDao.deleteById(cust_id);
        return ResponseServer.success(ResponseEnum.CUSTOMER_DELETE_SUCCESS);
    }


    /**
     * 根据主键获取客户信息
     * @param custId
     * @return
     */
    @Override
    public BankCustomer getCustomerById(String custId) {
        BankCustomer bankCustomer = customerDao.selectById(custId);
        return bankCustomer;
    }


    /**
     * 根据客户名获取客户信息
     * @param custName
     * @return
     */
    @Override
    public ResponseServer getCustomerByCustName(String custName) {
        QueryWrapper<BankCustomer> wrapper = new QueryWrapper<BankCustomer>();
        wrapper.eq("",custName);
        BankCustomer bankCustomer = customerDao.selectOne(wrapper);
        return ResponseServer.success(bankCustomer);
    }


    /**
     * 获取所有客户
     * @return
     */
    @Override
    public List<BankCustomer> getCustomers() {
        BankCustomerPo example = new BankCustomerPo();
        example.setOrderByClause("cust_id desc");
        List<BankCustomer> bankCustomers = customerDao.selectByPo(example);
        return bankCustomers;
    }

    /**
     * 获取符合条件的客户
     * @param example
     * @return
     */
    @Override
    public List<BankCustomer> getCustomers(BankCustomerPo example) {
        List<BankCustomer> bankCustomers = customerDao.selectByPo(example);
        return bankCustomers;
    }

    /**
     * 更新
     * @param customer
     */
    @Override
    public boolean update(BankCustomer customer) {
        return false;
    }
}

package com.fh.service.impl;

import com.fh.beans.BankAccount;
import com.fh.beans.BankAccountExample;
import com.fh.beans.BankCustomer;
import com.fh.controller.BankCustomerAPI;
import com.fh.mapper.BankAccounMapper;
import com.fh.service.IAccountService;
import com.fh.utils.BankNumberUtil;
import com.fh.utils.MD5;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by lujiafeng on 2018/10/17.
 */

@Service
public class AccountServiceImpl implements IAccountService {


    @Autowired
    private BankCustomerAPI bankCustomerAPI;

    @Autowired
    private BankAccounMapper bankAccounMapper;


    //添加用户  还没有接口调用
    @Override
    public boolean add(String custName, BankAccount account) {
       // BankCustomer customer = customerService.getCustomerByCustName(custName);
        BankCustomer customer =  bankCustomerAPI.getCustomerById(custName);
        if (null == customer) {
            System.out.println("该账户中的客户id不存在相对应的客户");
            return false;
        } else {
            String account_id = BankNumberUtil.getBrankNumber("8");
            account.setAccount(account_id);
            account.setCustId(customer.getCustId());
            account.setOpenDate(String.valueOf(System.currentTimeMillis()));
            String pw = MD5.string2MD5(account.getPassword());
            account.setPassword(pw);
            if (null == account.getBalances()) {
                account.setBalances(0.0);
            }
            if (null == account.getBlockedBalances()) {
                account.setBlockedBalances(0.0);
            }
            bankAccounMapper.insert(account);
            System.out.println("账户插入成功");
            return true;
        }
    }

    @Override
    public boolean delete(String account_id) {
       // QueryWrapper<BankAccount> queryWrapper = new QueryWrapper<>();
        BankAccount account = bankAccounMapper.selectByPrimaryKey(account_id);
        if (account == null) {
            System.out.println("该账户不存在");
            return false;
        } else {
            // 1:正常；2:冻结；3:销户
            account.setAccountStatus("3");
            account.setCancelDate(String.valueOf(System.currentTimeMillis()));
            account.setCustId(account_id);
            bankAccounMapper.updateById(account);
            System.out.println("账户删除成功");
            return true;
        }
    }

    @Override
    public BankAccount getAccount(String account_id) {
        return bankAccounMapper.selectByPrimaryKey(account_id);
    }

    @Override
    public List<BankAccount> getAccounts() {
        BankAccountExample example = new BankAccountExample();
        List<BankAccount> bankAccountList = bankAccounMapper.selectByExample(example);
        return bankAccountList;
    }

    @Override
    public List<BankAccount> getAccounts(String cust_id) {
        BankAccountExample example = new BankAccountExample();
        example.createCriteria().andCustIdEqualTo(cust_id);
        List<BankAccount> bankAccountList = bankAccounMapper.selectByExample(example);
        return bankAccountList;
    }

    @Override
    public List<BankAccount> getAccounts(BankAccountExample example) {
        List<BankAccount> bankAccountList = bankAccounMapper.selectByExample(example);
        return bankAccountList;
    }

    @Override
    public void update(BankAccount account) {
        bankAccounMapper.updateByPrimaryKey(account);
    }

}

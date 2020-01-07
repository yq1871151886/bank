package com.fh.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.fh.beans.BankAccount;
import com.fh.beans.BankCustomer;
import com.fh.beans.BankRemitLog;
import com.fh.controller.BankAccountAPI;
import com.fh.controller.BankCustomerAPI;
import com.fh.dao.RemitDao;
import com.fh.enumbean.ResponseEnum;
import com.fh.enumbean.ResponseServer;
import com.fh.service.RemitService;
import com.fh.utils.MD5Util;
import com.fh.utils.UtilsTools;
import com.sun.org.apache.regexp.internal.RE;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RemitServiceImpl implements RemitService {

    @Autowired
    private RemitDao remitDao;

    @Autowired
    private BankCustomerAPI bankCustomerAPI;

    @Autowired
    private BankAccountAPI bankAccountAPI;


    /**
     * 发起一个转账
     * @param name
     * @param phone
     * @param remitOutAccount
     * @param remitInAccount
     * @param password
     * @param amount
     * @return
     */
    @Override
    public ResponseServer createRemit(String name, String phone, String remitOutAccount, String remitInAccount, String password, double amount) {
        //根据要转出账户主键获取账户信息
        BankAccount outAccount = bankAccountAPI.selectByPrimaryKey(remitOutAccount);

        //根据账户信息中的用户id获取用户信息
        BankCustomer outAccountCustomer = bankCustomerAPI.getCustomerById(outAccount.getCustId());

        //根据要转入的账户主键查询账户信息
        BankAccount inAccount1 = bankAccountAPI.selectByPrimaryKey(remitInAccount);
        String pw = MD5Util.getMD5(password);
        //用户姓名不匹配
        if (!outAccountCustomer.getCustName().equals(name)){
            return ResponseServer.error(ResponseEnum.REMIT_CUSTOMER_NAME_ERROR);
        }
        //用户电话不匹配
        if (!outAccountCustomer.getPhone().equals(phone)){
            return ResponseServer.error(ResponseEnum.REMIT_CUSTOMER_PHONE_ERROR);
        }
        //汇款账户不存在
        if (outAccount == null){
            return ResponseServer.error(ResponseEnum.REMIT_OUTACCOUNT_ISBLANK_ERROR);
        }
        //密码错误
        if (!outAccount.getPassword().equals(pw)){
            return ResponseServer.error(ResponseEnum.REMIT_ACCOUNT_PWD_ERROR);
        }
        //提款账户不存在
        if (inAccount1 == null){
            return ResponseServer.error(ResponseEnum.REMIT_INACCOUNT_NAME_ERROR);
        }
        //汇款账户余额不足
        if (outAccount.getBalances() < amount){
            return ResponseServer.error(ResponseEnum.REMIT_OUTACCOUNT_BALANCE_NONE_ERROR);
        }


        String snowId = UtilsTools.getSnowId();


        BankRemitLog remitLog = new BankRemitLog();


        remitLog.setRemitId(snowId);
        remitLog.setRemitOutAccount(remitOutAccount);
        remitLog.setRemitInAccount(remitInAccount);
        remitLog.setAmount(amount);
        outAccount.setBalances(outAccount.getBalances()-amount);
        bankAccountAPI.updateByPrimaryKey(outAccount);
        remitLog.setRemitGenerateDate(String.valueOf(System.currentTimeMillis()));
        remitLog.setRemitArriveDate(String.valueOf("Unpaid"));

        remitDao.insert(remitLog);

        return ResponseServer.success(remitLog.getRemitId());
    }


    /**
     * 提款
     * @param remitInAccount
     * @param remitId
     * @return
     */
    @Override
    public ResponseServer getRemit(String remitInAccount, String remitId) {
        BankAccount bankAccount = bankAccountAPI.selectByPrimaryKey(remitInAccount);
        BankRemitLog remitLog = remitDao.selectById(remitId);
        if (remitLog == null){
            return ResponseServer.error(ResponseEnum.REMIT_ISBLANK_ERROR);
        }

        if (!remitLog.getRemitInAccount().equals(remitInAccount)){
            return ResponseServer.error(ResponseEnum.REMIT_INACCOUNT_is_ERROR);
        }

        if (!remitLog.getRemitArriveDate().equals("Unpaid")){
            return ResponseServer.error(ResponseEnum.REMIT_EXTRACTED_ERROR);
        }


        remitLog.setRemitArriveDate(String.valueOf(System.currentTimeMillis()));

        remitDao.updateById(remitLog);

        bankAccount.setBalances(bankAccount.getBalances()+remitLog.getAmount());

        bankAccountAPI.updateByPrimaryKey(bankAccount);


        return ResponseServer.success();
    }


    /**
     * 获取转账信息列表
     * @return
     */
    @Override
    public List<BankRemitLog> getRemitLogs() {
        QueryWrapper<BankRemitLog> queryWrapper = new QueryWrapper<BankRemitLog>();
        List<BankRemitLog> bankRemitLogs = remitDao.selectList(queryWrapper);
        return bankRemitLogs;
    }

    /**
     * 根据汇款主键获取汇款单详细信息
     * @param remitId
     * @return
     */
    @Override
    public ResponseServer getOneRemitLog(String remitId) {
        BankRemitLog remitLog = remitDao.selectById(remitId);
        return ResponseServer.success(remitLog);
    }
}

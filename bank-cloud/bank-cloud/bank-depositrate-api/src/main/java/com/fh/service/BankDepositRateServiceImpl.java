package com.fh.service;


import com.fh.beans.BankDepositRate;
import com.fh.beans.BankDepositRateExample;
import com.fh.dao.BankDepositRateMapper;
import com.fh.utils.BankResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class BankDepositRateServiceImpl implements BankDepositRateService {

    @Autowired
    private BankDepositRateMapper bankDepositRateMapper;

    @Override
    public BankResult insert(BankDepositRate bankDepositRate) {
        if (bankDepositRate == null) {
            return BankResult.build(400, "参数错误");
        }
        bankDepositRate.setUpdateDate(Long.toString(System.currentTimeMillis()));
        bankDepositRateMapper.insert(bankDepositRate);
        return BankResult.build(200, "新增成功");
    }

    @Override
    public BankResult update(BankDepositRate bankDepositRate) {
        if (bankDepositRate == null) {
            return BankResult.build(400, "参数错误");
        }
        bankDepositRateMapper.updateByPrimaryKeySelective(bankDepositRate);
        return BankResult.build(200, "修改成功");
    }

    @Override
    public BankResult getAllRate() {
        BankDepositRateExample bankDepositRateExample = new BankDepositRateExample();
        bankDepositRateExample.setOrderByClause("update_date desc");
        List<BankDepositRate> bankDepositRates = bankDepositRateMapper.selectByExample(bankDepositRateExample);
        if (bankDepositRates == null || bankDepositRates.size() == 0) {
            return BankResult.build(400, "查询失败");
        }
        return BankResult.build(200, "查询成功", bankDepositRates.get(0));
    }
}

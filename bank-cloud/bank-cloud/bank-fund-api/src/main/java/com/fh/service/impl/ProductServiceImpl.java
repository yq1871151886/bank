package com.fh.service.impl;

import com.fh.beans.BankFundHold;
import com.fh.beans.BankFundLog;
import com.fh.beans.BankFundProduct;
import com.fh.beans.BankUser;
import com.fh.dao.FundHoldDao;
import com.fh.dao.FundLogDao;
import com.fh.dao.ProductDao;
import com.fh.service.ProductService;
import com.fh.utils.PageBean;
import com.fh.utils.UtilsTools;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductDao productDao;
    @Autowired
    private FundHoldDao fundHoldDao;
    @Autowired
    private FundLogDao fundLogDao;

    @Override
    public void insertProduct(BankFundProduct product) {
        productDao.insert(product);
    }

    @Override
    public PageBean selectProductAll(PageBean pageBean, BankFundProduct product) {
       pageBean.setData(productDao.selectProductAll(pageBean,product));
       pageBean.setRecordsTotal(productDao.selectProductCount(product));
       pageBean.setRecordsFiltered(productDao.selectProductCount(product));
        return pageBean ;
    }

    @Override
    public BankFundProduct selectProductById(String id) {
        return productDao.selectProductById(id);

    }

    @Override
    public void productSubscribe(String cust_id,String account,Double share,BankUser bankUser, BankFundProduct bankFundProduct) {
        BankFundHold bankFundHold = new BankFundHold();
        bankFundHold.setCustId(cust_id);
        bankFundHold.setShare(share);
        bankFundHold.setAccount(account);
        bankFundHold.setFundId(bankFundProduct.getFundId());
        fundHoldDao.insertfundHold(bankFundHold);
        BankFundLog bankFundLog = new BankFundLog();
        bankFundLog.setAccount(account);
        bankFundLog.setCustId(cust_id);
        bankFundLog.setFundId(bankFundProduct.getFundId());
        bankFundLog.setType(bankFundProduct.getType());
        bankFundLog.setTxDate(new Date().toString());
        bankFundLog.setReviewId(bankUser.getUserId());
        bankFundLog.setFundTxId(UtilsTools.getOrderId());
        fundLogDao.insertBankFundLog(bankFundLog);

    }
}

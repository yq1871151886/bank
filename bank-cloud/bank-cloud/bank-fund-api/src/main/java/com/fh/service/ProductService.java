package com.fh.service;

import com.fh.beans.BankFundProduct;
import com.fh.beans.BankUser;
import com.fh.utils.PageBean;

import java.util.List;

public interface ProductService {
    void insertProduct(BankFundProduct product);

    PageBean selectProductAll(PageBean pageBean, BankFundProduct product);

    BankFundProduct selectProductById(String id);

    void productSubscribe(String cust_id,String account,Double share,BankUser bankUser, BankFundProduct bankFundProduct);
}

package com.fh.controller;

import com.fh.beans.BankFundProduct;
import com.fh.beans.BankUser;
import com.fh.enumbean.ResponseServer;
import com.fh.service.ProductService;
import com.fh.utils.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("/productController")
public class ProductController {
    @Autowired
    private ProductService productService;
    /**
     * 增加基金
     * 需要传参 BankFundProduct
     */
   @RequestMapping("insertProduct")
    public ResponseServer insertProduct(BankFundProduct product){
        productService.insertProduct(product);
        return ResponseServer.success();
    }

    /**
     * 基金申购
     * 需要传参 账户号account,申购份额share,基金产品的id
     */
    @RequestMapping("productSubscribe")
        public ResponseServer productSubscribe(String cust_id,String account,Double share,HttpServletRequest request,BankFundProduct bankFundProduct){
        BankUser bankUser = (BankUser) request.getAttribute("user");
        productService.productSubscribe(cust_id,account,share,bankUser,bankFundProduct);
        return ResponseServer.success();
    }

    /**
     * 基金赎回
     */
    @RequestMapping("fundRansom")
    public ResponseServer fundRansom(){
        return ResponseServer.success();
    }

    /*
    * *查询所有的基金
    * 需要传参 分页工具bean
     */
    @RequestMapping("selectProductAll")
    public ResponseServer selectProductAll(PageBean pageBean,BankFundProduct product){
       pageBean =  productService.selectProductAll(pageBean,product);
        return ResponseServer.success(pageBean);
    }

    /**
     * 根据Id查询基金
     * 需要传参 基金Id
     */
    @RequestMapping("selectProductById")
    public ResponseServer selectProductById(String id){
        BankFundProduct product =  productService.selectProductById(id);
        return ResponseServer.success(product);
    }

}

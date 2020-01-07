package com.fh.controller;

import com.fh.beans.BankAccount;
import com.fh.enumbean.ResponseEnum;
import com.fh.enumbean.ResponseServer;
import com.fh.service.IAccountService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/account")
public class BankAccounController {



      private IAccountService iaccountService;


      // 新建一个账户（已测试）
      public ResponseServer addAccount(@RequestParam(value = "custName") String custName, BankAccount account) {
            System.out.println(custName);
            System.out.println(account.toString());
            //account_status没设置，balances两个没设置
            boolean success = iaccountService.add(custName, account);
            if (success) {
                  return ResponseServer.success();
            } else {
                  return ResponseServer.error(ResponseEnum.CHUANGJIANZHANGHU_ERROR);
            }
      }


      // 删除一个账户（已测试）
      @RequestMapping(value = "/account/delete", method = RequestMethod.POST)
      public ResponseServer deleteAccount(@RequestParam(value = "account") String account) {
            boolean success = iaccountService.delete(account);
            if (success) {
                  return ResponseServer.success();
            } else {
                  return ResponseServer.error(ResponseEnum.SHANCHUZHANGHU_ERROR);
            }
      }


      // 返回该id的客户所有账户信息（返回中文乱码）
      @RequestMapping(value = "/account/{custId}", method = RequestMethod.GET)
      @ResponseBody
      public ResponseServer getAccounts(@PathVariable String custId) {
            List<BankAccount> accountList = iaccountService.getAccounts(custId);
            return  ResponseServer.success(accountList);
      }






}

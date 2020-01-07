package com.fh.beans;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

@TableName("bank_account")
public class BankAccount {

    @TableId(value = "account")
    private String account;

    @TableField("cust_id")
    private String custId;

    @TableField("deposit_bank")
    private String depositBank;

    @TableField("balances")
    private Double balances;

    @TableField("blocked_balances")
    private Double blockedBalances;

    @TableField("open_date")
    private String openDate;

    @TableField("cancel_date")
    private String cancelDate;

    @TableField("account_kind")
    private String accountKind;

    @TableField("account_type")
    private String accountType;

    @TableField("account_status")
    private String accountStatus;

    @TableField("password")
    private String password;

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account == null ? null : account.trim();
    }

    public String getCustId() {
        return custId;
    }

    public void setCustId(String custId) {
        this.custId = custId == null ? null : custId.trim();
    }

    public String getDepositBank() {
        return depositBank;
    }

    public void setDepositBank(String depositBank) {
        this.depositBank = depositBank == null ? null : depositBank.trim();
    }

    public Double getBalances() {
        return balances;
    }

    public void setBalances(Double balances) {
        this.balances = balances;
    }

    public Double getBlockedBalances() {
        return blockedBalances;
    }

    public void setBlockedBalances(Double blockedBalances) {
        this.blockedBalances = blockedBalances;
    }

    public String getOpenDate() {
        return openDate;
    }

    public void setOpenDate(String openDate) {
        this.openDate = openDate == null ? null : openDate.trim();
    }

    public String getCancelDate() {
        return cancelDate;
    }

    public void setCancelDate(String cancelDate) {
        this.cancelDate = cancelDate == null ? null : cancelDate.trim();
    }

    public String getAccountKind() {
        return accountKind;
    }

    public void setAccountKind(String accountKind) {
        this.accountKind = accountKind == null ? null : accountKind.trim();
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType == null ? null : accountType.trim();
    }

    public String getAccountStatus() {
        return accountStatus;
    }

    public void setAccountStatus(String accountStatus) {
        this.accountStatus = accountStatus == null ? null : accountStatus.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }
}
package com.fh.service;

import com.fh.beans.BankUser;

public interface IUserService {
    void delete(BankUser bankUser);

    BankUser getUser(String username);

    boolean isExist(String userName);

    void add(BankUser bankUser);

    void update(BankUser user);

    boolean changepassword(String username, String oldpassword, String newpassword);
}

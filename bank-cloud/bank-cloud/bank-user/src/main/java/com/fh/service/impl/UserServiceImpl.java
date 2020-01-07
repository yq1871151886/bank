package com.fh.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.fh.beans.BankUser;
import com.fh.mapper.UserMapper;
import com.fh.service.IUserService;
import com.fh.utils.MD5Util;
import com.fh.utils.UtilsTools;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sun.net.www.protocol.http.HttpURLConnection;

@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public void delete(BankUser bankUser) {
        QueryWrapper<BankUser> queryWrapper = new QueryWrapper<BankUser>();
        queryWrapper.eq("user_id",bankUser.getUserId());
        userMapper.delete(queryWrapper);
    }

    @Override
    public BankUser getUser(String username) {
        BankUser bankUser = getUserByName(username);
        return bankUser;
    }

    @Override
    public boolean isExist(String userName) {
        BankUser bankUser = getUserByName(userName);
        if(bankUser!=null){
            return true;
        }else {
            return false;
        }
    }

    @Override
    public void add(BankUser bankUser) {
        bankUser.setUserId(UtilsTools.getSnowId());
        bankUser.setPassword(MD5Util.getMD5(bankUser.getPassword()));
        userMapper.insert(bankUser);
    }

    @Override
    public void update(BankUser user) {
       userMapper.updateUserById(user);
    }

    @Override
    public boolean changepassword(String username, String oldpassword, String newpassword) {
        BankUser bankUser = getUserByName(username);
        if(MD5Util.getMD5(oldpassword).equals(bankUser.getPassword())){
            bankUser.setPassword(MD5Util.getMD5(newpassword));
            userMapper.updateUserById(bankUser);
            return true;
        }
        return false;
    }

    public BankUser getUserByName(String username){
        QueryWrapper<BankUser> queryWrapper=new QueryWrapper<BankUser>();
        queryWrapper.eq("user_name",username);
        BankUser bankUser = userMapper.selectOne(queryWrapper);
        return bankUser;
    }
}

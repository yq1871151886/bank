package com.fh.controller;

import com.fh.beans.BankUser;

import com.fh.eum.ResponseEnum;
import com.fh.eum.ResponseServer;
import com.fh.jwt.JwtUtils;
import com.fh.service.IUserService;
import com.fh.utils.MD5Util;
import freemarker.template.utility.StringUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/user")
@CrossOrigin(origins = "http:/localhost:8080")
public class UserController {

    @Autowired
    private IUserService userService;


    //用户删除方法
    @DeleteMapping
    public ResponseServer delete(String username){
        BankUser bankUser=userService.getUser(username);
        if(bankUser == null){
            System.out.println("该用户不存在");
            return ResponseServer.error(ResponseEnum.GET_USER_ERROT);
        }else {
            userService.delete(bankUser);
            System.out.println("删除用户成功");
            return ResponseServer.success(ResponseEnum.DELETE_USER_SUCCESS);
        }

    }

    //用户登录
    @PostMapping(value = "/login")
    public ResponseServer login(String username,String password){
        if(StringUtils.isBlank(username) || StringUtils.isBlank(password)){
           return ResponseServer.error(ResponseEnum.USERNAME_OR_PASSWORD_ISNULL);
        }else {
            BankUser user = userService.getUser(username);
            if(user==null){
               return ResponseServer.error(ResponseEnum.GET_USER_ERROT);
            }else {
                if(MD5Util.getMD5(password).equals(user.getPassword())){
                    Map<String,Object> map=new HashMap<String, Object>();
                    map.put("username",user.getUserName());
                    String token = JwtUtils.createToken(map);
                    return ResponseServer.success(token);
                }else {
                    return ResponseServer.error(ResponseEnum.PASSWORD_ERROR);
                }
            }
        }
    }

    //用户注册
    @PutMapping()
    public ResponseServer register(BankUser bankUser){
       boolean exist= userService.isExist(bankUser.getUserName());
       if(exist){
           return ResponseServer.error(ResponseEnum.USER_ISEXIST);
       }else {
           userService.add(bankUser);
           return ResponseServer.success(ResponseEnum.ADD_USER_SUCCESS);
       }
    }

    //修改用户信息
    @PostMapping(value = "update")
    public ResponseServer changeinfo(BankUser user){
       userService.update(user);
       return ResponseServer.success(ResponseEnum.UPDATE_USER_SUCCESS);
    }

    //修改用户密码
    @PostMapping(value = "updatepassword")
    public ResponseServer changepassword(String username,String oldpassword,String newpassword){
       boolean success= userService.changepassword(username,oldpassword,newpassword);
        return ResponseServer.success(ResponseEnum.UPDATE_PASSWORD_SUCCESS);
    }

}

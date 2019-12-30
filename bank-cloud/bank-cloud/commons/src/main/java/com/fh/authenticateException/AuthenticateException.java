package com.fh.authenticateException;


import com.fh.enumbean.ResponseEnum;

public class AuthenticateException extends RuntimeException{



    private Integer code;
    public AuthenticateException(ResponseEnum loginEnum) {
        super(loginEnum.getMessage());
        this.code=loginEnum.getCode();
    }

    public Integer getCode() {
        return code;
    }
}

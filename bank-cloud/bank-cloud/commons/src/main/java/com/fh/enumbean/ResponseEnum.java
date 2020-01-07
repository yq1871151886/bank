package com.fh.enumbean;

public enum ResponseEnum {
    NAME_PWD_ERROR(501,"用户名或密码不存在")
    ,USER_ISNULL(503,"用户不存在")
    ,USER_PWD_ERROR(502,"密码错误")
    ,LOGIN_SUCCESS(200,"登录成功")
    ,IMG__SUCCESS(600,"上传成功")
    ,ERROR(500,"错误")
    ,LOGIN_NOTPOWER(504,"用户没有权限")
    ,LOGIN_SIVALID(505,"用户失效")
    ,REGISTER_NAMEPWDERROR(506,"用户名或密码不能为空")
    ,REGISTER_NAMEERROR(507,"用户名已存在")
    ,IMG_MORE_MAX(508,"当前图片过大")
    ,IMG_LAYOUT(507,"图片格式不对")
    ,IMG_UPLOAD_ERROR(509,"上传错误")
    ,LOGIN_TOKEN_INVALID(513,"token失效了")
    ,LOGIN_TOKEN_LOSE(514,"token解析失败")
    ,LOGIN_CONTENT_LONG(516,"服务器连接超时异常")
    ,LOGIN_SERVER_BUSYNESS(516,"服务器错误")
    ,MAKE_SUCCESS(200,"操作成功")


    ,CUSTOMER_ADD_SUCCESS(200,"新增用户成功")
    ,CUSTOMER_DELETE_SUCCESS(200,"删除用户成功")
    ,DATE_TABLE_ERROR(400,"数据表查询异常")
    ;


    private Integer code;
    private String message;

    private ResponseEnum(Integer code, String message) {
        this.code=code;
        this.message=message;
    }

    public Integer getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
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


    ,REMIT_CUSTOMER_NAME_ERROR(400,"用户姓名不匹配！")
    ,REMIT_CUSTOMER_PHONE_ERROR(400,"用户电话不匹配！")
    ,REMIT_OUTACCOUNT_ISBLANK_ERROR(400,"汇款账户不存在！")
    ,REMIT_ACCOUNT_PWD_ERROR(400,"密码错误！")
    ,REMIT_INACCOUNT_NAME_ERROR(400,"提款账户不存在！")
    ,REMIT_OUTACCOUNT_BALANCE_NONE_ERROR(400,"汇款账户余额不足！")
    ,REMIT_ISBLANK_ERROR(400,"汇票不存在！")
    ,REMIT_INACCOUNT_is_ERROR(400,"提款账户不匹配！")
    ,REMIT_EXTRACTED_ERROR(400,"汇款已被提取！")
    ,REMIT_INSUFFICIENT_REPAYMENT_BALANCE(400,"还款金额超过账户余额")
    ,REMIT_ID_NUMBER_ERROR(400,"身份证号不正确")
    ,REMIT_NAME_ACCOUNT_ERROR(400,"姓名与账户不匹配")
    ,REMIT_REPAYMENT_ERROR(400,"还款金额不合法")
    ,REQUEST_ERROR(400,"请求错误")
    ,LOAN_NUMBER_NOT_EXIT(400,"贷款交易号不存在，请检查输入正确性")
    ,CHUANGJIANZHANGHU_ERROR(700,"创建账户失败")
    ,SHANCHUZHANGHU_ERROR(701,"创建账户失败")

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

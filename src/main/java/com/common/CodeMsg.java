package com.common;

/**
 * @Description: 业务码 业务消息枚举
 * @author: 
 */
public enum CodeMsg {

    SUCCESS(0,"操作成功"),
    ERROR(110,"程序员送外卖了!"),
    VALIDATION_ERROR(4000001,"数据校验异常"),


    LOGIN_CODE_ERROR(4001001,"验证码错误!"),
    LOGIN_USER_PASSWORD_ERROR(4001002,"用户名或者密码错误!"),


    ;

    public  Integer code;//业务码
    public  String msg;//业务消息

    CodeMsg(Integer code,String msg){
        this.code = code;
        this.msg = msg;
    }
}

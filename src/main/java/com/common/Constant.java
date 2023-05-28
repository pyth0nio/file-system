package com.common;

/**
 * @Description: 常量接口
 * @author: Mr.T
 * @date 2020-11-30 11:54
 */
public interface Constant {

    String DEFAULT_PASSWORD = "123456";

    /**
     *  有效
     */
    Integer DELETED_VALID = 1;
    /**
     * 无效
     */
    Integer DELETED_INVALID = 2;

    /**
     * 当前用户 session 的key
     */
    String CURRENT_USER = "user";
    /**
     * 当前验证码 session 的key
     */
    String CURRENT_CODE = "code";
}

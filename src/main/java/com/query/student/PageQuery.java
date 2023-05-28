package com.query.student;

import com.query.Query;
import lombok.Data;

/**
 * @author: 
 * @date: 2023-04-13
 */
@Data
public class PageQuery extends Query {

    /**
     * 班级ID
     */
    private Integer clId;

    /**
     * 姓名
     */
    private String realname;

    /**
     * 登录账号
     */
    private String username;
}

package com.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author: 
 * @date: 2023-04-12
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "student")
public class Student {
    /**
     * 学生id
     */
    @TableId(value = "st_id", type = IdType.AUTO)
    private Integer stId;

    /**
     * 学生账号
     */
    @TableField(value = "username")
    private String username;

    /**
     * 学生密码
     */
    @TableField(value = "`password`")
    private String password;

    /**
     * 学生姓名
     */
    @TableField(value = "realname")
    private String realname;

    /**
     * 学生性别
     */
    @TableField(value = "sex")
    private String sex;

    /**
     * 学生生日
     */
    @TableField(value = "birth")
    private String birth;

    /**
     * 班级ID
     */
    @TableField(value = "cl_id")
    private Integer clId;

    /**
     * 创建时间
     */
    @TableField(value = "create_time")
    private Date createTime;

    /**
     * 修改时间
     */
    @TableField(value = "update_time")
    private Date updateTime;
}
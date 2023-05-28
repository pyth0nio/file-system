package com.vo.student;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

/**
 * 描述:
 * 时间: 2023-04-17 23-04
 */
@Data
public class StudentInfoVO {

    /**
     * 学生id
     */
    private Integer stId;

    /**
     * 学生账号
     */
    private String username;

    /**
     * 学生密码
     */
    private String password;

    /**
     * 学生姓名
     */
    private String realname;

    /**
     * 学生性别
     */
    private String sex;

    /**
     * 学生生日
     */
    private String birth;

    /**
     * 班级ID
     */
    private Integer clId;

    /**
     * 班级名称
     */
    private String clName;

    /**
     * 创建时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
    private Date createTime;

    /**
     * 修改时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
    private Date updateTime;
}

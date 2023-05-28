package com.dto.user;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * @author: 
 * @date: 2023-04-17
 */

@Data
public class EditDTO {


    /**
     * 学生id
     */
    @NotNull(message = "学生ID不能为空")
    private Integer stId;

    /**
     * 学生账号
     */
    @NotBlank(message = "学生账号不能为空")
    @Length(max = 16,message = "学生账号最多16个字符")
    private String username;

    /**
     * 学生密码
     */
    private String password;

    /**
     * 学生姓名
     */
    @NotBlank(message = "学生姓名不能为空")
    @Length(max = 16,message = "学生姓名最多16个字符")
    private String realname;

    /**
     * 学生性别
     */
    @NotBlank(message = "学生姓名不能为空")
    @Length(max = 16,message = "学生姓名最多16个字符")
    private String sex;

    /**
     * 学生生日
     */
    @NotBlank(message = "学生生日不能为空")
    private String birth;

    /**
     * 班级ID
     */
    @NotNull(message = "班级ID不能为空")
    private Integer clId;



}

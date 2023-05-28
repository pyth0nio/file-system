package com.dto.user;

import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * @author: 
 * @date: 2023-04-12
 */
@Data
public class LoginDTO {

    @NotBlank(message = "用户名不能为空")
    private String username;

    @NotBlank(message = "密码不能为空")
    private String password;

    @NotBlank(message = "验证码不能为空")
    private String code;
}

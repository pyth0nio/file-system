package com.dto.classes;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;

/**
 * 描述:
 * 时间: 2023-04-17 00-52
 */
@Data
public class AddDTO {

    @NotBlank(message = "班级名称不能为空")
    @Length(max = 10,message = "班级名称最多10个字符")
    private String clName;
}

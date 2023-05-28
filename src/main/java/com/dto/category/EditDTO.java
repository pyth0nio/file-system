package com.dto.category;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * @author: 
 * @date: 2023-04-18
 */
@Data
public class EditDTO {

    @NotNull(message = "类别ID不能为空")
    private String cgId;


    /**
     * 类别名称
     */
    @NotBlank(message = "类别名称不能为空")
    private String cgName;
}

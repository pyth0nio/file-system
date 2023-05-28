package com.dto.category;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * @author: 
 * @date: 2023-04-18
 */
@Data
public class AddDTO {

    /**
     * 类别名称
     */
    @NotBlank(message = "类别名称不能为空")
    private String cgName;
}

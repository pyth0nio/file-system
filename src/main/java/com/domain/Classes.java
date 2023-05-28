package com.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author: 王 博
 * @date: 2023-04-12
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "classes")
public class Classes {
    /**
     * 班级ID
     */
    @TableId(value = "cl_id", type = IdType.AUTO)
    private Integer clId;

    /**
     * 班级名称
     */
    @TableField(value = "cl_name")
    private String clName;

    /**
     * 创建时间
     */
    @TableField(value = "create_time")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm",timezone = "GMT+8")
    private Date createTime;

    /**
     * 修改时间
     */
    @TableField(value = "update_time")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm",timezone = "GMT+8")
    private Date updateTime;
}
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
@TableName(value = "file")
public class File {
    /**
     * 文件ID
     */
    @TableId(value = "file_id", type = IdType.AUTO)
    private Integer fileId;

    /**
     * 文件名称
     */
    @TableField(value = "file_name")
    private String fileName;

    /**
     * url
     */
    @TableField(value = "url")
    private String url;

    /**
     * 预览url
     */
    @TableField(value = "pre_url")
    private String preUrl;

    /**
     * 扩展名称
     */
    @TableField(value = "ext_name")
    private String extName;

    /**
     * 大小
     */
    @TableField(value = "`size`")
    private Integer size;

    /**
     * 关键字
     */
    @TableField(value = "keywords")
    private String keywords;

    /**
     * md5字符串
     */
    @TableField(value = "md5")
    private String md5;

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

    @TableField(value = "st_id")
    private Integer stId;

    @TableField(value = "cl_id")
    private Integer clId;

    @TableField(value = "cg_id")
    private Integer cgId;
}
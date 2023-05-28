package com.vo.file;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.util.Date;

/**
 * @author: 
 * @date: 2023-04-18
 */
@Data
public class FileInfoVO {

    /**
     * 文件ID
     */
    private Integer fileId;

    /**
     * 文件名称
     */
    private String fileName;

    /**
     * url
     */
    private String url;

    /**
     * 预览url
     */
    private String preUrl;

    /**
     * 扩展名称
     */
    private String extName;

    /**
     * 大小
     */
    private Integer size;

    /**
     * 关键字
     */
    private String keywords;

    /**
     * md5字符串
     */
    private String md5;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 修改时间
     */
    private Date updateTime;

    private Integer stId;

    private Integer clId;

    private Integer cgId;

    private String realname;

    private String cgName;

    private String clName;
}

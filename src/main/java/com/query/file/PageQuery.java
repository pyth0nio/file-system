package com.query.file;

import com.baomidou.mybatisplus.annotation.TableField;
import com.query.Query;
import lombok.Data;

/**
 * @author: 
 * @date: 2023-04-18
 */
@Data
public class PageQuery  extends Query {

    private String cgName;
    private String fileName;
    private Integer clId;
    private String stName;
    private String keywords;

}

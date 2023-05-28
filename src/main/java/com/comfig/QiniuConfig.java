package com.comfig;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author: 
 * @date: 2023-04-18
 */
@ConfigurationProperties(prefix = "qiniu")
@Component
@Data
public class QiniuConfig {

    private String  ak ;

    private String  sk ;

    private String bucket;

    private String domain;

}

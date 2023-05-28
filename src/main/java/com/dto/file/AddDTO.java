package com.dto.file;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author: 
 * @date: 2023-04-18
 */
@Data
public class AddDTO {

    private Integer cgId;

    private String keywords;

    private MultipartFile file;
}

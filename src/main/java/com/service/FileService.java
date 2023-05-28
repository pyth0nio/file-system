package com.service;

import com.common.Result;
import com.domain.File;
import com.baomidou.mybatisplus.extension.service.IService;
import com.dto.file.AddDTO;
import com.query.file.PageQuery;

/**
 * @author: 
 * @date: 2023-04-12
 */
public interface FileService extends IService<File>{


    Result queryPage(PageQuery pageQuery);

    Result add(AddDTO dto);
}

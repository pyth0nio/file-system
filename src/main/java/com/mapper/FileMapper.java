package com.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.domain.File;
import com.query.file.PageQuery;

import java.util.List;

/**
 * @author: 
 * @date: 2023-04-12
 */
public interface FileMapper extends BaseMapper<File> {
    List<File> selectFileInfoList(PageQuery pageQuery);
}
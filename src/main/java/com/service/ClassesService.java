package com.service;

import com.common.Result;
import com.domain.Classes;
import com.baomidou.mybatisplus.extension.service.IService;
import com.dto.classes.AddDTO;
import com.dto.classes.EditDTO;
import com.query.classes.PageQuery;

/**
 * @author: 
 * @date: 2023-04-12
 */
public interface ClassesService extends IService<Classes>{

    /**
     *  分页查询数据
     * @param pageQuery
     * @return
     */
    Result queryPage(PageQuery pageQuery);

    /**
     * 新增班级
     * @param addDTO
     * @return
     */
    Result add(AddDTO addDTO);

    Result edit(EditDTO editDTO);

    /**
     * 查询所有的班级
     * @return
     */
    Result queryList();
}

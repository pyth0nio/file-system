package com.service;

import com.common.Result;
import com.domain.Category;
import com.baomidou.mybatisplus.extension.service.IService;
import com.dto.category.AddDTO;
import com.dto.category.EditDTO;
import com.query.category.PageQuery;

/**
 * @author: 
 * @date: 2023-04-12
 */
public interface CategoryService extends IService<Category> {


    Result queryPage(PageQuery pageQuery);

    Result queryList();

    Result add(AddDTO addDTO);

    Result edit(EditDTO editDTO);
}

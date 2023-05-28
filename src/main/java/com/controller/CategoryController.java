package com.controller;

import com.common.Result;
import com.dto.category.AddDTO;
import com.dto.category.EditDTO;
import com.query.category.PageQuery;
import com.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: 
 * @date: 2023-04-18
 */
@RestController
@RequestMapping("category")
public class CategoryController {



    @Autowired
    private CategoryService service;

    /**
     *  返回 查询分页数据
     * @param pageQuery
     * @return
     */
    @GetMapping("page")
    public Result page(PageQuery pageQuery) {
        return service.queryPage(pageQuery);
    }

    @GetMapping("list")
    public Result list() {
        return service.queryList();
    }

    @PostMapping("add")
    public Result add(@Validated AddDTO addDTO) {
        return service.add(addDTO);
    }

    @PostMapping("edit")
    public Result add(@Validated EditDTO editDTO) {
        return service.edit(editDTO);
    }

    @GetMapping("delete")
    public Result delete(Integer clId) {
        service.removeById(clId);
        return  new Result();
    }
}

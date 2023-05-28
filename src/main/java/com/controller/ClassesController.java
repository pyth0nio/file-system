package com.controller;

import com.common.Result;
import com.domain.Classes;
import com.dto.classes.AddDTO;
import com.dto.classes.EditDTO;
import com.query.classes.PageQuery;
import com.service.ClassesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: 
 * @date: 2023-04-13
 */
@RestController
@RequestMapping("classes")
public class ClassesController {

    @Autowired
    private ClassesService service;

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
    public Result add(@Validated  AddDTO addDTO) {
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

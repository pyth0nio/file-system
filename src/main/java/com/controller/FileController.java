package com.controller;

import com.common.Result;
import com.dto.file.AddDTO;
import com.query.file.PageQuery;
import com.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 *  文件管理
 * @author: 
 * @date: 2023-04-18
 */
@RestController
@RequestMapping("file")
public class FileController {

    @Autowired
    private FileService service;

    @GetMapping("page")
    public Result page(PageQuery pageQuery) {
        return service.queryPage(pageQuery);
    }


    @PostMapping ("add")
    public Result add(@Validated  AddDTO dto) {
        return service.add(dto);
    }

    @GetMapping ("delete")
    public Result delete(Integer fileId) {
        service.removeById(fileId);
        return new Result();
    }
}

package com.controller;

import cn.hutool.captcha.CaptchaUtil;
import cn.hutool.captcha.GifCaptcha;
import cn.hutool.core.util.StrUtil;
import com.common.CodeMsg;
import com.common.Result;
import com.dto.user.AddDTO;
import com.dto.user.EditDTO;
import com.dto.user.LoginDTO;
import com.query.student.PageQuery;
import com.service.StudentService;
import com.util.WebUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author: 
 * @date: 2023-04-12
 */
@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    private StudentService service;


    @GetMapping("code")
    public void code(HttpServletResponse  response) throws IOException {
        GifCaptcha gifCaptcha = CaptchaUtil.createGifCaptcha(115, 43, 4);
        // 获取验证码
        String code = gifCaptcha.getCode();
        // 将验证码放入session
        WebUtil.saveCode(code);
        ServletOutputStream outputStream = response.getOutputStream();
        gifCaptcha.write(outputStream);
    }


    @PostMapping("login")
    public Result login(@Validated LoginDTO loginDTO){
        String code = WebUtil.getCode();
        if (!StrUtil.equalsIgnoreCase(code,loginDTO.getCode())){
            return new Result(CodeMsg.LOGIN_CODE_ERROR);
        }
        return service.login(loginDTO);
    }

    /**
     *  分页查询学生信息
     * @param query
     * @return
     */
    @GetMapping("page")
    public Result page(PageQuery query){
        return service.queryPage(query);
    }


    /**
     *  新增
     * @param dto
     * @return
     */
    @PostMapping("add")
    public Result add(@Validated AddDTO dto){
        return service.add(dto);
    }

    /**
     * 修改
     * @param dto
     * @return
     */
    @PostMapping("edit")
    public Result edit(@Validated EditDTO dto){
        return service.edit(dto);
    }

    @GetMapping("delete")
    public Result delete(Integer stId){
        return service.delete(stId);
    }
}

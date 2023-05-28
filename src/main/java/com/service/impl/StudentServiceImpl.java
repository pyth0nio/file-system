package com.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.common.CodeMsg;
import com.common.PageInfo;
import com.common.Result;
import com.domain.Classes;
import com.dto.user.AddDTO;
import com.dto.user.EditDTO;
import com.dto.user.LoginDTO;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.query.student.PageQuery;
import com.util.WebUtil;
import com.vo.student.StudentInfoVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.domain.Student;
import com.mapper.StudentMapper;
import com.service.StudentService;

import java.util.List;

/**
 * @author: 刘博
 * @date: 2023-04-12
 */
@Service
public class StudentServiceImpl extends ServiceImpl<StudentMapper, Student> implements StudentService{

    @Autowired
    private StudentMapper studentMapper;

    @Override
    public Result login(LoginDTO dto) {
        LambdaQueryWrapper<Student> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(Student::getUsername,dto.getUsername()).eq(Student::getPassword,dto.getPassword());
        Student student = studentMapper.selectOne(queryWrapper);
        if (student == null) {
            return new Result(CodeMsg.LOGIN_USER_PASSWORD_ERROR);
        }
        student.setPassword(null);
        WebUtil.saveUser(student);
        return new Result(student);
    }


    @Override
    public Result queryPage(PageQuery query) {
        Page<StudentInfoVO> page = PageHelper.startPage(query.getPage(), query.getLimit());
        studentMapper.selectStudentInfo(query);
        return new Result(new PageInfo(page));
    }


    @Override
    public Result add(AddDTO dto) {
        // 校验账号合法性
        LambdaQueryWrapper<Student> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(Student::getUsername,dto.getUsername());
        Student student = studentMapper.selectOne(queryWrapper);
        if (student != null){
            return new Result(5000001,"用户名已经存在");
        }
        student = BeanUtil.copyProperties(dto, Student.class);
        studentMapper.insert(student);
        return new Result();
    }


    @Override
    public Result edit(EditDTO dto) {
        // 校验账号合法性
        LambdaQueryWrapper<Student> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(Student::getUsername,dto.getUsername());
        Student student = studentMapper.selectOne(queryWrapper);
        if (student != null && !student.getStId().equals(dto.getStId())){
            return new Result(5000001,"用户名已经存在");
        }
        student = BeanUtil.copyProperties(dto, Student.class);
        studentMapper.updateById(student);
        return new Result();
    }


    @Override
    public Result delete(Integer stId) {
        studentMapper.deleteById(stId);
        return new Result();
    }
}

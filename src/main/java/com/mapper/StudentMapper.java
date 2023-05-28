package com.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.domain.Student;
import com.query.student.PageQuery;
import com.vo.student.StudentInfoVO;

import java.util.List;

/**
 * @author: 
 * @date: 2023-04-12
 */
public interface StudentMapper extends BaseMapper<Student> {


    List<StudentInfoVO> selectStudentInfo(PageQuery query);
}
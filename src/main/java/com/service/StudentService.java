package com.service;

import com.common.Result;
import com.domain.Student;
import com.baomidou.mybatisplus.extension.service.IService;
import com.dto.user.AddDTO;
import com.dto.user.EditDTO;
import com.dto.user.LoginDTO;
import com.query.student.PageQuery;

/**
 * @author: 
 * @date: 2023-04-12
 */
public interface StudentService extends IService<Student>{

    /**
     *  登录业务方法
     * @param dto
     * @return
     */
    Result login(LoginDTO dto);

    
    Result queryPage(PageQuery query);

    Result add(AddDTO dto);

    Result edit(EditDTO dto);

    Result delete(Integer stId);
}

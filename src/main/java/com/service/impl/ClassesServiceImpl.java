package com.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.common.PageInfo;
import com.common.Result;
import com.dto.classes.AddDTO;
import com.dto.classes.EditDTO;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.query.classes.PageQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mapper.ClassesMapper;
import com.domain.Classes;
import com.service.ClassesService;
/**
 * @author: 刘博
 * @date: 2023-04-12
 */
@Service
public class ClassesServiceImpl extends ServiceImpl<ClassesMapper, Classes> implements ClassesService{

    @Autowired
    private ClassesMapper classesMapper;

    @Override
    public Result queryPage(PageQuery pageQuery) {
        Page<Classes> page = PageHelper.startPage(pageQuery.getPage(), pageQuery.getLimit());
        LambdaQueryWrapper<Classes> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.like(StrUtil.isNotBlank(pageQuery.getClName()),Classes::getClName,pageQuery.getClName());
        classesMapper.selectList(queryWrapper);
        return new Result(new PageInfo(page));
    }

    @Override
    public Result add(AddDTO addDTO) {
        Classes classes = BeanUtil.copyProperties(addDTO, Classes.class);
        super.save(classes);
        return new Result();
    }

    @Override
    public Result edit(EditDTO editDTO) {
        Classes classes = BeanUtil.copyProperties(editDTO, Classes.class);
        super.updateById(classes);
        return new Result();
    }

    @Override
    public Result queryList() {
        List<Classes> classes = classesMapper.selectList(null);
        return new Result(classes);
    }
}

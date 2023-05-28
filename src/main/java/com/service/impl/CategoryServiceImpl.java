package com.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.common.PageInfo;
import com.common.Result;
import com.domain.Classes;
import com.dto.category.AddDTO;
import com.dto.category.EditDTO;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.query.category.PageQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.domain.Category;
import com.mapper.CategoryMapper;
import com.service.CategoryService;
/**
 * @author: 刘博
 * @date: 2023-04-12
 */
@Service
public class CategoryServiceImpl extends ServiceImpl<CategoryMapper, Category> implements CategoryService{

    @Autowired
    private CategoryMapper  categoryMapper;

    @Override
    public Result queryPage(PageQuery pageQuery) {
        Page<Category> page = PageHelper.startPage(pageQuery.getPage(), pageQuery.getLimit());
        LambdaQueryWrapper<Category> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.like(StrUtil.isNotBlank(pageQuery.getCgName()),Category::getCgName,pageQuery.getCgName());
        categoryMapper.selectList(queryWrapper);
        return new Result(new PageInfo(page));
    }

    @Override
    public Result queryList() {
        List<Category> categories = categoryMapper.selectList(null);
        return new Result(categories);
    }

    @Override
    public Result add(AddDTO addDTO) {
        Category bean = BeanUtil.copyProperties(addDTO, Category.class);
        super.save(bean);
        return new Result();
    }

    @Override
    public Result edit(EditDTO editDTO) {
        Category bean = BeanUtil.copyProperties(editDTO, Category.class);
        super.updateById(bean);
        return new Result();
    }
}

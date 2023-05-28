package com.service.impl;

import cn.hutool.core.io.FileUtil;
import com.comfig.QiniuConfig;
import com.common.PageInfo;
import com.common.Result;
import com.domain.Student;
import com.dto.file.AddDTO;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.qiniu.common.QiniuException;
import com.qiniu.http.Response;
import com.qiniu.storage.Configuration;
import com.qiniu.storage.Region;
import com.qiniu.storage.UploadManager;
import com.qiniu.storage.model.DefaultPutRet;
import com.qiniu.util.Auth;
import com.query.file.PageQuery;
import com.util.WebUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.domain.File;
import com.mapper.FileMapper;
import com.service.FileService;
import oshi.driver.mac.net.NetStat;

/**
 * @author: 刘博
 * @date: 2023-04-12
 */
@Service
public class FileServiceImpl extends ServiceImpl<FileMapper, File> implements FileService{

    @Autowired
    private QiniuConfig qiniuConfig;

    @Autowired
    private FileMapper mapper;

    @Override
    public Result queryPage(PageQuery pageQuery) {
        Page<File> page = PageHelper.startPage(pageQuery.getPage(), pageQuery.getLimit());
        mapper.selectFileInfoList(pageQuery);
        return new Result(new PageInfo(page));
    }

    @Override
    public Result add(AddDTO dto)  {

        String fileName = dto.getFile().getOriginalFilename();
        String extName = FileUtil.extName(fileName);
        long size = dto.getFile().getSize();
        // 获取 用户
        Student user = WebUtil.getUser();
        if (user == null) {
            return new Result(50002,"登录失效,请登录");
        }
        Auth auth = Auth.create(qiniuConfig.getAk(), qiniuConfig.getSk());
        String key = user.getStId() + "/" + fileName;
        String upToken = auth.uploadToken(qiniuConfig.getBucket(),key);


        //构造一个带指定 Region 对象的配置类
        Configuration cfg = new Configuration();//注意区域要和自己的bucket一样
        //cfg.resumableUploadAPIVersion = Configuration.ResumableUploadAPIVersion.V2;// 指定分片上传版本
        UploadManager uploadManager = new UploadManager(cfg);
        try {
            Response response = uploadManager.put(dto.getFile().getInputStream(), key , upToken,null,null);
            String json = response.bodyString();
            ObjectMapper objectMapper=new ObjectMapper();
            DefaultPutRet putRet = objectMapper.readValue(json, DefaultPutRet.class);
            String url = qiniuConfig.getDomain() + "/" + fileName;
            String  md5 = putRet.hash;
            File file = new File(0,fileName,url,url,extName, (int) size,dto.getKeywords(),md5,null,null, user.getStId(), user.getClId(), dto.getCgId());
            mapper.insert(file);
            //解析上传成功的结果
        } catch (Exception ex) {
            ex.printStackTrace();
            if (ex instanceof QiniuException) {
                QiniuException ex1 = (QiniuException) ex;
                Response r = ex1.response;
                return  new Result(50004, r.toString());
            }
            return  new Result(50004,"文件上传失败");
        }

        return new Result();
    }
}

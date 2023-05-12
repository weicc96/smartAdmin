package org.person.sa.common.module.support.codegenerator.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.person.sa.common.module.support.codegenerator.domain.entity.CodeGeneratorConfigEntity;
import org.springframework.stereotype.Component;

/**
 * 表的 代码生成配置 Dao
 * @Author 1024创新实验室-主任: 卓大
 * @Date 2022-09-23 20:15:38
 * @Wechat wcchen96
 * @Email 15793730318@163.com
 * @Copyright 1024创新实验室 （ https://1024lab.net ）
 */
@Mapper
@Component
public interface CodeGeneratorConfigDao extends BaseMapper<CodeGeneratorConfigEntity> {

}
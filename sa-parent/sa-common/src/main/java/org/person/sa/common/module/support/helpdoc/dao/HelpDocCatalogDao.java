package org.person.sa.common.module.support.helpdoc.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.person.sa.common.module.support.helpdoc.domain.entity.HelpDocCatalogEntity;
import org.springframework.stereotype.Component;

/**
 * 帮助文档目录
 *
 * @Author 1024创新实验室-主任: 卓大
 * @Date 2022-08-20 23:11:42
 * @Wechat wcchen96
 * @Email 15793730318@163.com
 * @Copyright 1024创新实验室 （ https://1024lab.net ）
 */
@Mapper
@Component
public interface HelpDocCatalogDao extends BaseMapper<HelpDocCatalogEntity> {

}

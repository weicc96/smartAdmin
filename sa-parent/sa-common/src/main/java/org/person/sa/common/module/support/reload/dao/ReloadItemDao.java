package org.person.sa.common.module.support.reload.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.person.sa.common.module.support.reload.domain.ReloadItemEntity;
import org.person.sa.common.module.support.reload.domain.ReloadItemVO;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * t_reload_item 数据表dao
 *
 * @Author 1024创新实验室-主任: 卓大
 * @Date 2015-03-02 19:11:52
 * @Wechat wcchen96
 * @Email 15793730318@163.com
 * @Copyright 1024创新实验室 （ https://1024lab.net ）
 */
@Component
@Mapper
public interface ReloadItemDao extends BaseMapper<ReloadItemEntity> {

    List<ReloadItemVO> query();
}

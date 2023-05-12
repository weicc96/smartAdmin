package org.person.sa.admin.module.business.oa.notice.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.person.sa.admin.module.business.oa.notice.domain.entity.NoticeTypeEntity;
import org.springframework.stereotype.Component;

/**
 * 通知公告类型
 *
 * @Author 1024创新实验室-主任: 卓大
 * @Date 2022-08-12 21:40:39
 * @Wechat wcchen96
 * @Email 15793730318@163.com
 */
@Mapper
@Component
public interface NoticeTypeDao extends BaseMapper<NoticeTypeEntity> {

}

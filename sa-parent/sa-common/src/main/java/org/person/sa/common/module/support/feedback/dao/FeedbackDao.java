package org.person.sa.common.module.support.feedback.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.person.sa.common.module.support.feedback.domain.FeedbackEntity;
import org.person.sa.common.module.support.feedback.domain.FeedbackQueryForm;
import org.person.sa.common.module.support.feedback.domain.FeedbackVO;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 意见反馈 dao
 *
 * @Author 1024创新实验室: 开云
 * @Date 2022-08-11 20:48:09
 * @Wechat wcchen96
 * @Email 15793730318@163.com
 * @Copyright 1024创新实验室 （ https://1024lab.net ）
 */
@Mapper
@Component
public interface FeedbackDao extends BaseMapper<FeedbackEntity> {

    /**
     * 分页查询
     */
    List<FeedbackVO> queryPage(Page page, @Param("query") FeedbackQueryForm query);
}
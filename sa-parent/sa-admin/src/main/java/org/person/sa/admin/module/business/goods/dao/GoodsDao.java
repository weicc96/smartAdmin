package org.person.sa.admin.module.business.goods.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.person.sa.admin.module.business.goods.domain.entity.GoodsEntity;
import org.person.sa.admin.module.business.goods.domain.form.GoodsQueryForm;
import org.person.sa.admin.module.business.goods.domain.vo.GoodsVO;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 商品
 *
 * @Author 1024创新实验室: 胡克
 * @Date 2021-10-25 20:26:54
 * @Wechat wcchen96
 * @Email 15793730318@163.com
 */
@Mapper
@Component
public interface GoodsDao extends BaseMapper<GoodsEntity> {

    /**
     * 分页 查询商品
     *
     * @param page
     * @param query
     * @return
     */
    List<GoodsVO> query(Page page, @Param("query") GoodsQueryForm query);

    /**
     * 批量更新删除状态
     */

    void batchUpdateDeleted(@Param("goodsIdList")List<Long> goodsIdList,@Param("deletedFlag")Boolean deletedFlag);
}

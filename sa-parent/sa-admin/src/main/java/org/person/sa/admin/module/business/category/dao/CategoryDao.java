package org.person.sa.admin.module.business.category.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.person.sa.admin.module.business.category.constant.CategoryTypeEnum;
import org.person.sa.admin.module.business.category.domain.entity.CategoryEntity;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 类目 dao
 *
 * @Author 1024创新实验室: 胡克
 * @Date 2021/08/05 21:26:58
 * @Wechat wcchen96
 * @Email 15793730318@163.com
 */
@Component
@Mapper
public interface CategoryDao extends BaseMapper<CategoryEntity> {

    /**
     * 根据父级id 类型 查询子类
     *
     * @param parentIdList
     * @param deletedFlag
     * @return
     */
    List<CategoryEntity> queryByParentId(@Param("parentIdList") List<Long> parentIdList,
                                         @Param("deletedFlag") Boolean deletedFlag);

    /**
     * 根据父级id 类型 查询子类
     *
     * @param parentIdList
     * @param categoryType {@link CategoryTypeEnum}
     * @param deletedFlag
     * @return
     */
    List<CategoryEntity> queryByParentIdAndType(@Param("parentIdList") List<Long> parentIdList,
                                         @Param("categoryType") Integer categoryType,
                                         @Param("deletedFlag") Boolean deletedFlag);

    /**
     * 某个类型的所有
     * @param categoryType
     * @param deletedFlag
     * @return
     */
    List<CategoryEntity> queryByType(@Param("categoryType") Integer categoryType,
                                                @Param("deletedFlag") Boolean deletedFlag);

    /**
     * 根据类型和id查询
     * @param categoryType
     * @param categoryId
     * @return
     */
    CategoryEntity selectByTypeAndId(@Param("categoryType") Integer categoryType, @Param("categoryId") Long categoryId);

    /**
     * 查看类目 具体条件 看sql
     *
     * @param entity
     * @return
     */
    CategoryEntity selectOne(CategoryEntity entity);

}

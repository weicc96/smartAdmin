package org.person.sa.admin.module.system.role.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.person.sa.admin.module.system.menu.domain.entity.MenuEntity;
import org.person.sa.admin.module.system.role.domain.entity.RoleMenuEntity;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 角色 菜单 dao
 *
 * @Author 1024创新实验室: 善逸
 * @Date 2022-03-07 18:54:42
 * @Wechat wcchen96
 * @Email 15793730318@163.com
 * @Copyright 1024创新实验室 （ https://1024lab.net ）
 */
@Mapper
@Component
public interface RoleMenuDao extends BaseMapper<RoleMenuEntity> {

    /**
     * 根据角色ID删除菜单权限
     *
     * @param roleId
     */
    void deleteByRoleId(@Param("roleId") Long roleId);

    /**
     * 根据角色ID查询选择的菜单权限
     *
     * @param roleId
     * @return
     */
    List<Long> queryMenuIdByRoleId(@Param("roleId") Long roleId);

    /**
     * 根据角色ID集合查询选择的菜单权限
     *
     * @param roleIdList
     * @return
     */
    List<MenuEntity> selectMenuListByRoleIdList(@Param("roleIdList") List<Long> roleIdList, @Param("deletedFlag") Boolean deletedFlag);

    /**
     * 查询所有的菜单角色
     *
     * @return
     */
    List<RoleMenuEntity> queryAllRoleMenu();
}

package org.person.sa.admin.module.system.role.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.person.sa.admin.common.AdminBaseController;
import org.person.sa.admin.constant.AdminSwaggerTagConst;
import org.person.sa.admin.module.system.role.domain.form.RoleMenuUpdateForm;
import org.person.sa.admin.module.system.role.domain.vo.RoleMenuTreeVO;
import org.person.sa.admin.module.system.role.service.RoleMenuService;
import org.person.sa.common.common.domain.ResponseDTO;
import org.person.sa.common.module.support.operatelog.annoation.OperateLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * 角色的菜单
 *
 * @Author 1024创新实验室-主任: 卓大
 * @Date 2022-02-26 21:34:01
 * @Wechat wcchen96
 * @Email 15793730318@163.com
 * @Copyright 1024创新实验室 （ https://1024lab.net ）
 */
@OperateLog
@RestController
@Api(tags = {AdminSwaggerTagConst.System.SYSTEM_ROLE_MENU})
public class RoleMenuController extends AdminBaseController {

    @Autowired
    private RoleMenuService roleMenuService;

    @ApiOperation("更新角色权限 @author weicc")
    @PostMapping("/role/menu/updateRoleMenu")
    @PreAuthorize("@saAuth.checkPermission('system:role:menu:update')")
    public ResponseDTO<String> updateRoleMenu(@Valid @RequestBody RoleMenuUpdateForm updateDTO) {
        return roleMenuService.updateRoleMenu(updateDTO);
    }

    @ApiOperation("获取角色关联菜单权限 @author weicc")
    @GetMapping("/role/menu/getRoleSelectedMenu/{roleId}")
    public ResponseDTO<RoleMenuTreeVO> getRoleSelectedMenu(@PathVariable Long roleId) {
        return roleMenuService.getRoleSelectedMenu(roleId);
    }
}

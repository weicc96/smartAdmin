package org.person.sa.admin.module.system.department.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.person.sa.admin.common.AdminBaseController;
import org.person.sa.admin.constant.AdminSwaggerTagConst;
import org.person.sa.admin.module.system.department.domain.form.DepartmentAddForm;
import org.person.sa.admin.module.system.department.domain.form.DepartmentUpdateForm;
import org.person.sa.admin.module.system.department.domain.vo.DepartmentTreeVO;
import org.person.sa.admin.module.system.department.domain.vo.DepartmentVO;
import org.person.sa.admin.module.system.department.service.DepartmentService;
import org.person.sa.common.common.domain.ResponseDTO;
import org.person.sa.common.module.support.operatelog.annoation.OperateLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * 部门
 *
 * @Author 1024创新实验室-主任: 卓大
 * @Date 2022-01-12 20:37:48
 * @Wechat 卓大1024
 * @Email 15793730318@163.com
 * @Copyright 1024创新实验室 （ https://1024lab.net ）
 */
@OperateLog
@RestController
@Api(tags = {AdminSwaggerTagConst.System.SYSTEM_DEPARTMENT})
public class DepartmentController extends AdminBaseController {

    @Autowired
    private DepartmentService departmentService;

    @ApiOperation(value = "查询部门树形列表 @author weicc")
    @GetMapping("/department/treeList")
    public ResponseDTO<List<DepartmentTreeVO>> departmentTree() {
        return departmentService.departmentTree();
    }

    @ApiOperation(value = "添加部门 @author weicc")
    @PostMapping("/department/add")
    @PreAuthorize("@saAuth.checkPermission('system:department:add')")
    public ResponseDTO<String> addDepartment(@Valid @RequestBody DepartmentAddForm createDTO) {
        return departmentService.addDepartment(createDTO);
    }

    @ApiOperation(value = "更新部门 @author weicc")
    @PostMapping("/department/update")
    @PreAuthorize("@saAuth.checkPermission('system:department:update')")
    public ResponseDTO<String> updateDepartment(@Valid @RequestBody DepartmentUpdateForm updateDTO) {
        return departmentService.updateDepartment(updateDTO);
    }

    @ApiOperation(value = "删除部门 @author weicc")
    @GetMapping("/department/delete/{departmentId}")
    @PreAuthorize("@saAuth.checkPermission('system:department:delete')")
    public ResponseDTO<String> deleteDepartment(@PathVariable Long departmentId) {
        return departmentService.deleteDepartment(departmentId);
    }

    @ApiOperation(value = "查询部门列表 @author weicc")
    @GetMapping("/department/listAll")
    public ResponseDTO<List<DepartmentVO>> listAll() {
        return ResponseDTO.ok(departmentService.listAll());
    }

}

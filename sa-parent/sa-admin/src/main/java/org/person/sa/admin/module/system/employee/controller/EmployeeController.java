package org.person.sa.admin.module.system.employee.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.person.sa.admin.common.AdminBaseController;
import org.person.sa.admin.constant.AdminSwaggerTagConst;
import org.person.sa.admin.module.system.employee.domain.form.*;
import org.person.sa.admin.module.system.employee.domain.vo.EmployeeVO;
import org.person.sa.admin.module.system.employee.service.EmployeeService;
import org.person.sa.common.common.domain.PageResult;
import org.person.sa.common.common.domain.ResponseDTO;
import org.person.sa.common.common.util.SmartRequestUtil;
import org.person.sa.common.module.support.operatelog.annoation.OperateLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * 员工
 *
 * @Author 1024创新实验室-主任: 卓大
 * @Date 2021-12-09 22:57:49
 * @Wechat wcchen96
 * @Email 15793730318@163.com
 * @Copyright 1024创新实验室 （ https://1024lab.net ）
 */
@RestController
@OperateLog
@Api(tags = {AdminSwaggerTagConst.System.SYSTEM_EMPLOYEE})
public class EmployeeController extends AdminBaseController {

    @Autowired
    private EmployeeService employeeService;

    @PostMapping("/employee/query")
    @ApiOperation(value = "员工管理查询 @author weicc")
    public ResponseDTO<PageResult<EmployeeVO>> query(@Valid @RequestBody EmployeeQueryForm query) {
        return employeeService.queryEmployee(query);
    }

    @ApiOperation(value = "添加员工(返回添加员工的密码) @author weicc")
    @PostMapping("/employee/add")
    @PreAuthorize("@saAuth.checkPermission('system:employee:add')")
    public ResponseDTO<String> addEmployee(@Valid @RequestBody EmployeeAddForm employeeAddForm) {
        return employeeService.addEmployee(employeeAddForm);
    }

    @ApiOperation(value = "更新员工 @author weicc")
    @PostMapping("/employee/update")
    @PreAuthorize("@saAuth.checkPermission('system:employee:update')")
    public ResponseDTO<String> updateEmployee(@Valid @RequestBody EmployeeUpdateForm employeeUpdateForm) {
        return employeeService.updateEmployee(employeeUpdateForm);
    }

    @ApiOperation(value = "更新员工禁用/启用状态 @author weicc")
    @GetMapping("/employee/update/disabled/{employeeId}")
    @PreAuthorize("@saAuth.checkPermission('system:employee:disabled')")
    public ResponseDTO<String> updateDisableFlag(@PathVariable Long employeeId) {
        return employeeService.updateDisableFlag(employeeId);
    }

    @ApiOperation(value = "批量删除员工 @author weicc")
    @PostMapping("/employee/update/batch/delete")
    @PreAuthorize("@saAuth.checkPermission('system:employee:delete')")
    public ResponseDTO<String> batchUpdateDeleteFlag(@RequestBody List<Long> employeeIdList) {
        return employeeService.batchUpdateDeleteFlag(employeeIdList);
    }

    @ApiOperation(value = "批量调整员工部门 @author weicc")
    @PostMapping("/employee/update/batch/department")
    @PreAuthorize("@saAuth.checkPermission('system:employee:department:update')")
    public ResponseDTO<String> batchUpdateDepartment(@Valid @RequestBody EmployeeBatchUpdateDepartmentForm batchUpdateDepartmentForm) {
        return employeeService.batchUpdateDepartment(batchUpdateDepartmentForm);
    }

    @ApiOperation(value = "修改密码 @author weicc")
    @PostMapping("/employee/update/password")
    public ResponseDTO<String> updatePassword(@Valid @RequestBody EmployeeUpdatePasswordForm updatePasswordForm) {
        updatePasswordForm.setEmployeeId(SmartRequestUtil.getRequestUserId());
        return employeeService.updatePassword(updatePasswordForm);
    }

    @ApiOperation(value = "重置员工密码 @author weicc")
    @GetMapping("/employee/update/password/reset/{employeeId}")
    @PreAuthorize("@saAuth.checkPermission('system:employee:password:reset')")
    public ResponseDTO<String> resetPassword(@PathVariable Integer employeeId) {
        return employeeService.resetPassword(employeeId);
    }

    @ApiOperation(value = "查询员工-根据部门id @author weicc")
    @GetMapping("/employee/getAllEmployeeByDepartmentId/{departmentId}")
    public ResponseDTO<List<EmployeeVO>> getAllEmployeeByDepartmentId(@PathVariable Long departmentId) {
        return employeeService.getAllEmployeeByDepartmentId(departmentId, Boolean.FALSE);
    }

    @ApiOperation("查询所有员工 @author weicc")
    @GetMapping("/employee/queryAll")
    public ResponseDTO<List<EmployeeVO>> queryAllEmployee(@RequestParam(value = "disabledFlag", required = false) Boolean disabledFlag) {
        return employeeService.queryAllEmployee(disabledFlag);
    }

}

package org.person.sa.admin.module.system.support;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.person.sa.common.common.domain.ResponseDTO;
import org.person.sa.common.common.domain.ValidateList;
import org.person.sa.common.constant.SwaggerTagConst;
import org.person.sa.common.module.support.changelog.domain.form.ChangeLogAddForm;
import org.person.sa.common.module.support.changelog.domain.form.ChangeLogUpdateForm;
import org.person.sa.common.module.support.changelog.service.ChangeLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * 系统更新日志 Controller
 *
 * @author weicc
 * @Date 2022-09-26 14:53:50
 * @Copyright 1024创新实验室
 */

@RestController
@Api(tags = SwaggerTagConst.Support.CHANGE_LOG)
public class AdminChangeLogController {

    @Autowired
    private ChangeLogService changeLogService;

    @ApiOperation("添加 @author weicc")
    @PostMapping("/changeLog/add")
    @PreAuthorize("@saAuth.checkPermission('changeLog:add')")
    public ResponseDTO<String> add(@RequestBody @Valid ChangeLogAddForm addForm) {
        return changeLogService.add(addForm);
    }

    @ApiOperation("更新 @author weicc")
    @PreAuthorize("@saAuth.checkPermission('changeLog:update')")
    @PostMapping("/changeLog/update")
    public ResponseDTO<String> update(@RequestBody @Valid ChangeLogUpdateForm updateForm) {
        return changeLogService.update(updateForm);
    }

    @ApiOperation("批量删除 @author weicc")
    @PreAuthorize("@saAuth.checkPermission('changeLog:batchDelete')")
    @PostMapping("/changeLog/batchDelete")
    public ResponseDTO<String> batchDelete(@RequestBody ValidateList<Long> idList) {
        return changeLogService.batchDelete(idList);
    }

    @ApiOperation("单个删除 @author weicc")
    @PreAuthorize("@saAuth.checkPermission('changeLog:delete')")
    @GetMapping("/changeLog/delete/{changeLogId}")
    public ResponseDTO<String> batchDelete(@PathVariable Long changeLogId) {
        return changeLogService.delete(changeLogId);
    }
}
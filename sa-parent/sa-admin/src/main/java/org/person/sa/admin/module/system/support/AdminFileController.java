package org.person.sa.admin.module.system.support;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.person.sa.common.common.controller.SupportBaseController;
import org.person.sa.common.common.domain.PageResult;
import org.person.sa.common.common.domain.ResponseDTO;
import org.person.sa.common.constant.SwaggerTagConst;
import org.person.sa.common.module.support.file.domain.form.FileQueryForm;
import org.person.sa.common.module.support.file.domain.vo.FileVO;
import org.person.sa.common.module.support.file.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * 文件服务
 *
 * @Author 1024创新实验室: 罗伊
 * @Date 2019年10月11日 15:34:47
 * @Wechat wcchen96
 * @Email 15793730318@163.com
 * @Copyright 1024创新实验室 （ https://1024lab.net ）
 */
@RestController
@Api(tags = {SwaggerTagConst.Support.FILE})
public class AdminFileController extends SupportBaseController {

    @Autowired
    private FileService fileService;

    @ApiOperation("分页查询 @author 1024创新实验室-主任-卓大")
    @PreAuthorize("@saAuth.checkPermission('support:file:query')")
    @PostMapping("/file/queryPage")
    public ResponseDTO<PageResult<FileVO>> queryPage(@RequestBody @Valid FileQueryForm queryForm) {
        return ResponseDTO.ok(fileService.queryPage(queryForm));
    }

}

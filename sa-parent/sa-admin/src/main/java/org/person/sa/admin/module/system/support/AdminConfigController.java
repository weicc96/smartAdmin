package org.person.sa.admin.module.system.support;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.person.sa.common.common.controller.SupportBaseController;
import org.person.sa.common.common.domain.PageResult;
import org.person.sa.common.common.domain.ResponseDTO;
import org.person.sa.common.constant.SwaggerTagConst;
import org.person.sa.common.module.support.config.ConfigService;
import org.person.sa.common.module.support.config.domain.ConfigAddForm;
import org.person.sa.common.module.support.config.domain.ConfigQueryForm;
import org.person.sa.common.module.support.config.domain.ConfigUpdateForm;
import org.person.sa.common.module.support.config.domain.ConfigVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * 配置
 *
 * @Author 1024创新实验室-主任: 卓大
 * @Date 2022-03-14 20:46:27
 * @Wechat wcchen96
 * @Email 15793730318@163.com
 * @Copyright 1024创新实验室 （ https://1024lab.net ）
 */
@Api(tags = {SwaggerTagConst.Support.CONFIG})
@RestController
public class AdminConfigController extends SupportBaseController {

    @Autowired
    private ConfigService configService;

    @ApiOperation("分页查询系统配置 @author weicc")
    @PreAuthorize("@saAuth.checkPermission('support:config:query')")
    @PostMapping("/config/query")
    public ResponseDTO<PageResult<ConfigVO>> querySystemConfigPage(@RequestBody @Valid ConfigQueryForm queryForm) {
        return configService.queryConfigPage(queryForm);
    }

    @ApiOperation("添加配置参数 @author weicc")
    @PreAuthorize("@saAuth.checkPermission('support:config:add')")
    @PostMapping("/config/add")
    public ResponseDTO<String> addSystemConfig(@RequestBody @Valid ConfigAddForm configAddForm) {
        return configService.add(configAddForm);
    }

    @ApiOperation("修改配置参数 @author weicc")
    @PreAuthorize("@saAuth.checkPermission('support:config:update')")
    @PostMapping("/config/update")
    public ResponseDTO<String> updateSystemConfig(@RequestBody @Valid ConfigUpdateForm updateForm) {
        return configService.updateSystemConfig(updateForm);
    }

}

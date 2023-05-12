package org.person.sa.admin.module.system.support;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.person.sa.common.common.controller.SupportBaseController;
import org.person.sa.common.common.domain.PageResult;
import org.person.sa.common.common.domain.ResponseDTO;
import org.person.sa.common.constant.SwaggerTagConst;
import org.person.sa.common.module.support.helpdoc.domain.form.*;
import org.person.sa.common.module.support.helpdoc.domain.vo.HelpDocDetailVO;
import org.person.sa.common.module.support.helpdoc.domain.vo.HelpDocVO;
import org.person.sa.common.module.support.helpdoc.service.HelpDocCatalogService;
import org.person.sa.common.module.support.helpdoc.service.HelpDocService;
import org.person.sa.common.module.support.repeatsubmit.annoation.RepeatSubmit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * 帮助文档
 *
 * @Author 1024创新实验室-主任: 卓大
 * @Date 2022-08-20 23:11:42
 * @Wechat wcchen96
 * @Email 15793730318@163.com
 * @Copyright 1024创新实验室 （ https://1024lab.net ）
 */
@Api(tags = SwaggerTagConst.Support.HELP_DOC)
@RestController
public class AdminHelpDocController extends SupportBaseController {

    @Autowired
    private HelpDocService helpDocService;

    @Autowired
    private HelpDocCatalogService helpDocCatalogService;

    // --------------------- 帮助文档 【目录管理】 -------------------------


    @ApiOperation("帮助文档目录-添加 @author weicc")
    @PreAuthorize("@saAuth.checkPermission('helpDocCatalog:addCategory')")
    @PostMapping("/helpDoc/helpDocCatalog/add")
    public ResponseDTO<String> addHelpDocCatalog(@RequestBody @Valid HelpDocCatalogAddForm helpDocCatalogAddForm) {
        return helpDocCatalogService.add(helpDocCatalogAddForm);
    }

    @ApiOperation("帮助文档目录-更新 @author weicc")
    @PreAuthorize("@saAuth.checkPermission('helpDocCatalog:edit')")
    @PostMapping("/helpDoc/helpDocCatalog/update")
    public ResponseDTO<String> updateHelpDocCatalog(@RequestBody @Valid HelpDocCatalogUpdateForm helpDocCatalogUpdateForm) {
        return helpDocCatalogService.update(helpDocCatalogUpdateForm);
    }

    @ApiOperation("帮助文档目录-删除 @author weicc")
    @GetMapping("/helpDoc/helpDocCatalog/delete/{helpDocCatalogId}")
    public ResponseDTO<String> deleteHelpDocCatalog(@PathVariable Long helpDocCatalogId) {
        return helpDocCatalogService.delete(helpDocCatalogId);
    }

    // --------------------- 帮助文档 【管理:增、删、查、改】-------------------------

    @ApiOperation("【管理】帮助文档-分页查询 @author weicc")
    @PreAuthorize("@saAuth.checkPermission('helpDoc:query')")
    @PostMapping("/helpDoc/query")
    public ResponseDTO<PageResult<HelpDocVO>> query(@RequestBody @Valid HelpDocQueryForm queryForm) {
        return ResponseDTO.ok(helpDocService.query(queryForm));
    }

    @ApiOperation("【管理】帮助文档-获取详情 @author weicc")
    @GetMapping("/helpDoc/getDetail/{helpDocId}")
    public ResponseDTO<HelpDocDetailVO> getDetail(@PathVariable Long helpDocId) {
        return ResponseDTO.ok(helpDocService.getDetail(helpDocId));
    }

    @ApiOperation("【管理】帮助文档-添加 @author weicc")
    @PreAuthorize("@saAuth.checkPermission('helpDoc:add')")
    @PostMapping("/helpDoc/add")
    @RepeatSubmit
    public ResponseDTO<String> add(@RequestBody @Valid HelpDocAddForm addForm) {
        return helpDocService.add(addForm);
    }

    @ApiOperation("【管理】帮助文档-更新 @author weicc")
    @PreAuthorize("@saAuth.checkPermission('helpDoc:update')")
    @PostMapping("/helpDoc/update")
    @RepeatSubmit
    public ResponseDTO<String> update(@RequestBody @Valid HelpDocUpdateForm updateForm) {
        return helpDocService.update(updateForm);
    }

    @ApiOperation("【管理】帮助文档-删除 @author weicc")
    @PreAuthorize("@saAuth.checkPermission('helpDoc:delete')")
    @GetMapping("/helpDoc/delete/{helpDocId}")
    public ResponseDTO<String> delete(@PathVariable Long helpDocId) {
        return helpDocService.delete(helpDocId);
    }

    @ApiOperation("【管理】帮助文档-根据关联id查询 @author weicc")
    @GetMapping("/helpDoc/queryHelpDocByRelationId/{relationId}")
    public ResponseDTO<List<HelpDocVO>> queryHelpDocByRelationId(@PathVariable Long relationId) {
        return ResponseDTO.ok(helpDocService.queryHelpDocByRelationId(relationId));
    }

}
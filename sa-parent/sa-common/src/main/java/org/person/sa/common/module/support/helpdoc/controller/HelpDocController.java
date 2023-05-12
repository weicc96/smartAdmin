package org.person.sa.common.module.support.helpdoc.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.person.sa.common.common.controller.SupportBaseController;
import org.person.sa.common.common.domain.PageResult;
import org.person.sa.common.common.domain.ResponseDTO;
import org.person.sa.common.common.util.SmartRequestUtil;
import org.person.sa.common.constant.SwaggerTagConst;
import org.person.sa.common.module.support.helpdoc.domain.form.HelpDocViewRecordQueryForm;
import org.person.sa.common.module.support.helpdoc.domain.vo.HelpDocCatalogVO;
import org.person.sa.common.module.support.helpdoc.domain.vo.HelpDocDetailVO;
import org.person.sa.common.module.support.helpdoc.domain.vo.HelpDocVO;
import org.person.sa.common.module.support.helpdoc.domain.vo.HelpDocViewRecordVO;
import org.person.sa.common.module.support.helpdoc.service.HelpDocCatalogService;
import org.person.sa.common.module.support.helpdoc.service.HelpDocUserService;
import org.person.sa.common.module.support.repeatsubmit.annoation.RepeatSubmit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
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
public class HelpDocController extends SupportBaseController {

    @Autowired
    private HelpDocCatalogService helpDocCatalogService;

    @Autowired
    private HelpDocUserService helpDocUserService;

    // --------------------- 帮助文档 【目录】 -------------------------

    @ApiOperation("帮助文档目录-获取全部 @author weicc")
    @GetMapping("/helpDoc/helpDocCatalog/getAll")
    public ResponseDTO<List<HelpDocCatalogVO>> getAll() {
        return ResponseDTO.ok(helpDocCatalogService.getAll());
    }

    // --------------------- 帮助文档 【用户】-------------------------

    @ApiOperation("【用户】帮助文档-查看详情 @author weicc")
    @GetMapping("/helpDoc/user/view/{helpDocId}")
    @RepeatSubmit
    public ResponseDTO<HelpDocDetailVO> view(@PathVariable Long helpDocId, HttpServletRequest request) {
        return helpDocUserService.view(
                SmartRequestUtil.getRequestUser(),
                helpDocId);
    }

    @ApiOperation("【用户】帮助文档-查询全部 @author weicc")
    @GetMapping("/helpDoc/user/queryAllHelpDocList")
    @RepeatSubmit
    public ResponseDTO<List<HelpDocVO>> queryAllHelpDocList() {
        return helpDocUserService.queryAllHelpDocList();
    }


    @ApiOperation("【用户】帮助文档-查询 查看记录 @author weicc")
    @PostMapping("/helpDoc/user/queryViewRecord")
    @RepeatSubmit
    public ResponseDTO<PageResult<HelpDocViewRecordVO>> queryViewRecord(@RequestBody @Valid HelpDocViewRecordQueryForm helpDocViewRecordQueryForm) {
        return ResponseDTO.ok(helpDocUserService.queryViewRecord(helpDocViewRecordQueryForm));
    }
}
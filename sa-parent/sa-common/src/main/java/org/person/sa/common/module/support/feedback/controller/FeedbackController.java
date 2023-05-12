package org.person.sa.common.module.support.feedback.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.person.sa.common.common.controller.SupportBaseController;
import org.person.sa.common.common.domain.PageResult;
import org.person.sa.common.common.domain.RequestUser;
import org.person.sa.common.common.domain.ResponseDTO;
import org.person.sa.common.common.util.SmartRequestUtil;
import org.person.sa.common.constant.SwaggerTagConst;
import org.person.sa.common.module.support.feedback.domain.FeedbackAddForm;
import org.person.sa.common.module.support.feedback.domain.FeedbackQueryForm;
import org.person.sa.common.module.support.feedback.domain.FeedbackVO;
import org.person.sa.common.module.support.feedback.service.FeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * 意见反馈
 *
 * @Author 1024创新实验室: 开云
 * @Date 2022-08-11 20:48:09
 * @Wechat wcchen96
 * @Email 15793730318@163.com
 * @Copyright 1024创新实验室 （ https://1024lab.net ）
 */
@Slf4j
@Api(tags = SwaggerTagConst.Support.FEEDBACK)
@RestController
public class FeedbackController extends SupportBaseController {

    @Autowired
    private FeedbackService feedbackService;

    @ApiOperation("意见反馈-分页查询 @author 开云")
    @PostMapping("/feedback/query")
    public ResponseDTO<PageResult<FeedbackVO>> query(@RequestBody @Valid FeedbackQueryForm queryForm) {
        return feedbackService.query(queryForm);
    }

    @ApiOperation("意见反馈-新增 @author 开云")
    @PostMapping("/feedback/add")
    public ResponseDTO<String> add(@RequestBody @Valid FeedbackAddForm addForm) {
        RequestUser employee = SmartRequestUtil.getRequestUser();
        return feedbackService.add(addForm, employee);
    }
}

package org.person.sa.admin.module.system.support;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.person.sa.common.common.controller.SupportBaseController;
import org.person.sa.common.common.domain.PageResult;
import org.person.sa.common.common.domain.ResponseDTO;
import org.person.sa.common.common.util.SmartEnumUtil;
import org.person.sa.common.constant.SwaggerTagConst;
import org.person.sa.common.module.support.serialnumber.constant.SerialNumberIdEnum;
import org.person.sa.common.module.support.serialnumber.dao.SerialNumberDao;
import org.person.sa.common.module.support.serialnumber.domain.SerialNumberEntity;
import org.person.sa.common.module.support.serialnumber.domain.SerialNumberGenerateForm;
import org.person.sa.common.module.support.serialnumber.domain.SerialNumberRecordEntity;
import org.person.sa.common.module.support.serialnumber.domain.SerialNumberRecordQueryForm;
import org.person.sa.common.module.support.serialnumber.service.SerialNumberRecordService;
import org.person.sa.common.module.support.serialnumber.service.SerialNumberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

/**
 * 单据序列号
 *
 * @Author 1024创新实验室-主任: 卓大
 * @Date 2022-03-25 21:46:07
 * @Wechat wcchen96
 * @Email 15793730318@163.com
 * @Copyright 1024创新实验室 （ https://1024lab.net ）
 */
@Api(tags = SwaggerTagConst.Support.SERIAL_NUMBER)
@RestController
public class AdminSerialNumberController extends SupportBaseController {

    @Autowired
    private SerialNumberDao serialNumberDao;

    @Autowired
    private SerialNumberService serialNumberService;

    @Autowired
    private SerialNumberRecordService serialNumberRecordService;

    @ApiOperation("生成单号 @author weicc")
    @PreAuthorize("@saAuth.checkPermission('support:serial:number:generate')")
    @PostMapping("/serialNumber/generate")
    public ResponseDTO<List<String>> generate(@RequestBody @Valid SerialNumberGenerateForm generateForm) {
        SerialNumberIdEnum serialNumberIdEnum = SmartEnumUtil.getEnumByValue(generateForm.getSerialNumberId(), SerialNumberIdEnum.class);
        if (null == serialNumberIdEnum) {
            return ResponseDTO.userErrorParam("SerialNumberId，不存在" + generateForm.getSerialNumberId());
        }
        return ResponseDTO.ok(serialNumberService.generate(serialNumberIdEnum, generateForm.getCount()));
    }

    @ApiOperation("获取所有单号定义 @author weicc")
    @GetMapping("/serialNumber/all")
    public ResponseDTO<List<SerialNumberEntity>> getAll() {
        return ResponseDTO.ok(serialNumberDao.selectList(null));
    }

    @ApiOperation("获取生成记录 @author weicc")
    @PreAuthorize("@saAuth.checkPermission('support:serial:number:record')")
    @PostMapping("/serialNumber/queryRecord")
    public ResponseDTO<PageResult<SerialNumberRecordEntity>> queryRecord(@RequestBody @Valid SerialNumberRecordQueryForm queryForm) {
        return ResponseDTO.ok(serialNumberRecordService.query(queryForm));
    }

}

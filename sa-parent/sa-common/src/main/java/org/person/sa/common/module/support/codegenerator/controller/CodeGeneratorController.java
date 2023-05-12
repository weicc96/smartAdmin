package org.person.sa.common.module.support.codegenerator.controller;

import com.alibaba.fastjson.JSON;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.person.sa.common.common.controller.SupportBaseController;
import org.person.sa.common.common.domain.PageResult;
import org.person.sa.common.common.domain.ResponseDTO;
import org.person.sa.common.constant.SwaggerTagConst;
import org.person.sa.common.module.support.codegenerator.domain.form.CodeGeneratorConfigForm;
import org.person.sa.common.module.support.codegenerator.domain.form.CodeGeneratorPreviewForm;
import org.person.sa.common.module.support.codegenerator.domain.form.TableQueryForm;
import org.person.sa.common.module.support.codegenerator.domain.vo.TableColumnVO;
import org.person.sa.common.module.support.codegenerator.domain.vo.TableConfigVO;
import org.person.sa.common.module.support.codegenerator.domain.vo.TableVO;
import org.person.sa.common.module.support.codegenerator.service.CodeGeneratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * 代码生成
 *
 * @Author 1024创新实验室-主任: 卓大
 * @Date 2022-06-29 20:23:46
 * @Wechat wcchen96
 * @Email 15793730318@163.com
 * @Copyright 1024创新实验室 （ https://1024lab.net ）
 */
@Api(tags = SwaggerTagConst.Support.CODE_GENERATOR)
@Controller
public class CodeGeneratorController extends SupportBaseController {

    @Autowired
    private CodeGeneratorService codeGeneratorService;

    // ------------------- 查询 -------------------
    @ApiOperation("获取表的列 @author weicc")
    @GetMapping("/codeGenerator/table/getTableColumns/{table}")
    @ResponseBody
    public ResponseDTO<List<TableColumnVO>> getTableColumns(@PathVariable String table) {
        return ResponseDTO.ok(codeGeneratorService.getTableColumns(table));
    }

    @ApiOperation("查询数据库的表 @author weicc")
    @PostMapping("/codeGenerator/table/queryTableList")
    @ResponseBody
    public ResponseDTO<PageResult<TableVO>> queryTableList(@RequestBody @Valid TableQueryForm tableQueryForm) {
        return ResponseDTO.ok(codeGeneratorService.queryTableList(tableQueryForm));
    }

    // ------------------- 配置 -------------------

    @ApiOperation("获取表的配置信息 @author weicc")
    @GetMapping("/codeGenerator/table/getConfig/{table}")
    @ResponseBody
    public ResponseDTO<TableConfigVO> getTableConfig(@PathVariable String table) {
        return ResponseDTO.ok(codeGeneratorService.getTableConfig(table));
    }

    @ApiOperation("更新配置信息 @author weicc")
    @PostMapping("/codeGenerator/table/updateConfig")
    @ResponseBody
    public ResponseDTO<String> updateConfig(@RequestBody @Valid CodeGeneratorConfigForm form) {
        return codeGeneratorService.updateConfig(form);
    }

    // ------------------- 生成 -------------------

    @ApiOperation("代码预览 @author weicc")
    @PostMapping("/codeGenerator/code/preview")
    @ResponseBody
    public ResponseDTO<String> preview(@RequestBody @Valid CodeGeneratorPreviewForm form) {
        return codeGeneratorService.preview(form);
    }

    @ApiOperation("代码下载 @author weicc")
    @GetMapping(value = "/codeGenerator/code/download/{tableName}", produces = "application/octet-stream")
    public ResponseEntity<byte[]> download(@PathVariable String tableName) {

        ResponseDTO<byte[]> download = codeGeneratorService.download(tableName);

        if (download.getOk()) {
            HttpHeaders heads = new HttpHeaders();
            heads.add(HttpHeaders.CONTENT_TYPE, "application/octet-stream; charset=UTF-8");
            heads.add(HttpHeaders.CONTENT_LENGTH, "" + download.getData().length);
            heads.add(HttpHeaders.CONTENT_DISPOSITION, "attachment;filename=" + tableName + "-code.zip");
            ResponseEntity<byte[]> responseEntity = new ResponseEntity<>(download.getData(), heads, HttpStatus.OK);
            return responseEntity;
        } else {
            byte[] data = JSON.toJSONString(download).getBytes();
            HttpHeaders heads = new HttpHeaders();
            heads.add(HttpHeaders.CONTENT_TYPE, "application/json; charset=UTF-8");
            heads.add(HttpHeaders.CONTENT_LENGTH, "" + data.length);
            ResponseEntity<byte[]> responseEntity = new ResponseEntity<>(data, heads, HttpStatus.OK);
            return responseEntity;
        }
    }

}
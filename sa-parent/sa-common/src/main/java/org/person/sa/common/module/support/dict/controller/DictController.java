package org.person.sa.common.module.support.dict.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.person.sa.common.common.controller.SupportBaseController;
import org.person.sa.common.common.domain.PageResult;
import org.person.sa.common.common.domain.ResponseDTO;
import org.person.sa.common.constant.SwaggerTagConst;
import org.person.sa.common.module.support.dict.domain.form.DictValueQueryForm;
import org.person.sa.common.module.support.dict.domain.vo.DictKeyVO;
import org.person.sa.common.module.support.dict.domain.vo.DictValueVO;
import org.person.sa.common.module.support.dict.service.DictCacheService;
import org.person.sa.common.module.support.dict.service.DictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * 字典
 *
 * @Author 1024创新实验室: 罗伊
 * @Date 2022/5/26 19:40:55
 * @Wechat wcchen96
 * @Email 15793730318@163.com
 * @Copyright 1024创新实验室 （ https://1024lab.net ）
 */
@Api(tags = {SwaggerTagConst.Support.DICT})
@RestController
public class DictController extends SupportBaseController {

    @Autowired
    private DictService dictService;
    @Autowired
    private DictCacheService dictCacheService;


    @ApiOperation("查询全部字典key - @author weicc")
    @GetMapping("/dict/key/queryAll")
    public ResponseDTO<List<DictKeyVO>> queryAll() {
        return ResponseDTO.ok(dictService.queryAllKey());
    }

    @ApiOperation("分页查询数据字典value - @author 罗伊")
    @PostMapping("/dict/value/query")
    public ResponseDTO<PageResult<DictValueVO>> valueQuery(@Valid @RequestBody DictValueQueryForm queryForm) {
        return dictService.valueQuery(queryForm);
    }

    @ApiOperation("数据字典缓存-刷新- @author 罗伊")
    @GetMapping("/dict/cache/refresh")
    public ResponseDTO<String> cacheRefresh() {
        return dictCacheService.cacheRefresh();
    }

    @ApiOperation("数据字典-值列表- @author 罗伊")
    @GetMapping("/dict/value/list/{keyCode}")
    public ResponseDTO<List<DictValueVO>> valueList(@PathVariable String keyCode) {
        List<DictValueVO> dictValueVOList = dictCacheService.selectByKeyCode(keyCode);
        return ResponseDTO.ok(dictValueVOList);
    }
}

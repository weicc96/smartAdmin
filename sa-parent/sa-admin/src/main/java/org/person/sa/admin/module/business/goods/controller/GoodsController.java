package org.person.sa.admin.module.business.goods.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.person.sa.admin.common.AdminBaseController;
import org.person.sa.admin.constant.AdminSwaggerTagConst;
import org.person.sa.admin.module.business.goods.domain.form.GoodsAddForm;
import org.person.sa.admin.module.business.goods.domain.form.GoodsQueryForm;
import org.person.sa.admin.module.business.goods.domain.form.GoodsUpdateForm;
import org.person.sa.admin.module.business.goods.domain.vo.GoodsVO;
import org.person.sa.admin.module.business.goods.service.GoodsService;
import org.person.sa.common.common.domain.PageResult;
import org.person.sa.common.common.domain.ResponseDTO;
import org.person.sa.common.common.domain.ValidateList;
import org.person.sa.common.module.support.operatelog.annoation.OperateLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * 商品业务
 *
 * @Author 1024创新实验室: 胡克
 * @Date 2021-10-25 20:26:54
 * @Wechat wcchen96
 * @Email 15793730318@163.com
 */
@OperateLog
@RestController
@Api(tags = AdminSwaggerTagConst.Business.MANAGER_GOODS)
public class GoodsController extends AdminBaseController {

    @Autowired
    private GoodsService goodsService;

    @ApiOperation("分页查询 @author 胡克")
    @PostMapping("/goods/query")
    @PreAuthorize("@saAuth.checkPermission('goods:query ')")
    public ResponseDTO<PageResult<GoodsVO>> query(@RequestBody @Valid GoodsQueryForm queryForm) {
        return goodsService.query(queryForm);
    }

    @ApiOperation("添加商品 @author 胡克")
    @PostMapping("/goods/add")
    @PreAuthorize("@saAuth.checkPermission('goods:add')")
    public ResponseDTO<String> add(@RequestBody @Valid GoodsAddForm addForm) {
        return goodsService.add(addForm);
    }

    @ApiOperation("更新商品 @author 胡克")
    @PostMapping("/goods/update")
    @PreAuthorize("@saAuth.checkPermission('goods:update')")
    public ResponseDTO<String> update(@RequestBody @Valid GoodsUpdateForm updateForm) {
        return goodsService.update(updateForm);
    }

    @ApiOperation("删除 @author weicc")
    @GetMapping("/goods/delete/{goodsId}")
    @PreAuthorize("@saAuth.checkPermission('goods:delete')")
    public ResponseDTO<String> delete(@PathVariable Long goodsId) {
        return goodsService.delete(goodsId);
    }

    @ApiOperation("批量 @author weicc")
    @PostMapping("/goods/batchDelete")
    @PreAuthorize("@saAuth.checkPermission('goods:batchDelete')")
    public ResponseDTO<String> batchDelete(@RequestBody @Valid ValidateList<Long> idList) {
        return goodsService.batchDelete(idList);
    }


}

package org.person.sa.admin.module.business.category.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.person.sa.admin.common.AdminBaseController;
import org.person.sa.admin.constant.AdminSwaggerTagConst;
import org.person.sa.admin.module.business.category.domain.form.CategoryAddForm;
import org.person.sa.admin.module.business.category.domain.form.CategoryTreeQueryForm;
import org.person.sa.admin.module.business.category.domain.form.CategoryUpdateForm;
import org.person.sa.admin.module.business.category.domain.vo.CategoryTreeVO;
import org.person.sa.admin.module.business.category.domain.vo.CategoryVO;
import org.person.sa.admin.module.business.category.service.CategoryService;
import org.person.sa.common.common.domain.ResponseDTO;
import org.person.sa.common.module.support.operatelog.annoation.OperateLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * 类目
 *
 * @Author 1024创新实验室: 胡克
 * @Date 2021/08/05 21:26:58
 * @Wechat wcchen96
 * @Email 15793730318@163.com
 */
@OperateLog
@RestController
@Api(tags = AdminSwaggerTagConst.Business.MANAGER_CATEGORY)
public class CategoryController extends AdminBaseController {

    @Autowired
    private CategoryService categoryService;

    @ApiOperation("添加类目 @author 胡克")
    @PostMapping("/category/add")
    public ResponseDTO<String> add(@RequestBody @Valid CategoryAddForm addForm) {
        return categoryService.add(addForm);
    }

    @ApiOperation("更新类目 @author 胡克")
    @PostMapping("/category/update")
    public ResponseDTO<String> update(@RequestBody @Valid CategoryUpdateForm updateForm) {
        return categoryService.update(updateForm);
    }

    @ApiOperation("查询类目详情 @author 胡克")
    @GetMapping("/category/{categoryId}")
    public ResponseDTO<CategoryVO> queryDetail(@PathVariable Long categoryId) {
        return categoryService.queryDetail(categoryId);
    }

    @ApiOperation("查询类目层级树 @author 胡克")
    @PostMapping("/category/tree")
    public ResponseDTO<List<CategoryTreeVO>> queryTree(@RequestBody @Valid CategoryTreeQueryForm queryForm) {
        return categoryService.queryTree(queryForm);
    }

    @ApiOperation("删除类目 @author 胡克")
    @GetMapping("/category/delete/{categoryId}")
    public ResponseDTO<String> delete(@PathVariable Long categoryId) {
        return categoryService.delete(categoryId);
    }
}

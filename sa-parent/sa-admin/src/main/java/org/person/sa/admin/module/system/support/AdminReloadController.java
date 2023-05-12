package org.person.sa.admin.module.system.support;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.person.sa.common.common.controller.SupportBaseController;
import org.person.sa.common.common.domain.ResponseDTO;
import org.person.sa.common.constant.SwaggerTagConst;
import org.person.sa.common.module.support.reload.ReloadService;
import org.person.sa.common.module.support.reload.domain.ReloadForm;
import org.person.sa.common.module.support.reload.domain.ReloadItemVO;
import org.person.sa.common.module.support.reload.domain.ReloadResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * reload (内存热加载、钩子等)
 *
 * @Author 1024创新实验室-主任: 卓大
 * @Date 2015-03-02 19:11:52
 * @Wechat wcchen96
 * @Email 15793730318@163.com
 * @Copyright 1024创新实验室 （ https://1024lab.net ）
 */
@RestController
@Api(tags = {SwaggerTagConst.Support.RELOAD})
public class AdminReloadController extends SupportBaseController {

    @Autowired
    private ReloadService reloadService;

    @ApiOperation(value = "查询reload列表 @author 开云")
    @GetMapping("/reload/query")
    public ResponseDTO<List<ReloadItemVO>> query() {
        return reloadService.query();
    }

    @ApiOperation(value = "获取reload result @author 开云")
    @PreAuthorize("@saAuth.checkPermission('support:reload:result')")
    @GetMapping("/reload/result/{tag}")
    public ResponseDTO<List<ReloadResultVO>> queryReloadResult(@PathVariable("tag") String tag) {
        return reloadService.queryReloadItemResult(tag);
    }

    @ApiOperation(value = "通过tag更新标识 @author 开云")
    @PreAuthorize("@saAuth.checkPermission('support:reload:execute')")
    @PostMapping("/reload/update")
    public ResponseDTO<String> updateByTag(@RequestBody @Valid ReloadForm reloadForm) {
        return reloadService.updateByTag(reloadForm);
    }
}

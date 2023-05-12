package org.person.sa.admin.module.business.oa.invoice;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.person.sa.admin.constant.AdminSwaggerTagConst;
import org.person.sa.admin.module.business.oa.invoice.domain.InvoiceAddForm;
import org.person.sa.admin.module.business.oa.invoice.domain.InvoiceQueryForm;
import org.person.sa.admin.module.business.oa.invoice.domain.InvoiceUpdateForm;
import org.person.sa.admin.module.business.oa.invoice.domain.InvoiceVO;
import org.person.sa.common.common.domain.PageResult;
import org.person.sa.common.common.domain.RequestUser;
import org.person.sa.common.common.domain.ResponseDTO;
import org.person.sa.common.common.util.SmartRequestUtil;
import org.person.sa.common.module.support.operatelog.annoation.OperateLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * OA发票信息
 *
 * @Author 1024创新实验室: 善逸
 * @Date 2022-06-23 19:32:59
 * @Wechat wcchen96
 * @Email 15793730318@163.com
 */
@Slf4j
@RestController
@OperateLog
@Api(tags = {AdminSwaggerTagConst.Business.OA_INVOICE})
public class InvoiceController {

    @Autowired
    private InvoiceService invoiceService;

    @ApiOperation(value = "分页查询发票信息 @author 善逸")
    @PostMapping("/oa/invoice/page/query")
    public ResponseDTO<PageResult<InvoiceVO>> queryByPage(@RequestBody @Valid InvoiceQueryForm queryDTO) {
        return invoiceService.queryByPage(queryDTO);
    }

    @ApiOperation(value = "查询发票信息详情 @author 善逸")
    @GetMapping("/oa/invoice/get/{invoiceId}")
    public ResponseDTO<InvoiceVO> getDetail(@PathVariable Long invoiceId) {
        return invoiceService.getDetail(invoiceId);
    }

    @ApiOperation(value = "新建发票信息 @author 善逸")
    @PostMapping("/oa/invoice/create")
    public ResponseDTO<String> createInvoice(@RequestBody @Valid InvoiceAddForm createVO) {
        RequestUser requestUser = SmartRequestUtil.getRequestUser();
        createVO.setCreateUserId(requestUser.getUserId());
        createVO.setCreateUserName(requestUser.getUserName());
        return invoiceService.createInvoice(createVO);
    }

    @ApiOperation(value = "编辑发票信息 @author 善逸")
    @PostMapping("/oa/invoice/update")
    public ResponseDTO<String> updateInvoice(@RequestBody @Valid InvoiceUpdateForm updateVO) {
        return invoiceService.updateInvoice(updateVO);
    }

    @ApiOperation(value = "删除发票信息 @author 善逸")
    @GetMapping("/invoice/delete/{invoiceId}")
    public ResponseDTO<String> deleteInvoice(@PathVariable Long invoiceId) {
        return invoiceService.deleteInvoice(invoiceId);
    }

    @ApiOperation(value = "查询列表 @author lidoudou")
    @GetMapping("/oa/invoice/query/list/{enterpriseId}")
    public ResponseDTO<List<InvoiceVO>> queryList(@PathVariable Long enterpriseId) {
        return invoiceService.queryList(enterpriseId);
    }


}

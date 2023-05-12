package org.person.sa.admin.module.business.oa.invoice;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.extern.slf4j.Slf4j;
import org.person.sa.admin.module.business.oa.enterprise.EnterpriseService;
import org.person.sa.admin.module.business.oa.enterprise.domain.vo.EnterpriseVO;
import org.person.sa.admin.module.business.oa.invoice.domain.*;
import org.person.sa.common.common.domain.PageResult;
import org.person.sa.common.common.domain.ResponseDTO;
import org.person.sa.common.common.util.SmartBeanUtil;
import org.person.sa.common.common.util.SmartPageUtil;
import org.person.sa.common.module.support.datatracer.constant.DataTracerConst;
import org.person.sa.common.module.support.datatracer.constant.DataTracerTypeEnum;
import org.person.sa.common.module.support.datatracer.service.DataTracerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;

/**
 * OA发票信息
 *
 * @Author 1024创新实验室: 善逸
 * @Date 2022-06-23 19:32:59
 * @Wechat wcchen96
 * @Email 15793730318@163.com
 */
@Service
@Slf4j
public class InvoiceService {

    @Autowired
    private InvoiceDao invoiceDao;

    @Autowired
    private EnterpriseService enterpriseService;

    @Autowired
    private DataTracerService dataTracerService;

    /**
     * 分页查询发票信息
     *
     * @param queryDTO
     * @return
     */
    public ResponseDTO<PageResult<InvoiceVO>> queryByPage(InvoiceQueryForm queryDTO) {
        queryDTO.setDeletedFlag(Boolean.FALSE);
        Page<?> page = SmartPageUtil.convert2PageQuery(queryDTO);
        List<InvoiceVO> invoiceVOS = invoiceDao.queryPage(page, queryDTO);
        PageResult<InvoiceVO> pageResult = SmartPageUtil.convert2PageResult(page, invoiceVOS);
        return ResponseDTO.ok(pageResult);
    }

    public ResponseDTO<List<InvoiceVO>> queryList(Long enterpriseId) {
        InvoiceQueryForm queryForm = new InvoiceQueryForm();
        queryForm.setDeletedFlag(Boolean.FALSE);
        queryForm.setDisabledFlag(Boolean.FALSE);
        queryForm.setEnterpriseId(enterpriseId);
        List<InvoiceVO> invoiceList = invoiceDao.queryPage(null, queryForm);
        return ResponseDTO.ok(invoiceList);
    }

    /**
     * 查询发票信息详情
     *
     * @param invoiceId
     * @return
     */
    public ResponseDTO<InvoiceVO> getDetail(Long invoiceId) {
        // 校验发票信息是否存在
        InvoiceVO invoiceVO = invoiceDao.getDetail(invoiceId, Boolean.FALSE);
        if (Objects.isNull(invoiceVO)) {
            return ResponseDTO.userErrorParam("发票信息不存在");
        }
        return ResponseDTO.ok(invoiceVO);
    }

    /**
     * 新建发票信息
     *
     * @param createVO
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    public ResponseDTO<String> createInvoice(InvoiceAddForm createVO) {
        Long enterpriseId = createVO.getEnterpriseId();
        // 校验企业是否存在
        EnterpriseVO enterpriseVO = enterpriseService.getDetail(enterpriseId);
        if (Objects.isNull(enterpriseVO)) {
            return ResponseDTO.userErrorParam("企业不存在");
        }
        // 验证发票信息账号是否重复
        InvoiceEntity validateInvoice = invoiceDao.queryByAccountNumber(enterpriseId, createVO.getAccountNumber(), null, Boolean.FALSE);
        if (Objects.nonNull(validateInvoice)) {
            return ResponseDTO.userErrorParam("发票信息账号重复");
        }
        // 数据插入
        InvoiceEntity insertInvoice = SmartBeanUtil.copy(createVO, InvoiceEntity.class);
        invoiceDao.insert(insertInvoice);
        dataTracerService.addTrace(enterpriseId, DataTracerTypeEnum.OA_ENTERPRISE, "新增发票：" + DataTracerConst.HTML_BR + dataTracerService.getChangeContent(insertInvoice));
        return ResponseDTO.ok();
    }

    /**
     * 编辑发票信息
     *
     * @param updateVO
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    public ResponseDTO<String> updateInvoice(InvoiceUpdateForm updateVO) {
        Long enterpriseId = updateVO.getEnterpriseId();
        // 校验企业是否存在
        EnterpriseVO enterpriseVO = enterpriseService.getDetail(enterpriseId);
        if (Objects.isNull(enterpriseVO)) {
            return ResponseDTO.userErrorParam("企业不存在");
        }
        Long invoiceId = updateVO.getInvoiceId();
        // 校验发票信息是否存在
        InvoiceEntity invoiceDetail = invoiceDao.selectById(invoiceId);
        if (Objects.isNull(invoiceDetail) || invoiceDetail.getDeletedFlag()) {
            return ResponseDTO.userErrorParam("发票信息不存在");
        }
        // 验证发票信息账号是否重复
        InvoiceEntity validateInvoice = invoiceDao.queryByAccountNumber(updateVO.getEnterpriseId(), updateVO.getAccountNumber(), invoiceId, Boolean.FALSE);
        if (Objects.nonNull(validateInvoice)) {
            return ResponseDTO.userErrorParam("发票信息账号重复");
        }
        // 数据编辑
        InvoiceEntity updateInvoice = SmartBeanUtil.copy(updateVO, InvoiceEntity.class);
        invoiceDao.updateById(updateInvoice);
        dataTracerService.addTrace(enterpriseId, DataTracerTypeEnum.OA_ENTERPRISE, "更新发票：" + DataTracerConst.HTML_BR + dataTracerService.getChangeContent(invoiceDetail, updateInvoice));
        return ResponseDTO.ok();
    }


    /**
     * 删除发票信息

     * @param invoiceId
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    public ResponseDTO<String> deleteInvoice(Long invoiceId) {
        // 校验发票信息是否存在
        InvoiceEntity invoiceDetail = invoiceDao.selectById(invoiceId);
        if (Objects.isNull(invoiceDetail) || invoiceDetail.getDeletedFlag()) {
            return ResponseDTO.userErrorParam("发票信息不存在");
        }
        invoiceDao.deleteInvoice(invoiceId, Boolean.TRUE);
        dataTracerService.addTrace(invoiceDetail.getEnterpriseId(), DataTracerTypeEnum.OA_ENTERPRISE, "删除发票：" + DataTracerConst.HTML_BR + dataTracerService.getChangeContent(invoiceDetail));
        return ResponseDTO.ok();
    }
}

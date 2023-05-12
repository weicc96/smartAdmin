package org.person.sa.admin.module.business.oa.bank;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.person.sa.admin.module.business.oa.bank.domain.BankEntity;
import org.person.sa.admin.module.business.oa.bank.domain.BankQueryForm;
import org.person.sa.admin.module.business.oa.bank.domain.BankVO;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * OA办公-OA银行信息
 *
 * @Author 1024创新实验室:善逸
 * @Date 2022/6/23 21:59:22
 * @Wechat wcchen96
 * @Email 15793730318@163.com
 */
@Mapper
@Component
public interface BankDao extends BaseMapper<BankEntity> {

    /**
     * 根据账号查询
     * @param enterpriseId
     * @param accountNumber
     * @param excludeBankId
     * @param deletedFlag
     * @return
     */
    BankEntity queryByAccountNumber(@Param("enterpriseId") Long enterpriseId, @Param("accountNumber") String accountNumber, @Param("excludeBankId") Long excludeBankId, @Param("deletedFlag") Boolean deletedFlag);

    /**
     * 删除银行信息
     *
     * @param bankId
     * @param deletedFlag
     */
    void deleteBank(@Param("bankId") Long bankId, @Param("deletedFlag") Boolean deletedFlag);

    /**
     * 银行信息分页查询
     *
     * @param page
     * @param queryForm
     * @return
     */
    List<BankVO> queryPage(Page page, @Param("queryForm") BankQueryForm queryForm);

    /**
     * 查询银行信息详情
     * @param bankId
     * @param deletedFlag
     * @return
     */
    BankVO getDetail(@Param("bankId") Long bankId, @Param("deletedFlag") Boolean deletedFlag);
}

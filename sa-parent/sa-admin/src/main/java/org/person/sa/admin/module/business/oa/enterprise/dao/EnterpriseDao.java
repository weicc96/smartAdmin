package org.person.sa.admin.module.business.oa.enterprise.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.person.sa.admin.module.business.oa.enterprise.domain.entity.EnterpriseEntity;
import org.person.sa.admin.module.business.oa.enterprise.domain.form.EnterpriseQueryForm;
import org.person.sa.admin.module.business.oa.enterprise.domain.vo.EnterpriseListVO;
import org.person.sa.admin.module.business.oa.enterprise.domain.vo.EnterpriseVO;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 企业
 *
 * @Author 1024创新实验室: 开云
 * @Date 2022/7/28 20:37:15
 * @Wechat wcchen96
 * @Email 15793730318@163.com
 */
@Mapper
@Component
public interface EnterpriseDao extends BaseMapper<EnterpriseEntity> {

    /**
     * 根据企业名称查询
     *
     * @param enterpriseName
     * @param excludeEnterpriseId
     * @param deletedFlag
     * @return
     */
    EnterpriseEntity queryByEnterpriseName(@Param("enterpriseName") String enterpriseName, @Param("excludeEnterpriseId") Long excludeEnterpriseId, @Param("deletedFlag") Boolean deletedFlag);

    /**
     * 删除企业
     *
     * @param enterpriseId
     * @param deletedFlag
     */
    void deleteEnterprise(@Param("enterpriseId") Long enterpriseId, @Param("deletedFlag") Boolean deletedFlag);

    /**
     * 企业分页查询
     *
     * @param page
     * @param queryForm
     * @return
     */
    List<EnterpriseVO> queryPage(Page page, @Param("queryForm") EnterpriseQueryForm queryForm);

    /**
     * 查询企业详情
     *
     * @param enterpriseId
     * @return
     */
    EnterpriseVO getDetail(@Param("enterpriseId") Long enterpriseId, @Param("deletedFlag") Boolean deletedFlag);

    /**
     * 查询列表
     *
     * @param type
     * @param disabledFlag
     * @param deletedFlag
     * @return
     */
    List<EnterpriseListVO> queryList(@Param("type") Integer type, @Param("disabledFlag") Boolean disabledFlag, @Param("deletedFlag") Boolean deletedFlag);
}

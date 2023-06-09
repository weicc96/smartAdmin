package org.person.sa.common.module.support.changelog.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.commons.collections4.CollectionUtils;
import org.person.sa.common.common.domain.PageResult;
import org.person.sa.common.common.domain.ResponseDTO;
import org.person.sa.common.common.util.SmartBeanUtil;
import org.person.sa.common.common.util.SmartPageUtil;
import org.person.sa.common.module.support.changelog.dao.ChangeLogDao;
import org.person.sa.common.module.support.changelog.domain.entity.ChangeLogEntity;
import org.person.sa.common.module.support.changelog.domain.form.ChangeLogAddForm;
import org.person.sa.common.module.support.changelog.domain.form.ChangeLogQueryForm;
import org.person.sa.common.module.support.changelog.domain.form.ChangeLogUpdateForm;
import org.person.sa.common.module.support.changelog.domain.vo.ChangeLogVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 系统更新日志 Service
 *
 * @author weicc
 * @Date 2022-09-26 14:53:50
 * @Copyright 1024创新实验室
 */

@Service
public class ChangeLogService {

    @Autowired
    private ChangeLogDao changeLogDao;

    /**
     * 分页查询
     *
     * @param queryForm
     * @return
     */
    public PageResult<ChangeLogVO> queryPage(ChangeLogQueryForm queryForm) {
        Page<?> page = SmartPageUtil.convert2PageQuery(queryForm);
        List<ChangeLogVO> list = changeLogDao.queryPage(page, queryForm);
        PageResult<ChangeLogVO> pageResult = SmartPageUtil.convert2PageResult(page, list);
        return pageResult;
    }

    /**
     * 添加
     */
    public synchronized ResponseDTO<String> add(ChangeLogAddForm addForm) {
        ChangeLogEntity existVersion = changeLogDao.selectByVersion(addForm.getVersion());
        if (existVersion != null) {
            return ResponseDTO.userErrorParam("此版本已经存在");
        }

        ChangeLogEntity changeLogEntity = SmartBeanUtil.copy(addForm, ChangeLogEntity.class);
        changeLogDao.insert(changeLogEntity);
        return ResponseDTO.ok();
    }

    /**
     * 更新
     *
     * @param updateForm
     * @return
     */
    public synchronized ResponseDTO<String> update(ChangeLogUpdateForm updateForm) {
        ChangeLogEntity existVersion = changeLogDao.selectByVersion(updateForm.getVersion());
        if (existVersion != null && !updateForm.getChangeLogId().equals(existVersion.getChangeLogId())) {
            return ResponseDTO.userErrorParam("此版本已经存在");
        }
        ChangeLogEntity changeLogEntity = SmartBeanUtil.copy(updateForm, ChangeLogEntity.class);
        changeLogDao.updateById(changeLogEntity);
        return ResponseDTO.ok();
    }

    /**
     * 批量删除
     *
     * @param idList
     * @return
     */
    public synchronized ResponseDTO<String> batchDelete(List<Long> idList) {
        if (CollectionUtils.isEmpty(idList)) {
            return ResponseDTO.ok();
        }

        changeLogDao.deleteBatchIds(idList);
        return ResponseDTO.ok();
    }

    /**
     * 单个删除
     */
    public synchronized ResponseDTO<String> delete(Long changeLogId) {
        if (null == changeLogId) {
            return ResponseDTO.ok();
        }

        changeLogDao.deleteById(changeLogId);
        return ResponseDTO.ok();
    }
}

package org.person.sa.common.module.support.serialnumber.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.person.sa.common.common.domain.PageResult;
import org.person.sa.common.common.util.SmartPageUtil;
import org.person.sa.common.module.support.serialnumber.dao.SerialNumberRecordDao;
import org.person.sa.common.module.support.serialnumber.domain.SerialNumberRecordEntity;
import org.person.sa.common.module.support.serialnumber.domain.SerialNumberRecordQueryForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 单据序列号 记录
 *
 * @Author 1024创新实验室-主任: 卓大
 * @Date 2022-03-25 21:46:07
 * @Wechat wcchen96
 * @Email 15793730318@163.com
 * @Copyright 1024创新实验室 （ https://1024lab.net ）
 */
@Service
public class SerialNumberRecordService {

    @Autowired
    private SerialNumberRecordDao serialNumberRecordDao;

    public PageResult<SerialNumberRecordEntity> query(SerialNumberRecordQueryForm queryForm) {
        Page page = SmartPageUtil.convert2PageQuery(queryForm);
        List<SerialNumberRecordEntity> recordList = serialNumberRecordDao.query(page, queryForm);
        return SmartPageUtil.convert2PageResult(page, recordList);
    }
}

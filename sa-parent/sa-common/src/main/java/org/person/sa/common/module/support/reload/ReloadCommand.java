package org.person.sa.common.module.support.reload;

import org.person.sa.common.common.util.SmartBeanUtil;
import org.person.sa.common.module.support.reload.core.AbstractSmartReloadCommand;
import org.person.sa.common.module.support.reload.core.domain.SmartReloadItem;
import org.person.sa.common.module.support.reload.core.domain.SmartReloadResult;
import org.person.sa.common.module.support.reload.dao.ReloadItemDao;
import org.person.sa.common.module.support.reload.dao.ReloadResultDao;
import org.person.sa.common.module.support.reload.domain.ReloadItemEntity;
import org.person.sa.common.module.support.reload.domain.ReloadResultEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * reload 操作
 *
 * @Author 1024创新实验室-主任: 卓大
 * @Date 2015-03-02 19:11:52
 * @Wechat wcchen96
 * @Email 15793730318@163.com
 * @Copyright 1024创新实验室 （ https://1024lab.net ）
 */
@Component
public class ReloadCommand extends AbstractSmartReloadCommand {

    @Autowired
    private ReloadItemDao reloadItemDao;

    @Autowired
    private ReloadResultDao reloadResultDao;

    /**
     * 读取数据库中SmartReload项
     *
     * @return List<ReloadItem>
     */
    @Override
    public List<SmartReloadItem> readReloadItem() {
        List<ReloadItemEntity> reloadItemEntityList = reloadItemDao.selectList(null);
        return SmartBeanUtil.copyList(reloadItemEntityList, SmartReloadItem.class);
    }


    /**
     * 保存reload结果
     *
     * @param smartReloadResult
     */
    @Override
    public void handleReloadResult(SmartReloadResult smartReloadResult) {
        ReloadResultEntity reloadResultEntity = SmartBeanUtil.copy(smartReloadResult, ReloadResultEntity.class);
        reloadResultDao.insert(reloadResultEntity);
    }
}

package org.person.sa.admin.module.system.datascope.strategy;

import org.person.sa.admin.module.system.datascope.constant.DataScopeViewTypeEnum;
import org.person.sa.admin.module.system.datascope.domain.DataScopeSqlConfig;

import java.util.Map;

/**
 * 数据范围策略 ,使用DataScopeWhereInTypeEnum.CUSTOM_STRATEGY类型，DataScope注解的joinSql属性无用
 *
 * @Author 1024创新实验室: 罗伊
 * @Date 2020/11/28  20:59:17
 * @Wechat wcchen96
 * @Email 15793730318@163.com
 * @Copyright 1024创新实验室 （ https://1024lab.net ）
 */
public abstract class DataScopePowerStrategy {

    /**
     * 获取joinsql 字符串
     * @param viewTypeEnum
     * @param paramMap
     * @param sqlConfigDTO
     * @return
     */
    public abstract String getCondition(DataScopeViewTypeEnum viewTypeEnum, Map<String, Object> paramMap, DataScopeSqlConfig sqlConfigDTO);
}

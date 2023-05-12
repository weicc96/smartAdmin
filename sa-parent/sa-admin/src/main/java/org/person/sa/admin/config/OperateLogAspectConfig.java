package org.person.sa.admin.config;

import org.person.sa.common.module.support.operatelog.core.OperateLogAspect;
import org.person.sa.common.module.support.operatelog.core.OperateLogConfig;
import org.springframework.context.annotation.Configuration;

/**
 * 操作日志切面 配置
 *
 * @Author 1024创新实验室: 罗伊
 * @Date 2022-05-30 21:22:12
 * @Wechat wcchen96
 * @Email 15793730318@163.com
 * @Copyright 1024创新实验室 （ https://1024lab.net ）
 */
@Configuration
public class OperateLogAspectConfig extends OperateLogAspect{

    /**
     * 配置信息
     * @return
     */
    @Override
    public OperateLogConfig getOperateLogConfig() {
        OperateLogConfig config = OperateLogConfig.builder().corePoolSize(4).queueCapacity(1000).build();
        return config;
    }


}
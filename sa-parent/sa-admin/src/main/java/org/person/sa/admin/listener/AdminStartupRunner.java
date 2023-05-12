package org.person.sa.admin.listener;

import lombok.extern.slf4j.Slf4j;
import org.person.sa.common.common.code.ErrorCodeRegister;
import org.person.sa.common.config.ScheduleConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * admin 应用启动加载
 *
 * @Author weicc
 * @Date 2021-08-26 18:46:32
 * @Wechat wcchen96
 * @Email 15793730318@163.com
 */
@Slf4j
@Component
public class AdminStartupRunner implements CommandLineRunner {

    @Autowired
    private ScheduleConfig scheduleConfig;

    @Override
    public void run(String... args) {

        // 初始化状态码
        int codeCount = ErrorCodeRegister.initialize();

        //TODO ：根据实际情况来决定是否开启定时任务
        String destroySchedules = "Spring 定时任务 @Schedule 已启动";
//        destroySchedules = scheduleConfig.destroy();

        log.info("\n ---------------ErrorCode 共计完成初始化： {}个！---------------" +
                 "\n ---------------{}---------------\n", codeCount, destroySchedules);

    }
}
package org.person.sa.common.module.support.heartbeat.domain;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.person.sa.common.common.domain.PageParam;

import java.time.LocalDate;

/**
 * 心跳记录 查询
 *
 * @Author 1024创新实验室-主任: 卓大
 * @Date 2022-01-09 20:57:24
 * @Wechat wcchen96
 * @Email 15793730318@163.com
 * @Copyright 1024创新实验室 （ https://1024lab.net ）
 */
@Data
public class HeartBeatRecordQueryForm extends PageParam {

    @ApiModelProperty("关键字")
    private String keywords;

    @ApiModelProperty("开始日期")
    private LocalDate startDate;

    @ApiModelProperty("结束日期")
    private LocalDate endDate;

}

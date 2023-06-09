package org.person.sa.common.module.support.serialnumber.domain;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.person.sa.common.common.domain.PageParam;

import javax.validation.constraints.NotNull;

/**
 * 单据序列号 生成记录 查询
 *
 * @Author 1024创新实验室-主任: 卓大
 * @Date 2022-03-25 21:46:07
 * @Wechat wcchen96
 * @Email 15793730318@163.com
 * @Copyright 1024创新实验室 （ https://1024lab.net ）
 */
@Data
public class SerialNumberRecordQueryForm extends PageParam {

    @ApiModelProperty("单号id")
    @NotNull(message = "单号id不能为空")
    private Integer serialNumberId;
}

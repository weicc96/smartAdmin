package org.person.sa.common.module.support.loginlog.domain;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.person.sa.common.common.domain.PageParam;

/**
 * 登录查询日志
 *
 * @Author 1024创新实验室-主任: 卓大
 * @Date 2022/07/22 19:46:23
 * @Wechat wcchen96
 * @Email 15793730318@163.com
 * @Copyright 1024创新实验室 （ https://1024lab.net ）
 */
@Data
public class LoginLogQueryForm extends PageParam {

    @ApiModelProperty("开始日期")
    private String startDate;

    @ApiModelProperty("结束日期")
    private String endDate;

    @ApiModelProperty("用户名称")
    private String userName;

    @ApiModelProperty("ip")
    private String ip;

}

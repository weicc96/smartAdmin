package org.person.sa.common.module.support.loginlog.domain;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.person.sa.common.common.enumeration.UserTypeEnum;
import org.person.sa.common.common.swagger.ApiModelPropertyEnum;
import org.person.sa.common.module.support.loginlog.LoginLogResultEnum;

import java.time.LocalDateTime;

/**
 * 登录日志
 *
 * @Author 1024创新实验室-主任: 卓大
 * @Date 2022/07/22 19:46:23
 * @Wechat wcchen96
 * @Email 15793730318@163.com
 * @Copyright 1024创新实验室 （ https://1024lab.net ）
 */
@Data
public class LoginLogVO {

    private Long loginLogId;

    @ApiModelProperty("用户id")
    private Long userId;

    @ApiModelPropertyEnum(value = UserTypeEnum.class, desc = "用户类型")
    private Integer userType;

    @ApiModelProperty("用户名")
    private String userName;

    @ApiModelProperty("登录ip")
    private String loginIp;

    @ApiModelProperty("user-agent")
    private String userAgent;

    @ApiModelProperty("remark")
    private String remark;

    @ApiModelPropertyEnum(LoginLogResultEnum.class)
    private Integer loginResult;

    private LocalDateTime createTime;

}

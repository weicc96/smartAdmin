package org.person.sa.admin.module.system.role.domain.form;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.person.sa.common.common.domain.PageParam;

/**
 * 角色 查询
 *
 * @Author 1024创新实验室: 胡克
 * @Date 2022-02-26 19:09:42
 * @Wechat wcchen96
 * @Email 15793730318@163.com
 * @Copyright 1024创新实验室 （ https://1024lab.net ）
 */
@Data
public class RoleQueryForm extends PageParam {

    @ApiModelProperty("角色名称")
    private String roleName;

    @ApiModelProperty("角色id")
    private String roleId;
}

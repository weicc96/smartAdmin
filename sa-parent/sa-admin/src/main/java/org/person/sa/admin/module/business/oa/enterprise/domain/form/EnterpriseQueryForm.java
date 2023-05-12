package org.person.sa.admin.module.business.oa.enterprise.domain.form;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.validator.constraints.Length;
import org.person.sa.common.common.domain.PageParam;

import java.time.LocalDate;

/**
 * OA企业模块分页查询
 *
 * @Author 1024创新实验室: 开云
 * @Date 2022/7/28 20:37:15
 * @Wechat wcchen96
 * @Email 15793730318@163.com
 */
@Data
public class EnterpriseQueryForm extends PageParam {

    @ApiModelProperty("关键字")
    @Length(max = 200, message = "关键字最多200字符")
    private String keywords;

    @ApiModelProperty("开始时间")
    private LocalDate startTime;

    @ApiModelProperty("结束时间")
    private LocalDate endTime;

    @ApiModelProperty("禁用状态")
    private Boolean disabledFlag;

    @ApiModelProperty(value = "删除状态", hidden = true)
    private Boolean deletedFlag;

}

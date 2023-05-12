package org.person.sa.admin.module.business.oa.enterprise.domain.form;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * 企业员工
 *
 * @Author 1024创新实验室: 罗伊
 * @Date 2022/7/28 20:37:15
 * @Wechat wcchen96
 * @Email 15793730318@163.com
 */
@Data
public class EnterpriseEmployeeForm {

    @ApiModelProperty("企业id")
    @NotNull(message = "企业id不能为空")
    private Long enterpriseId;

    @ApiModelProperty("员工信息id")
    @NotEmpty(message = "员工信息id不能为空")
    private List<Long> employeeIdList;
}
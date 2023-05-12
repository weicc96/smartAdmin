package org.person.sa.admin.module.business.oa.bank.domain;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * OA办公-银行信息更新
 *
 * @Author 1024创新实验室:善逸
 * @Date 2022/6/23 21:59:22
 * @Wechat wcchen96
 * @Email 15793730318@163.com
 */
@Data
public class BankUpdateForm extends BankCreateForm {

    @ApiModelProperty("银行信息ID")
    @NotNull(message = "银行信息ID不能为空")
    private Long bankId;
}

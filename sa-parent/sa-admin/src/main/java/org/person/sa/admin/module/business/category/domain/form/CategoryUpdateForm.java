package org.person.sa.admin.module.business.category.domain.form;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * 类目 更新
 *
 * @Author 1024创新实验室: 胡克
 * @Date 2021/08/05 21:26:58
 * @Wechat wcchen96
 * @Email 15793730318@163.com
 */
@Data
public class CategoryUpdateForm extends CategoryAddForm {

    @ApiModelProperty("类目id")
    @NotNull(message = "类目id不能为空")
    private Long categoryId;
}

package org.person.sa.admin.module.business.category.domain.form;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.validator.constraints.Length;
import org.person.sa.admin.module.business.category.constant.CategoryTypeEnum;
import org.person.sa.common.common.swagger.ApiModelPropertyEnum;
import org.person.sa.common.common.validator.enumeration.CheckEnum;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * 类目 添加
 *
 * @Author 1024创新实验室: 胡克
 * @Date 2021/08/05 21:26:58
 * @Wechat wcchen96
 * @Email 15793730318@163.com
 */
@Data
public class CategoryAddForm {

    @ApiModelProperty(value = "类目名称", required = true)
    @NotBlank(message = "类目名称不能为空")
    @Length(max = 20, message = "类目名称最多20字符")
    private String categoryName;

    @ApiModelPropertyEnum(desc = "分类类型", value = CategoryTypeEnum.class)
    @CheckEnum(value = CategoryTypeEnum.class, required = true, message = "分类错误")
    private Integer categoryType;

    @ApiModelProperty("父级类目id|可选")
    private Long parentId;

    @ApiModelProperty("排序|可选")
    private Integer sort;

    @ApiModelProperty("备注|可选")
    @Length(max = 200, message = "备注最多200字符")
    private String remark;

    @ApiModelProperty("禁用状态")
    @NotNull(message = "禁用状态不能为空")
    private Boolean disabledFlag;

}

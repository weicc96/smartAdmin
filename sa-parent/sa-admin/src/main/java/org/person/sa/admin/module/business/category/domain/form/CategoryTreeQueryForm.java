package org.person.sa.admin.module.business.category.domain.form;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.person.sa.admin.module.business.category.constant.CategoryTypeEnum;
import org.person.sa.common.common.swagger.ApiModelPropertyEnum;

/**
 * 类目 层级树查询
 *
 * @Author 1024创新实验室: 胡克
 * @Date 2021/08/05 21:26:58
 * @Wechat wcchen96
 * @Email 15793730318@163.com
 */
@Data
public class CategoryTreeQueryForm {

    @ApiModelPropertyEnum(desc = "分类类型|可选", value = CategoryTypeEnum.class)
    private Integer categoryType;

    @ApiModelProperty("父级类目id|可选")
    private Long parentId;
}

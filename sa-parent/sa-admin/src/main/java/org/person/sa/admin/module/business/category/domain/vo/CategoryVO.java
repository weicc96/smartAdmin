package org.person.sa.admin.module.business.category.domain.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.person.sa.admin.module.business.category.constant.CategoryTypeEnum;
import org.person.sa.common.common.swagger.ApiModelPropertyEnum;

import java.time.LocalDateTime;

/**
 * 类目
 *
 * @Author 1024创新实验室: 胡克
 * @Date 2021/08/05 21:26:58
 * @Wechat wcchen96
 * @Email 15793730318@163.com
 */
@Data
public class CategoryVO {

    @ApiModelProperty(value = "类目名称", required = true)
    private String categoryName;

    @ApiModelPropertyEnum(desc = "分类类型", value = CategoryTypeEnum.class)
    private Integer categoryType;

    @ApiModelProperty("父级类目id|可选")
    private Long parentId;

    @ApiModelProperty("排序|可选")
    private Integer sort;

    @ApiModelProperty("备注|可选")
    private String remark;

    @ApiModelProperty("禁用状态")
    private Boolean disabledFlag;

    @ApiModelProperty("类目id")
    private Long categoryId;

    private LocalDateTime updateTime;

    private LocalDateTime createTime;
}

package org.person.sa.admin.module.business.goods.domain.form;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.validator.constraints.Length;
import org.person.sa.admin.module.business.goods.constant.GoodsStatusEnum;
import org.person.sa.common.common.domain.PageParam;
import org.person.sa.common.common.swagger.ApiModelPropertyEnum;
import org.person.sa.common.common.validator.enumeration.CheckEnum;

/**
 * 商品 分页查询
 *
 * @Author 1024创新实验室: 胡克
 * @Date 2021-10-25 20:26:54
 * @Wechat wcchen96
 * @Email 15793730318@163.com
 */
@Data
public class GoodsQueryForm extends PageParam {

    @ApiModelProperty("商品分类")
    private Integer categoryId;

    @ApiModelProperty("搜索词")
    @Length(max = 30, message = "搜索词最多30字符")
    private String searchWord;

    @ApiModelPropertyEnum(GoodsStatusEnum.class)
    @CheckEnum(message = "商品状态错误", value = GoodsStatusEnum.class, required = false)
    private Integer goodsStatus;

    @ApiModelProperty("产地")
    private String place;

    @ApiModelProperty("上架状态")
    private Boolean shelvesFlag;

    @ApiModelProperty(hidden = true)
    private Boolean deletedFlag;
}

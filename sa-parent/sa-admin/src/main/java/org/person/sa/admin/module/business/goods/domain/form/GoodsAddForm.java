package org.person.sa.admin.module.business.goods.domain.form;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.person.sa.admin.module.business.goods.constant.GoodsStatusEnum;
import org.person.sa.common.common.json.deserializer.DictValueVoDeserializer;
import org.person.sa.common.common.swagger.ApiModelPropertyEnum;
import org.person.sa.common.common.validator.enumeration.CheckEnum;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

/**
 * 商品 添加表单
 *
 * @Author 1024创新实验室: 胡克
 * @Date 2021-10-25 20:26:54
 * @Wechat wcchen96
 * @Email 15793730318@163.com
 */
@Data
public class GoodsAddForm {

    @ApiModelProperty("商品分类")
    @NotNull(message = "商品分类不能为空")
    private Long categoryId;

    @ApiModelProperty("商品名称")
    @NotBlank(message = "商品名称不能为空")
    private String goodsName;

    @ApiModelPropertyEnum(GoodsStatusEnum.class)
    @CheckEnum(message = "商品状态错误", value = GoodsStatusEnum.class, required = true)
    private Integer goodsStatus;

    @ApiModelProperty("产地")
    @NotBlank(message = "产地 不能为空 ")
    @JsonDeserialize(using = DictValueVoDeserializer.class)
    private String place;

    @ApiModelProperty("商品价格")
    @NotNull(message = "商品价格不能为空")
    @DecimalMin(value = "0", message = "商品价格最低0")
    private BigDecimal price;

    @ApiModelProperty("上架状态")
    @NotNull(message = "上架状态不能为空")
    private Boolean shelvesFlag;

    @ApiModelProperty("备注|可选")
    private String remark;
}

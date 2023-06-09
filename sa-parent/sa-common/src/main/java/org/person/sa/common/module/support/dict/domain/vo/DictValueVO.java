package org.person.sa.common.module.support.dict.domain.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 字典
 *
 * @Author 1024创新实验室: 罗伊
 * @Date 2022/5/26 19:40:55
 * @Wechat wcchen96
 * @Email 15793730318@163.com
 * @Copyright 1024创新实验室 （ https://1024lab.net ）
 */
@Data
public class DictValueVO {

    @ApiModelProperty("valueId")
    private Long dictValueId;

    @ApiModelProperty("dictKeyId")
    private Long dictKeyId;

    @ApiModelProperty("编码")
    private String valueCode;

    @ApiModelProperty("名称")
    private String valueName;

    @ApiModelProperty("排序")
    private Integer sort;

    @ApiModelProperty("备注")
    private String remark;
}

package org.person.sa.common.module.support.codegenerator.domain.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 列
 *
 * @Author weicc
 * @Date 2022/9/21 21:07:58
 * @Wechat wcchen96
 * @Email 15793730318@163.com
 */

@Data
public class TableColumnVO {

    @ApiModelProperty("列名")
    private String columnName;

    @ApiModelProperty("列描述")
    private String columnComment;

    @ApiModelProperty("columnKey")
    private String columnKey;

    @ApiModelProperty("extra")
    private String extra;

    @ApiModelProperty("是否为空")
    private String isNullable;

    @ApiModelProperty("数据类型varchar")
    private String dataType;

    @ApiModelProperty("列类型varchar(50)")
    private String columnType;


}

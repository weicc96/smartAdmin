
package org.person.sa.common.module.support.codegenerator.domain.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * 表信息
 *
 * @Author weicc
 * @Date 2022/9/21 18:07:58
 * @Wechat wcchen96
 * @Email 15793730318@163.com
 */

@Data
public class TableVO {

    @ApiModelProperty("表名")
    private String tableName;

    @ApiModelProperty("表备注")
    private String tableComment;

    @ApiModelProperty("创建时间")
    private LocalDateTime createTime;

    @ApiModelProperty("更新时间")
    private LocalDateTime updateTime;

    @ApiModelProperty("配置时间")
    private LocalDateTime configTime;

}

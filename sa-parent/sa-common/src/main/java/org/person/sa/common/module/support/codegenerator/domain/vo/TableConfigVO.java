
package org.person.sa.common.module.support.codegenerator.domain.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.person.sa.common.module.support.codegenerator.domain.model.*;

import java.util.List;

/**
 * 表的配置信息
 *
 * @Author weicc
 * @Date 2022/9/21 21:07:58
 * @Wechat wcchen96
 * @Email 15793730318@163.com
 */

@Data
public class TableConfigVO {

    @ApiModelProperty("基础命名信息")
    private CodeBasic basic;

    @ApiModelProperty("字段列")
    private List<CodeField> fields;

    @ApiModelProperty("增加、修改 信息")
    private CodeInsertAndUpdate insertAndUpdate;

    @ApiModelProperty("删除 信息")
    private CodeDelete deleteInfo;

    @ApiModelProperty("查询字段")
    private List<CodeQueryField> queryFields;

    @ApiModelProperty("列表字段")
    private List<CodeTableField> tableFields;
}

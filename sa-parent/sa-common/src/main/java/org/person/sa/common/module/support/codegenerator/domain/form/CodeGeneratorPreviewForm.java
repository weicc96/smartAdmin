package org.person.sa.common.module.support.codegenerator.domain.form;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * 代码生成 预览 表单
 *
 * @Author 1024创新实验室-主任: 卓大
 * @Date 2022/6/23 23:20:46
 * @Wechat wcchen96
 * @Email 15793730318@163.com
 */
@Data
public class CodeGeneratorPreviewForm {

    @NotBlank(message = "模板文件 不能为空")
    @ApiModelProperty("模板文件")
    private String templateFile;

    @NotBlank(message = "表名 不能为空")
    @ApiModelProperty("表名")
    private String tableName;

}

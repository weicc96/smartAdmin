package org.person.sa.common.module.support.helpdoc.domain.form;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * 帮助文档 目录
 *
 * @Author 1024创新实验室-主任: 卓大
 * @Date 2022-08-20 23:11:42
 * @Wechat wcchen96
 * @Email 15793730318@163.com
 * @Copyright 1024创新实验室 （ https://1024lab.net ）
 */
@Data
public class HelpDocCatalogUpdateForm extends HelpDocCatalogAddForm {

    @ApiModelProperty("id")
    @NotNull(message = "id")
    private Long helpDocCatalogId;
}

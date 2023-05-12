package org.person.sa.common.module.support.helpdoc.domain.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 帮助文档的 目录
 *
 * @Author 1024创新实验室-主任: 卓大
 * @Date 2022-08-20 23:11:42
 * @Wechat wcchen96
 * @Email 15793730318@163.com
 * @Copyright 1024创新实验室 （ https://1024lab.net ）
 */
@Data
public class HelpDocCatalogVO {

    @ApiModelProperty("帮助文档目录id")
    private Long helpDocCatalogId;

    @ApiModelProperty("帮助文档目录-名称")
    private String name;

    @ApiModelProperty("帮助文档目录-父级id")
    private Long parentId;

    @ApiModelProperty("帮助文档目录-排序")
    private Integer sort;

}

package org.person.sa.common.module.support.file.domain.form;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.person.sa.common.common.domain.PageParam;
import org.person.sa.common.common.swagger.ApiModelPropertyEnum;
import org.person.sa.common.common.validator.enumeration.CheckEnum;
import org.person.sa.common.module.support.file.constant.FileFolderTypeEnum;

import java.time.LocalDate;

/**
 * 文件信息查询
 *
 * @Author 1024创新实验室: 罗伊
 * @Date 2019年10月11日 15:34:47
 * @Wechat wcchen96
 * @Email 15793730318@163.com
 * @Copyright 1024创新实验室 （ https://1024lab.net ）
 */
@Data
public class FileQueryForm extends PageParam {

    @ApiModelPropertyEnum(value = FileFolderTypeEnum.class, desc = "文件夹类型")
    @CheckEnum(value = FileFolderTypeEnum.class, message = "文件夹类型 错误")
    private Integer folderType;

    @ApiModelProperty(value = "文件名词")
    private String fileName;

    @ApiModelProperty(value = "文件Key")
    private String fileKey;

    @ApiModelProperty(value = "文件类型")
    private String fileType;

    @ApiModelProperty(value = "创建人")
    private String creatorName;

    @ApiModelProperty(value = "创建时间")
    private LocalDate createTimeBegin;

    @ApiModelProperty(value = "创建时间")
    private LocalDate createTimeEnd;

}

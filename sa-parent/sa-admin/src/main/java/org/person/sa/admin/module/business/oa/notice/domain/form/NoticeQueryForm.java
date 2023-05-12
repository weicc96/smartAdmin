package org.person.sa.admin.module.business.oa.notice.domain.form;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.person.sa.common.common.domain.PageParam;

import java.time.LocalDate;

/**
 * 通知公告 管理查询表单
 *
 * @Author 1024创新实验室-主任: 卓大
 * @Date 2022-08-12 21:40:39
 * @Wechat wcchen96
 * @Email 15793730318@163.com
 */
@Data
public class NoticeQueryForm extends PageParam {

    @ApiModelProperty("分类")
    private Long noticeTypeId;

    @ApiModelProperty("标题、作者、来源")
    private String keywords;

    @ApiModelProperty("文号")
    private String documentNumber;

    @ApiModelProperty("创建人")
    private Long createUserId;

    @ApiModelProperty("删除标识")
    private Boolean deletedFlag;

    @ApiModelProperty("创建-开始时间")
    private LocalDate createTimeBegin;

    @ApiModelProperty("创建-截止时间")
    private LocalDate createTimeEnd;

    @ApiModelProperty("发布-开始时间")
    private LocalDate publishTimeBegin;

    @ApiModelProperty("发布-截止时间")
    private LocalDate publishTimeEnd;

}

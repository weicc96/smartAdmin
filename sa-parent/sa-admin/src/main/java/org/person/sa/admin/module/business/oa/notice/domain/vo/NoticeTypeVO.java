package org.person.sa.admin.module.business.oa.notice.domain.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 通知公告 类型
 *
 * @Author 1024创新实验室-主任: 卓大
 * @Date 2022-08-12 21:40:39
 * @Wechat wcchen96
 * @Email 15793730318@163.com
 */
@Data
public class NoticeTypeVO {

    @ApiModelProperty("通知类型id")
    private Long noticeTypeId;

    @ApiModelProperty("通知类型-名称")
    private String noticeTypeName;

}

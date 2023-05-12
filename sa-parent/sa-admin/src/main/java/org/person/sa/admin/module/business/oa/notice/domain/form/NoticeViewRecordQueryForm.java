package org.person.sa.admin.module.business.oa.notice.domain.form;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.person.sa.common.common.domain.PageParam;

import javax.validation.constraints.NotNull;

/**
 * 通知公告 阅读记录查询
 *
 * @Author 1024创新实验室-主任: 卓大
 * @Date 2022-08-12 21:40:39
 * @Wechat wcchen96
 * @Email 15793730318@163.com
 */
@Data
public class NoticeViewRecordQueryForm extends PageParam {

    @ApiModelProperty("通知公告id")
    @NotNull(message = "通知公告id不能为空")
    private Long noticeId;

    @ApiModelProperty("部门id")
    private Long departmentId;

    @ApiModelProperty("关键字")
    private String keywords;


}

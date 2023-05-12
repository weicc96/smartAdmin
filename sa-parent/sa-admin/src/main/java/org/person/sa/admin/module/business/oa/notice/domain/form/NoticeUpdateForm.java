package org.person.sa.admin.module.business.oa.notice.domain.form;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * 通知公告 更新表单
 *
 * @Author 1024创新实验室-主任: 卓大
 * @Date 2022-08-12 21:40:39
 * @Wechat wcchen96
 * @Email 15793730318@163.com
 */
@Data
public class NoticeUpdateForm extends NoticeAddForm {

    @ApiModelProperty("id")
    @NotNull(message = "通知id不能为空")
    private Long noticeId;

}

package org.person.sa.admin.module.business.oa.notice.domain.form;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.person.sa.admin.module.business.oa.notice.constant.NoticeVisibleRangeDataTypeEnum;
import org.person.sa.common.common.swagger.ApiModelPropertyEnum;
import org.person.sa.common.common.validator.enumeration.CheckEnum;

import javax.validation.constraints.NotNull;

/**
 * 通知公告 可见范围数据
 *
 * @Author 1024创新实验室-主任: 卓大
 * @Date 2022-08-12 21:40:39
 * @Wechat wcchen96
 * @Email 15793730318@163.com
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class NoticeVisibleRangeForm {

    @ApiModelPropertyEnum(NoticeVisibleRangeDataTypeEnum.class)
    @CheckEnum(value = NoticeVisibleRangeDataTypeEnum.class, required = true, message = "数据类型错误")
    private Integer dataType;

    @ApiModelProperty("员工/部门id")
    @NotNull(message = "员工/部门id不能为空")
    private Long dataId;
}

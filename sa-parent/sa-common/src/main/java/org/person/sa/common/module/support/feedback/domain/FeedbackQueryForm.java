package org.person.sa.common.module.support.feedback.domain;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.validator.constraints.Length;
import org.person.sa.common.common.domain.PageParam;

import java.time.LocalDate;

/**
 * 意见反馈 查询
 *
 * @Author 1024创新实验室: 开云
 * @Date 2022-08-11 20:48:09
 * @Wechat wcchen96
 * @Email 15793730318@163.com
 * @Copyright 1024创新实验室 （ https://1024lab.net ）
 */
@Data
public class FeedbackQueryForm extends PageParam {

    @ApiModelProperty("搜索词")
    @Length(max = 25, message = "搜索词最多25字符")
    private String searchWord;

    @ApiModelProperty(value = "开始时间", example = "2021-02-14")
    private LocalDate startDate;

    @ApiModelProperty(value = "截止时间", example = "2022-10-15")
    private LocalDate endDate;
}

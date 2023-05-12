package org.person.sa.common.module.support.feedback.domain;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.person.sa.common.common.json.deserializer.FileKeyVoDeserializer;
import org.person.sa.common.common.json.serializer.FileKeyVoSerializer;

import javax.validation.constraints.NotBlank;

/**
 * 意见反馈 添加表单
 *
 * @Author 1024创新实验室: 开云
 * @Date 2022-08-11 20:48:09
 * @Wechat wcchen96
 * @Email 15793730318@163.com
 * @Copyright 1024创新实验室 （ https://1024lab.net ）
 */
@Data
public class FeedbackAddForm {

    @ApiModelProperty("反馈内容")
    @NotBlank(message = "反馈内容不能为空")
    private String feedbackContent;

    @ApiModelProperty("反馈图片")
    @JsonSerialize(using = FileKeyVoSerializer.class)
    @JsonDeserialize(using = FileKeyVoDeserializer.class)
    private String feedbackAttachment;

}

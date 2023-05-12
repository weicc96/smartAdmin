package org.person.sa.common.common.domain;

import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * 校验数据是否为空的包装类
 *
 * @Author 1024创新实验室: 胡克
 * @Date 2020/10/16 21:06:11
 * @Wechat wcchen96
 * @Email 15793730318@163.com
 * @Copyright 1024创新实验室 （ https://1024lab.net ）
 */
@Data
public class ValidateData<T> {

    @NotNull(message = "数据不能为空哦")
    private T data;
}
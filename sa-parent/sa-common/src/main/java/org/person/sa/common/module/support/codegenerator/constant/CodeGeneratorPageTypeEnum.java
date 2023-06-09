package org.person.sa.common.module.support.codegenerator.constant;

import org.person.sa.common.common.enumeration.BaseEnum;

/**
 * 页面类型
 *
 * @Author 1024创新实验室-主任: 卓大
 * @Date 2022-06-29 19:11:22
 * @Wechat wcchen96
 * @Email 15793730318@163.com
 * @Copyright 1024创新实验室 （ https://1024lab.net ）
 */
public enum CodeGeneratorPageTypeEnum implements BaseEnum {

    MODAL("modal", "弹窗"),
    DRAWER("drawer", "抽屉"),
    PAGE("page", "新页面");

    private String value;

    private String desc;

    CodeGeneratorPageTypeEnum(String value, String desc) {
        this.value = value;
        this.desc = desc;
    }

    @Override
    public Object getValue() {
        return value;
    }

    @Override
    public String getDesc() {
        return desc;
    }
}

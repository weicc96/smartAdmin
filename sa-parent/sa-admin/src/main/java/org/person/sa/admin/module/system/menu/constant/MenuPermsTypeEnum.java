package org.person.sa.admin.module.system.menu.constant;


import org.person.sa.common.common.enumeration.BaseEnum;

/**
 * 权限类型
 *
 * @Author 1024创新实验室: 善逸
 * @Date 2022-03-06 22:04:37
 * @Wechat wcchen96
 * @Email 15793730318@163.com
 * @Copyright 1024创新实验室 （ https://1024lab.net ）
 */
public enum MenuPermsTypeEnum implements BaseEnum {
    /**
     * SpringSecurity模式
     */
    SPRING_SECURITY(1, "SpringSecurity模式"),
    /**
     * URL模式
     */
    URL(2, "URL模式"),

    ;

    private Integer value;

    private String desc;


    MenuPermsTypeEnum(Integer value, String desc) {
        this.value = value;
        this.desc = desc;
    }

    @Override
    public Integer getValue() {
        return value;
    }

    @Override
    public String getDesc() {
        return desc;
    }
}

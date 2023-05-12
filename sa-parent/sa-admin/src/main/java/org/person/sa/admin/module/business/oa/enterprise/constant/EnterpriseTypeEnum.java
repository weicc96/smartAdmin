package org.person.sa.admin.module.business.oa.enterprise.constant;


import org.person.sa.common.common.enumeration.BaseEnum;

/**
 * 企业类型
 *
 * @Author 1024创新实验室: 开云
 * @Date 2022/7/28 20:37:15
 * @Wechat wcchen96
 * @Email 15793730318@163.com
 */
public enum EnterpriseTypeEnum implements BaseEnum {

    NORMAL(1, "有限企业"),

    FOREIGN(2, "外资企业"),
    ;

    private Integer value;
    private String desc;

    EnterpriseTypeEnum(Integer value, String desc) {
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

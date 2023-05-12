package org.person.sa.common.common.enumeration;

/**
 * 用户类型
 *
 * @Author weicc
 * @Date 2022/10/19 21:46:24
 * @Wechat wcchen96
 * @Email 15793730318@163.com
 */
public enum UserTypeEnum implements BaseEnum {

    /**
     * 管理端 员工用户
     */
    ADMIN_EMPLOYEE(1, "员工");

    private Integer type;

    private String desc;

    UserTypeEnum(Integer type, String desc) {
        this.type = type;
        this.desc = desc;
    }

    @Override
    public Integer getValue() {
        return type;
    }

    @Override
    public String getDesc() {
        return desc;
    }
}

package org.person.sa.common.common.domain;

import org.person.sa.common.common.enumeration.UserTypeEnum;

/**
 * 请求用户
 *
 * @Author 1024创新实验室-主任: 卓大
 * @Date 2021-12-21 19:55:07
 * @Wechat wcchen96
 * @Email 15793730318@163.com
 * @Copyright 1024创新实验室 （ https://1024lab.net ）
 */
public interface RequestUser {

    /**
     * 请求用户id
     *
     * @return
     */
    Long getUserId();

    /**
     * 请求用户名称
     *
     * @return
     */
    String getUserName();

    /**
     * 获取用户类型
     */
    UserTypeEnum getUserType();

    /**
     * 获取请求的IP
     *
     * @return
     */
    String getIp();

    /**
     * 获取请求 user-agent
     *
     * @return
     */
    String getUserAgent();

}

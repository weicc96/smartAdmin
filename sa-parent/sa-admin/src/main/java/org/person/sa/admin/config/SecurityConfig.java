package org.person.sa.admin.config;

import org.person.sa.admin.module.system.login.service.LoginService;
import org.person.sa.common.common.security.AbstractSecurityConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.UserDetails;

import javax.servlet.http.HttpServletRequest;
import java.util.function.BiFunction;

/**
 * 权限配置
 *
 * @Author 1024创新实验室: 罗伊
 * @Date 2022-05-30 21:22:12
 * @Wechat wcchen96
 * @Email 15793730318@163.com
 * @Copyright 1024创新实验室 （ https://1024lab.net ）
 */
@Configuration
public class SecurityConfig extends AbstractSecurityConfig {
    /**
     * 获取TOKEN 解析类
     */
    @Autowired
    private LoginService loginService;

    @Override
    protected BiFunction<String, HttpServletRequest, UserDetails> userFunction() {
        return (token, request) -> loginService.getLoginUserDetail(token, request);
    }

    @Override
    protected String[] getAuthenticatedUrlPatterns() {
        return new String[]{"/**"};
    }


}

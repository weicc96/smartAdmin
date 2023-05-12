package org.person.sa.common.common.security;

import com.alibaba.fastjson.JSONObject;
import org.person.sa.common.common.code.ErrorCode;
import org.person.sa.common.common.code.UserErrorCode;
import org.person.sa.common.common.domain.ResponseDTO;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 登录认证失败处理
 *
 * @Author 1024创新实验室: 罗伊
 * @Date 2022-08-26 20:21:10
 * @Wechat wcchen96
 * @Email 15793730318@163.com
 * @Copyright 1024创新实验室 （ https://1024lab.net ）
 */
public class SecurityAuthenticationFailHandler implements AuthenticationEntryPoint {

    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException e) throws IOException {
        this.outputResult(response, UserErrorCode.LOGIN_STATE_INVALID);
    }

    /**
     * 输出
     *
     * @param response
     * @param errorCode
     * @throws IOException
     */
    private void outputResult(HttpServletResponse response, ErrorCode errorCode) throws IOException {
        String msg = JSONObject.toJSONString(ResponseDTO.error(errorCode));
        response.setContentType("application/json;charset=UTF-8");
        response.getWriter().write(msg);
        response.flushBuffer();
    }
}

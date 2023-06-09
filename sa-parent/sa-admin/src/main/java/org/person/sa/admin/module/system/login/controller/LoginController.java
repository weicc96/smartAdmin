package org.person.sa.admin.module.system.login.controller;

import cn.hutool.extra.servlet.ServletUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.person.sa.admin.constant.AdminSwaggerTagConst;
import org.person.sa.admin.module.system.login.domain.LoginEmployeeDetail;
import org.person.sa.admin.module.system.login.domain.LoginForm;
import org.person.sa.admin.module.system.login.service.LoginService;
import org.person.sa.common.common.annoation.NoNeedLogin;
import org.person.sa.common.common.code.UserErrorCode;
import org.person.sa.common.common.constant.RequestHeaderConst;
import org.person.sa.common.common.domain.ResponseDTO;
import org.person.sa.common.common.util.SmartRequestUtil;
import org.person.sa.common.module.support.captcha.domain.CaptchaVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

/**
 * 员工登录
 *
 * @Author weicc
 * @Date 2021-12-15 21:05:46
 * @Wechat wcchen96
 * @Email 15793730318@163.com
 */
@RestController
@Api(tags = {AdminSwaggerTagConst.System.SYSTEM_LOGIN})
public class LoginController {

    @Autowired
    private LoginService loginService;

    @NoNeedLogin
    @PostMapping("/login")
    @ApiOperation("登录 @author weicc")
    public ResponseDTO<LoginEmployeeDetail> login(@Valid @RequestBody LoginForm loginForm) {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        String ip = ServletUtil.getClientIP(request);
        String userAgent = ServletUtil.getHeaderIgnoreCase(request, RequestHeaderConst.USER_AGENT);
        return loginService.login(loginForm, ip, userAgent);
    }

    @GetMapping("/login/refresh")
    @ApiOperation("刷新用户信息（包含用户基础信息、权限信息等等）  @author weicc")
    public ResponseDTO<String> refresh() {
        loginService.removeLoginUserDetailCache(SmartRequestUtil.getRequestUserId());
        return ResponseDTO.ok();
    }

    @GetMapping("/login/getLoginInfo")
    @ApiOperation("获取登录结果信息  @author weicc")
    public ResponseDTO<LoginEmployeeDetail> getLoginInfo() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication == null) {
            return ResponseDTO.error(UserErrorCode.LOGIN_STATE_INVALID);
        }

        Object principal = authentication.getPrincipal();
        if (!(principal instanceof LoginEmployeeDetail)) {
            return ResponseDTO.error(UserErrorCode.LOGIN_STATE_INVALID);
        }

        LoginEmployeeDetail loginEmployeeDetail = (LoginEmployeeDetail) authentication.getPrincipal();
        loginEmployeeDetail.setLoginPassword(null);
        return ResponseDTO.ok(loginEmployeeDetail);
    }

    @ApiOperation("退出登陆  @author weicc")
    @GetMapping("/login/logout")
    public ResponseDTO<String> logout(@RequestHeader(value = RequestHeaderConst.TOKEN, required = false) String token) {
        return loginService.logout(token, SmartRequestUtil.getRequestUser());
    }

    @ApiOperation("获取验证码  @author weicc")
    @GetMapping("/login/getCaptcha")
    @NoNeedLogin
    public ResponseDTO<CaptchaVO> getCaptcha() {
        return loginService.getCaptcha();
    }

}

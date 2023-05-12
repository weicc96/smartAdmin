package org.person.sa.admin.module.system.login.domain;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.validator.constraints.Length;
import org.person.sa.common.common.swagger.ApiModelPropertyEnum;
import org.person.sa.common.common.util.SmartVerificationUtil;
import org.person.sa.common.common.validator.enumeration.CheckEnum;
import org.person.sa.common.module.support.captcha.domain.CaptchaForm;
import org.person.sa.common.module.support.token.LoginDeviceEnum;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

/**
 * 员工登录
 *
 * @Author 1024创新实验室: 开云
 * @Date 2021-12-19 11:49:45
 * @Wechat wcchen96
 * @Email 15793730318@163.com
 */
@Data
public class LoginForm extends CaptchaForm {

    @ApiModelProperty("登录名")
    @NotBlank(message = "登录名不能为空")
    @Length(max = 30, message = "登录账号最多30字符")
    private String loginName;

    @ApiModelProperty("密码")
    @NotBlank(message = "密码不能为空")
    @Pattern(regexp = SmartVerificationUtil.PWD_REGEXP, message = "请输入6-15位密码(数字|大小写字母|小数点)")
    private String password;

    @ApiModelProperty(value = "登录终端")
    @ApiModelPropertyEnum(LoginDeviceEnum.class)
    @CheckEnum(value = LoginDeviceEnum.class, required = true, message = "此终端不允许登录")
    private Integer loginDevice;
}

package org.person.sa.common.module.support.codegenerator.service.variable.front;

import cn.hutool.core.bean.BeanUtil;
import com.google.common.base.CaseFormat;
import org.person.sa.common.common.util.SmartStringUtil;
import org.person.sa.common.module.support.codegenerator.domain.form.CodeGeneratorConfigForm;
import org.person.sa.common.module.support.codegenerator.domain.model.CodeField;
import org.person.sa.common.module.support.codegenerator.service.variable.CodeGenerateBaseVariableService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @Author weicc
 * @Date 2022/9/29 17:20:41
 * @Wechat wcchen96
 * @Email 15793730318@163.com
 */

public class ConstVariableService extends CodeGenerateBaseVariableService {

    @Override
    public boolean isSupport(CodeGeneratorConfigForm form) {
        return true;
    }

    @Override
    public Map<String, Object> getInjectVariablesMap(CodeGeneratorConfigForm form) {
        Map<String, Object> variablesMap = new HashMap<>();
        List<Map<String, Object>> enumList = new ArrayList<>();
        List<CodeField> enumFiledList = form.getFields().stream().filter(e -> SmartStringUtil.isNotBlank(e.getEnumName())).collect(Collectors.toList());
        for (CodeField codeField : enumFiledList) {
            Map<String, Object> beanToMap = BeanUtil.beanToMap(codeField);
            String upperUnderscoreEnum = CaseFormat.UPPER_CAMEL.to(CaseFormat.UPPER_UNDERSCORE, codeField.getEnumName());
            beanToMap.put("upperUnderscoreEnum", upperUnderscoreEnum);
            enumList.add(beanToMap);
        }
        variablesMap.put("enumList", enumList);
        return variablesMap;
    }
}

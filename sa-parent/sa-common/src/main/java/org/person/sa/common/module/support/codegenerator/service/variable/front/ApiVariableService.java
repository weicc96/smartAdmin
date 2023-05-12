package org.person.sa.common.module.support.codegenerator.service.variable.front;

import org.person.sa.common.module.support.codegenerator.domain.form.CodeGeneratorConfigForm;
import org.person.sa.common.module.support.codegenerator.service.variable.CodeGenerateBaseVariableService;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author weicc
 * @Date 2022/9/29 17:20:41
 * @Wechat wcchen96
 * @Email 15793730318@163.com
 */

public class ApiVariableService extends CodeGenerateBaseVariableService {

    @Override
    public boolean isSupport(CodeGeneratorConfigForm form) {
        return true;
    }

    @Override
    public Map<String, Object> getInjectVariablesMap(CodeGeneratorConfigForm form) {
        Map<String, Object> variablesMap = new HashMap<>();

        return variablesMap;
    }
}

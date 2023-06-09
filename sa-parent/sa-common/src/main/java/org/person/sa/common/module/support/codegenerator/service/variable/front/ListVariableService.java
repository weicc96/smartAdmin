package org.person.sa.common.module.support.codegenerator.service.variable.front;

import cn.hutool.core.bean.BeanUtil;
import com.google.common.base.CaseFormat;
import org.person.sa.common.module.support.codegenerator.constant.CodeQueryFieldQueryTypeEnum;
import org.person.sa.common.module.support.codegenerator.domain.form.CodeGeneratorConfigForm;
import org.person.sa.common.module.support.codegenerator.domain.model.CodeQueryField;
import org.person.sa.common.module.support.codegenerator.service.variable.CodeGenerateBaseVariableService;

import java.util.*;

/**
 * @Author weicc
 * @Date 2022/9/29 17:20:41
 * @Wechat wcchen96
 * @Email 15793730318@163.com
 */

public class ListVariableService extends CodeGenerateBaseVariableService {

    @Override
    public boolean isSupport(CodeGeneratorConfigForm form) {
        return true;
    }

    @Override
    public Map<String, Object> getInjectVariablesMap(CodeGeneratorConfigForm form) {
        Map<String, Object> variablesMap = new HashMap<>();

        List<Map<String, Object>> variableList = new ArrayList<>();
        List<CodeQueryField> queryFields = form.getQueryFields();
        HashSet<String> frontImportSet = new HashSet<>();
        frontImportSet.add("import " + CaseFormat.LOWER_CAMEL.to(CaseFormat.UPPER_CAMEL, form.getBasic().getModuleName()) + "Form from './" + CaseFormat.UPPER_CAMEL.to(CaseFormat.LOWER_HYPHEN, form.getBasic().getModuleName()) + "-form.vue';");

        for (CodeQueryField queryField : queryFields) {
            Map<String, Object> objectMap = BeanUtil.beanToMap(queryField);
            variableList.add(objectMap);

            if("Enum".equals(queryField.getQueryTypeEnum())){
                frontImportSet.add("import SmartEnumSelect from '/@/components/framework/smart-enum-select/index.vue';");
            }

            if("Dict".equals(queryField.getQueryTypeEnum())){
                frontImportSet.add("import DictSelect from '/@/components/support/dict-select/index.vue';");
            }

            if(CodeQueryFieldQueryTypeEnum.DATE_RANGE.getValue().equals(queryField.getQueryTypeEnum())){
                frontImportSet.add("import { defaultTimeRanges } from '/@/lib/default-time-ranges';");
            }

        }
        variablesMap.put("queryFields",variableList);
        variablesMap.put("frontImportList",new ArrayList<>(frontImportSet));
        return variablesMap;
    }
}

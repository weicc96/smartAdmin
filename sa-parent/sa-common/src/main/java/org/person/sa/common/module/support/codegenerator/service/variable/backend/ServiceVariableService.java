package org.person.sa.common.module.support.codegenerator.service.variable.backend;

import org.apache.commons.collections4.CollectionUtils;
import org.person.sa.common.module.support.codegenerator.domain.form.CodeGeneratorConfigForm;
import org.person.sa.common.module.support.codegenerator.domain.model.CodeInsertAndUpdateField;
import org.person.sa.common.module.support.codegenerator.service.variable.CodeGenerateBaseVariableService;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @Author weicc
 * @Date 2022/9/29 17:20:41
 * @Wechat wcchen96
 * @Email 15793730318@163.com
 */

public class ServiceVariableService extends CodeGenerateBaseVariableService {

    @Override
    public boolean isSupport(CodeGeneratorConfigForm form) {
        return true;
    }

    @Override
    public Map<String, Object> getInjectVariablesMap(CodeGeneratorConfigForm form) {
        Map<String, Object> variablesMap = new HashMap<>();

        List<CodeInsertAndUpdateField> updateFieldList = form.getInsertAndUpdate().getFieldList().stream().filter(e -> Boolean.TRUE.equals(e.getInsertFlag())).collect(Collectors.toList());
        List<String> packageList = getPackageList(updateFieldList, form);

        variablesMap.put("packageName", form.getBasic().getJavaPackageName() + ".service" );
        variablesMap.put("importPackageList", packageList);

        return variablesMap;
    }


    public List<String> getPackageList(List<CodeInsertAndUpdateField> fields, CodeGeneratorConfigForm form) {
        if (CollectionUtils.isEmpty(fields)) {
            return new ArrayList<>();
        }

        HashSet<String> packageSet = new HashSet<>();

        //1、javabean相关的包
        packageSet.addAll(getJavaBeanImportClass(form));

        //2、dao
        packageSet.add("import " + form.getBasic().getJavaPackageName() + ".dao."+ form.getBasic().getModuleName() + "Dao;" );

        //3、util list
        packageSet.add("import java.util.List;");

        //3、 排序一下
        ArrayList<String> packageList = new ArrayList<>(packageSet);
        Collections.sort(packageList);
        return packageList;
    }

}

package org.person.sa.common.module.support.codegenerator.service.variable.backend.domain;

import com.google.common.collect.Lists;
import org.apache.commons.collections4.CollectionUtils;
import org.person.sa.common.module.support.codegenerator.domain.form.CodeGeneratorConfigForm;
import org.person.sa.common.module.support.codegenerator.domain.model.CodeField;
import org.person.sa.common.module.support.codegenerator.service.variable.CodeGenerateBaseVariableService;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @Author weicc
 * @Date 2022/9/29 17:20:41
 * @Wechat wcchen96
 * @Email 15793730318@163.com
 */

public class EntityVariableService extends CodeGenerateBaseVariableService {

    @Override
    public boolean isSupport(CodeGeneratorConfigForm form) {
        return true;
    }

    @Override
    public Map<String, Object> getInjectVariablesMap(CodeGeneratorConfigForm form) {
        Map<String, Object> variablesMap = new HashMap<>();


        variablesMap.put("packageName", form.getBasic().getJavaPackageName() + ".domain.entity");
        variablesMap.put("importPackageList", getImportPackageList(form.getFields()));


        return variablesMap;
    }


    public List<String> getImportPackageList(List<CodeField> fields) {
        if (CollectionUtils.isEmpty(fields)) {
            return Lists.newArrayList();
        }

        /**
         * 1、LocalDate、LocalDateTime、BigDecimal 类型的包名
         * 2、排序
         */
        List<String> result = fields.stream().map(e -> getJavaPackageName(e.getJavaType())).filter(Objects::nonNull).distinct().collect(Collectors.toList());

        // lombok
        result.add("import lombok.Data;");

        // mybatis plus
        result.add("import com.baomidou.mybatisplus.annotation.TableName;");

        //主键
        boolean isExistPrimaryKey = fields.stream().filter(e -> e.getPrimaryKeyFlag() != null && e.getPrimaryKeyFlag()).findFirst().isPresent();
        if (isExistPrimaryKey) {
            result.add("import com.baomidou.mybatisplus.annotation.TableId;");
        }

        //自增
        boolean isExistAutoIncrease = fields.stream().filter(e -> e.getAutoIncreaseFlag() != null && e.getAutoIncreaseFlag()).findFirst().isPresent();
        if (isExistAutoIncrease) {
            result.add("import com.baomidou.mybatisplus.annotation.IdType;");
        }

        Collections.sort(result);
        return result;
    }

}

package org.person.sa.common.module.support.serialnumber.service;

import org.person.sa.common.module.support.serialnumber.constant.SerialNumberIdEnum;

import java.util.List;

/**
 * 单据序列号
 *
 * @Author 1024创新实验室-主任: 卓大
 * @Date 2022-03-25 21:46:07
 * @Wechat wcchen96
 * @Email 15793730318@163.com
 * @Copyright 1024创新实验室 （ https://1024lab.net ）
 */
public interface SerialNumberService {

    /**
     * 生成
     *
     * @param serialNumberIdEnum
     * @return
     */
    String generate(SerialNumberIdEnum serialNumberIdEnum);


    /**
     * 生成n个
     *
     * @param serialNumberIdEnum
     * @param count
     * @return
     */
    List<String> generate(SerialNumberIdEnum serialNumberIdEnum, int count);

}

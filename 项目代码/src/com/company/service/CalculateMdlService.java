package com.company.service;

/**
 * @program: 项目代码
 * @description: 计算模块接口
 * @author: Boyle
 * @create: 2020-10-09 20:06
 **/
public interface CalculateMdlService {

    // 生成逆波兰式
    public String generateReversePoland(String question);

    // 根据逆波兰式生成答案
    public String generateAnswer(String reversePoland);
}


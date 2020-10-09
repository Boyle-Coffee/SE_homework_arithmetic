package com.company.service.impl;

import com.company.service.CalculateMdlService;
import com.company.model.calculatemodel.CalculateRPN;
/**
 * @program: 项目代码
 * @description: 计算模块具体实现
 * @author: Boyle
 * @create: 2020-10-09 20:04
 **/
public class CalculateMdlServiceImpl implements CalculateMdlService{

    private CalculateRPN calculateRPN = new CalculateRPN();

    @Override
    public String generateReversePoland(String question) {
        return calculateRPN.generateReversePoland(question);
    }

    @Override
    public String generateAnswer(String reversePoland) {
        return calculateRPN.generateAnswer(reversePoland);
    }
}


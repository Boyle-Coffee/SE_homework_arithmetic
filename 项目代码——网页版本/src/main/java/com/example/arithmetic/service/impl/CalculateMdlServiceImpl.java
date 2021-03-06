package com.example.arithmetic.service.impl;


import com.example.arithmetic.model.calculatemodel.CalculateRPN;
import com.example.arithmetic.service.CalculateMdlService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @program: 项目代码
 * @description: 计算模块具体实现
 * @author: Boyle
 * @create: 2020-10-09 20:04
 **/
public class CalculateMdlServiceImpl implements CalculateMdlService {

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


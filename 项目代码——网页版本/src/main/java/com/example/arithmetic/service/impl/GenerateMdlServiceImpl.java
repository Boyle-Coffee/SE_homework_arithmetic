package com.example.arithmetic.service.impl;

import com.example.arithmetic.model.generatemodel.GenerateQuestion;
import com.example.arithmetic.service.GenerateMdlService;

/**
 * @program: 项目代码
 * @description: 生成接口模块具体实现类
 * @author: Mr.Huang
 * @create: 2020-10-08 16:31
 **/
public class GenerateMdlServiceImpl implements GenerateMdlService {

    private GenerateQuestion generateQuestion = new GenerateQuestion();

    @Override
    public String generateQuestion(Integer naturalNumber) {
        return generateQuestion.generateQuestion(naturalNumber);
    }
}

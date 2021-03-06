package com.example.arithmetic.service;

import org.springframework.stereotype.Service;

/**
 * @program: 项目代码
 * @description: 生成接口模块
 * @author: Mr.Huang
 * @create: 2020-10-08 16:30
 **/

public interface GenerateMdlService {

    /**
     * 生成题目
     *
     * @param naturalNumber 自然数的最大值
     * @return 返回题目
     */
    public String generateQuestion(Integer naturalNumber);
}

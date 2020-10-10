package com.company.test;

import com.company.model.generatemodel.GenerateQuestion;

/**
 * @program: 项目代码
 * @description: 题目生成测试
 * @author: Mr.Huang
 * @create: 2020-10-08 22:18
 **/
public class GenerateQuestionTest {
    public static void main(String[] args) {
        GenerateQuestion gq = new GenerateQuestion();
        for (int i = 0; i < 10; i++) {
            String s = gq.generateQuestion(100);
            System.out.println(s);
        }
    }
}

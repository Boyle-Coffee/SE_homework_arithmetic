package com.company.dao.generateDao;

import java.util.Random;

import java.util.Random;

/**
 * @program: 项目代码
 * @description: 生成题目
 * @author: Mr.Huang
 * @create: 2020-10-08 16:35
 **/
public class GenerateQuestion {

    /**
     * 生成题目
     *
     * @param naturalNumber 自然数的最大值
     * @return 返回题目
     */
    public String generateQuestion(Integer naturalNumber) {
        String exper = "";
        Random random = new Random();
        Integer signNum = random.nextInt(3) + 1;
        return null;
    }

    public String generateRandSign() {
        Random random = new Random();
        int signFlag = random.nextInt(4);
        switch (signFlag) {
            case 0:
                return "+";
            case 1:
                return "-";
            case 2:
                return "×";
            case 3:
                return "÷";
            default :
                return "";
        }
    }
}

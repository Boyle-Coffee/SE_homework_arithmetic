package com.company.model.generatemodel;

import com.company.util.generateUtil.QuestionUtil;

import java.util.*;

/**
 * @program: 项目代码
 * @description: 生成题目
 * @author: Mr.Huang
 * @create: 2020-10-08 16:35
 **/
public class GenerateQuestion {

    private QuestionUtil questionUtil = new QuestionUtil();

    /**
     * 生成题目
     *
     * @param naturalNumberMax 自然数的最大值
     * @return 返回题目
     */
    public String generateQuestion(Integer naturalNumberMax) {
        StringBuilder question = new StringBuilder();
        Random random = new Random();
        int signNum = random.nextInt(3) + 1;
        String number = generateRandNumber(naturalNumberMax);
        question.append(number);
        for (int i = 0; i < signNum; i++) {
            String sign = generateRandSign();
            question.append(sign);
            String num = generateRandNumber(naturalNumberMax);
            question.append(num);
        }
        System.out.println("原题目：" + question);
        String str = checkMinus(String.valueOf(question));
        return addBrackets(str);
    }

    /**
     * 生成随机运算符号
     *
     * @return 返回运算符
     */
    private String generateRandSign() {
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
            default:
                return "";
        }
    }

    /**
     * 生成随机数值
     *
     * @param naturalNumberMax 自然数的最大值
     * @return 返回随机数
     */
    private String generateRandNumber(Integer naturalNumberMax) {
        Random random = new Random();
        int numFlag = random.nextInt(3);
        switch (numFlag) {
            case 0:
            case 1:
                return questionUtil.generateRandInt(naturalNumberMax);
            case 2:
                return questionUtil.generateRandFraction();
            default:
                return "";
        }
    }

    /**
     * 随机添加括号
     *
     * @param question 题目
     * @return 返回添加括号后的题目
     */
    private String addBrackets(String question) {
        int signNum = 0;
        for (int i = 0; i < question.length(); i++) {
            String str = question.substring(i, i + 1);
            if (questionUtil.isSign(str)) {
                signNum++;
            }
        }
        if (signNum == 2) {
            return questionUtil.addBracketsTwoSign(question);
        } else if (signNum == 3) {
            return questionUtil.addBracketsThreeSign(question);
        }
        return question;
    }

    /**
     * 检查减号是否合理
     *
     * @param question 题目
     * @return 返回更改后的题目
     */
    private String checkMinus(String question) {
        boolean isError = false;
        String str = question;
        List<Integer> signList = questionUtil.saveSignNum(question);
        for (int i = 0; i < signList.size(); i++) {
            if ("-".equals(question.substring(signList.get(i), signList.get(i) + 1))) {
                if (i == 0 && signList.size() == 1) {
                    isError = questionUtil.judgeMinus(question.substring(0, signList.get(i)), question.substring(signList.get(i) + 1));
                } else if (i == 0) {
                    isError = questionUtil.judgeMinus(question.substring(0, signList.get(i)), question.substring(signList.get(i) + 1, signList.get(i + 1)));
                } else if (i == signList.size() - 1) {
                    isError = questionUtil.judgeMinus(question.substring((signList.get(i - 1) + 1), signList.get(i)), question.substring(signList.get(i) + 1));
                } else {
                    isError = questionUtil.judgeMinus(question.substring((signList.get(i - 1) + 1), signList.get(i)), question.substring(signList.get(i) + 1, signList.get(i + 1)));
                }
                if (isError) {
                    str = str.substring(0, signList.get(i)) + "+" + str.substring(signList.get(i) + 1);
                }
            }
        }
        return str;
    }
}
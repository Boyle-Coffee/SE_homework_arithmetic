package com.company.util.generateUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @program: 项目代码
 * @description: 题目生成工具类
 * @author: Mr.Huang
 * @create: 2020-10-09 10:40
 **/
public class QuestionUtil {

    /**
     * 生成随机整数
     *
     * @param naturalNumberMax 自然数的最大值
     * @return 返回随机整数
     */
    public String generateRandInt(Integer naturalNumberMax) {
        Random random = new Random();
        int randomInt = random.nextInt(naturalNumberMax);
        return randomInt + "";
    }

    /**
     * 生成随机分数
     *
     * @return 返回随机分数
     */
    public String generateRandFraction() {
        Random random = new Random();
        // 暂定分子分母的最大值——可通过参数方式改变
        int numerator = random.nextInt(50);
        int denominator = random.nextInt(50) + 2;
        int gcd = getGreatestCommonDivisor(numerator, denominator);
        numerator = numerator / gcd;
        denominator = denominator / gcd;
        return numerator + "" + "/" + denominator + "";
    }

    /**
     * 两个运算符时进行括号的添加
     *
     * @param question 题目
     * @return 返回添加了括号的题目
     */
    public String addBracketsTwoSign(String question) {
        Random random = new Random();
        List<String> list = saveQuestion(question);
        int bracketsFlag = random.nextInt(3);
        switch (bracketsFlag) {
            case 0:
                return question;
            case 1:
                return "(" + outputQuestion(list.subList(0, 3)) + ")" + outputQuestion(list.subList(3, list.size()));
            case 2:
                return outputQuestion(list.subList(0, 2)) + "(" + outputQuestion(list.subList(2, list.size())) + ")";
            default:
                return "";
        }
    }

    /**
     * 三个运算符时括号的添加
     *
     * @param question 题目
     * @return 返回添加了括号的题目
     */
    public String addBracketsThreeSign(String question) {
        Random random = new Random();
        List<String> list = saveQuestion(question);
        int bracketsFlag = random.nextInt(7);
        switch (bracketsFlag) {
            case 0:
                return question;
            case 1:
                return "(" + outputQuestion(list.subList(0, 3)) + ")" + outputQuestion(list.subList(3, list.size()));
            case 2:
                return outputQuestion(list.subList(0, 2)) + "(" + outputQuestion(list.subList(2, 5)) + ")" + outputQuestion(list.subList(5, list.size()));
            case 3:
                return outputQuestion(list.subList(0, 3)) + "(" + outputQuestion(list.subList(3, list.size())) + ")";
            case 4:
                return "(" + outputQuestion(list.subList(0, 5)) + ")" + outputQuestion(list.subList(5, list.size()));
            case 5:
                return outputQuestion(list.subList(0, 2)) + "(" + outputQuestion(list.subList(2, list.size())) + ")";
            case 6:
                return "(" + outputQuestion(list.subList(0, 3)) + ")" + outputQuestion(list.subList(3, 4)) + "(" + outputQuestion(list.subList(4, list.size())) + ")";
            default:
                return "";
        }
    }

    /**
     * 判断减号的运算
     *
     * @param before 减号前一个数值
     * @param after  减后后一个数值
     * @return 返回是否合理
     */
    public boolean judgeMinus(String before, String after) {
        float beforeNum = changeStrToNum(before);
        float afterNum = changeStrToNum(after);
        return beforeNum < afterNum;
    }

    /**
     * 保存符号的位置
     *
     * @param question 题目
     * @return 返回存有符号位置的List
     */
    public List<Integer> saveSignNum(String question) {
        List<Integer> signList = new ArrayList<>();
        for (int i = 0; i < question.length(); i++) {
            if (isSign(question.substring(i, i + 1))) {
                signList.add(i);
            }
        }
        return signList;
    }

    /**
     * 判断是否为符号
     *
     * @param str 判断内容
     * @return 返回是否为符号
     */
    public boolean isSign(String str) {
        switch (str) {
            case "+":
                return true;
            case "-":
                return true;
            case "×":
                return true;
            case "÷":
                return true;
            default:
                return false;
        }
    }

    /**
     * 获得最大公约数
     *
     * @param a 数A
     * @param b 数B
     * @return 返回最大公约数
     */
    private int getGreatestCommonDivisor(int a, int b) {
        if (a == b) {
            return a;
        }
        if ((a & 1) == 0 && (b & 1) == 0) {
            return getGreatestCommonDivisor(a >> 1, b >> 1) << 1;
        } else if ((a & 1) == 0 && (b & 1) != 0) {
            return getGreatestCommonDivisor(a >> 1, b);
        } else if ((a & 1) != 0 && (b & 1) == 0) {
            return getGreatestCommonDivisor(a, b >> 1);
        } else {
            int big = a > b ? a : b;
            int small = a < b ? a : b;
            return getGreatestCommonDivisor(big - small, small);
        }
    }

    /**
     * 保存题目至List
     *
     * @param question 题目
     * @return 返回存有题目的List
     */
    private List<String> saveQuestion(String question) {
        int j = 0;
        List<String> list = new ArrayList<>();
        List<Integer> signList = saveSignNum(question);
        list.add(changeFraction(question.substring(j, signList.get(0))));
        for (int i = 0; i < signList.size(); i++) {
            list.add(question.substring(signList.get(i), signList.get(i) + 1));
            j = signList.get(i) + 1;
            if (i + 1 < signList.size()) {
                list.add(changeFraction(question.substring(j, signList.get(i + 1))));
            } else {
                list.add(changeFraction(question.substring(j)));
            }
        }
        return list;
    }

    /**
     * 输出List中的题目
     *
     * @param questionList 存有题目的List
     * @return 返回List中的题目内容
     */
    private String outputQuestion(List<String> questionList) {
        StringBuilder question = new StringBuilder();
        for (String list : questionList) {
            question.append(list);
        }
        return String.valueOf(question);
    }

    /**
     * 改变分数的表达形式
     *
     * @param question 题目
     * @return 返回改变后的题目
     */
    private String changeFraction(String question) {
        int j = 0;
        for (int i = 0; i < question.length(); i++) {
            if ("/".equals(question.substring(i, i + 1))) {
                j = i;
            }
        }
        if (j == 0) {
            return question;
        }
        int numerator = Integer.valueOf(question.substring(0, j));
        int denominator = Integer.valueOf(question.substring(j + 1));
        if (numerator > denominator) {
            int num = numerator / denominator;
            return num + "" + "'" + (numerator - denominator * num) + "" + "/" + denominator + "";
        }
        return question;
    }

    /**
     * 将数值转换为数值
     *
     * @param str 转换内容
     * @return 转换结果
     */
    private float changeStrToNum(String str) {
        float num = 0;
        int semicolonNum = getSemicolonNum(str);
        if (semicolonNum == 0) {
            num = Integer.valueOf(str);
        } else {
            int numerator = Integer.valueOf(str.substring(0, semicolonNum));
            int denominator = Integer.valueOf(str.substring(semicolonNum + 1));
            System.out.println(numerator / denominator);
            System.out.println(numerator % denominator);
            num = (float) numerator / denominator;
        }
        return num;
    }

    /**
     * 获取分号位置
     *
     * @param str 判断内容
     * @return 返回分号位置
     */
    private int getSemicolonNum(String str) {
        for (int i = 0; i < str.length(); i++) {
            if ("/".equals(str.substring(i, i + 1))) {
                return i;
            }
        }
        return 0;
    }
}

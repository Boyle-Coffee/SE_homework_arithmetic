package com.company.dao.generateDao;

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
        StringBuilder question = new StringBuilder();
        Random random = new Random();
        int signNum = random.nextInt(3) + 1;
        String number = generateRandNumber(naturalNumber);
        question.append(number);
        for (int i = 0; i < signNum; i++) {
            String sign = generateRandSign();
            question.append(sign);
            String num = generateRandNumber(naturalNumber);
            question.append(num);
        }
        return addBrackets(String.valueOf(question));
    }

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

    private String generateRandNumber(Integer naturalNumber) {
        Random random = new Random();
        int numFlag = random.nextInt(3);
        switch (numFlag) {
            case 0:
                return generateRandInt(naturalNumber);
            case 1:
                return generateRandInt(naturalNumber);
            case 2:
                return generateRandFraction();
            default:
                return "";
        }
    }

    private String generateRandInt(Integer naturalNumber) {
        Random random = new Random();
        int randomInt = random.nextInt(naturalNumber);
        return randomInt + "";
    }

    private String generateRandFraction() {
        Random random = new Random();
        int numerator = random.nextInt();
        int denominator = random.nextInt();
        int gcd = getGreatestCommonDivisor(numerator, denominator);
        numerator = numerator / gcd;
        denominator = denominator / gcd;
        if (numerator < denominator) {
            return numerator + "" + "/" + denominator + "";
        } else {
            int num = numerator / denominator;
            return num + "" + "'" + (numerator - denominator * num) + "" + "/" + denominator + "";
        }
    }

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

    private String addBrackets(String question) {
        int signNum = 0;
        for (int i = 0; i < question.length(); i++) {
            String str = question.substring(i, i + 1);
            if (isSign(str)) {
                signNum++;
            }
        }
        if (signNum == 2) {
            return addBracketsTwoSign(question);
        } else if (signNum == 3) {
            return addBracketsThreeSign(question);
        }
        return question;
    }

    private String addBracketsTwoSign(String question) {
        Random random = new Random();
        int bracketsFlag = random.nextInt(3);
        switch (bracketsFlag) {
            case 0:
                return question;
            case 1:
                return "(" + question.substring(0, 3) + ")" + question.substring(3);
            case 2:
                return question.substring(0, 2) + "(" + question.substring(2) + ")";
            default:
                return "";
        }
    }

    private String addBracketsThreeSign(String question) {
        Random random = new Random();
        int bracketsFlag = random.nextInt(7);
        switch (bracketsFlag) {
            case 0:
                return question;
            case 1:
                return "(" + question.substring(0, 3) + ")" + question.substring(3);
            case 2:
                return question.substring(0, 2) + "(" + question.substring(2, 5) + ")" + question.substring(5);
            case 3:
                return question.substring(0, 3) + "(" + question.substring(3) + ")";
            case 4:
                return "(" + question.substring(0, 5) + ")" + question.substring(5);
            case 5:
                return question.substring(0, 2) + "(" + question.substring(2) + ")";
            case 6:
                return "(" + question.substring(0, 3) + ")" + question.substring(3, 4) + "(" + question.substring(4) + ")";
            default:
                return "";
        }
    }

    private boolean isSign(String str) {
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
}

package com.company.dao.generateDao;

import java.util.*;

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
        String str = checkMinus(String.valueOf(question));
        return addBrackets(str);
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

    private String generateRandNumber(Integer naturalNumberMax) {
        Random random = new Random();
        int numFlag = random.nextInt(3);
        switch (numFlag) {
            case 0:
                return generateRandInt(naturalNumberMax);
            case 1:
                return generateRandInt(naturalNumberMax);
            case 2:
                return generateRandFraction();
            default:
                return "";
        }
    }

    private String generateRandInt(Integer naturalNumberMax) {
        Random random = new Random();
        int randomInt = random.nextInt(naturalNumberMax);
        return randomInt + "";
    }

    private String generateRandFraction() {
        Random random = new Random();
        // 暂定分子分母的最大值——可通过参数方式改变
        int numerator = random.nextInt(50);
        int denominator = random.nextInt(50) + 2;
        int gcd = getGreatestCommonDivisor(numerator, denominator);
        numerator = numerator / gcd;
        denominator = denominator / gcd;
        return numerator + "" + "/" + denominator + "";
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

    private String addBracketsThreeSign(String question) {
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

    private String outputQuestion(List<String> questionList) {
        StringBuilder question = new StringBuilder();
        for (String list : questionList) {
            question.append(list);
        }
        return String.valueOf(question);
    }

    private List<Integer> saveSignNum(String question) {
        List<Integer> signList = new ArrayList<>();
        for (int i = 0; i < question.length(); i++) {
            if (isSign(question.substring(i, i + 1))) {
                signList.add(i);
            }
        }
        return signList;
    }

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

    private String checkMinus(String question) {
        boolean isError = false;
        String str = question;
        List<Integer> signList = saveSignNum(question);
        for (int i = 0; i < signList.size(); i++) {
            if ("-".equals(question.substring(signList.get(i), signList.get(i) + 1))) {
                if (i == 0) {
                    isError = judgeMinus(question.substring(0, signList.get(i)), question.substring(signList.get(i) + 1, signList.get(i + 1)));
                } else if (i == signList.size() - 1) {
                    isError = judgeMinus(question.substring((signList.get(i - 1) + 1), signList.get(i)), question.substring(signList.get(i) + 1));
                } else {
                    isError = judgeMinus(question.substring((signList.get(i - 1) + 1), signList.get(i)), question.substring(signList.get(i) + 1, signList.get(i + 1)));
                }
                if (isError) {
                    str = str.substring(0, i) + "+" + str.substring(i + 1);
                }
            }
        }
        return str;
    }

    private boolean judgeMinus(String before, String after) {
        float beforeNum = changeStrToNum(before);
        float afterNum = changeStrToNum(after);
        return beforeNum > afterNum;
    }

    private float changeStrToNum(String str) {
        float num = 0;
        int semicolonNum = getSemicolonNum(str);
        if (semicolonNum == 0) {
            num = Integer.valueOf(str);
        } else {
            int numerator = Integer.valueOf(str.substring(0, semicolonNum));
            int denominator = Integer.valueOf(str.substring(semicolonNum + 1));
            num = numerator / (denominator);
        }
        return num;
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

    private int getSemicolonNum(String str) {
        for (int i = 0; i < str.length(); i++) {
            if ("/".equals(str.substring(i, i + 1))) {
                return i;
            }
        }
        return 0;
    }
}
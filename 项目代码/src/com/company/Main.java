package com.company;

import java.util.*;

import com.company.controller.GenerateFourOperations;
import com.company.execption.ArrayExecption;

public class Main {

    private static GenerateFourOperations generateFourOperations = new GenerateFourOperations();
    private static List<String> questionList = new ArrayList<>();
    private static List<String> answerList = new ArrayList<>();
    private static Set<String> reversePolandSet = new LinkedHashSet<>();

    public static void main(String[] args) {
        int naturalNumberMax = 100;
        int questionNum = 100;
        String questionFileName = null;
        String answerFileName = null;
        boolean fileFlag = false;
        boolean flag = true;
        if (args.length == 0) {
            flag = false;
        }
        for (int i = 0; i < args.length; i++) {
            if ("-r".equals(args[i])) {
                naturalNumberMax = Integer.valueOf(args[i + 1]);
                flag = false;
            }
            if ("-n".equals(args[i])) {
                questionNum = Integer.valueOf(args[i + 1]);
                flag = false;
            }
            if ("-e".equals(args[i])) {
                questionFileName = args[i + 1];
                flag = false;
                fileFlag = true;
            }
            if ("-a".equals(args[i])) {
                answerFileName = args[i + 1];
                flag = false;
                fileFlag = true;
            }
        }
        if (flag) {
            throw new ArrayExecption("参数异常");
        }
        if (fileFlag) {
            // todo 需求九
            System.out.println("需求九");
        } else {
            generateFourOperations.generateFourOperations(questionNum, naturalNumberMax,
                    questionList, answerList, reversePolandSet);
        }
    }
}

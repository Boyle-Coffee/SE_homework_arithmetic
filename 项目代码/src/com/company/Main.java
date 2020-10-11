package com.company;

import java.util.*;

import com.company.controller.GenerateFourOperations;
import com.company.controller.CheckFourOperarions;
import com.company.controller.JudgeArray;
import com.company.execption.ArrayExecption;

public class Main {

    private static GenerateFourOperations generateFourOperations = new GenerateFourOperations();
    private static CheckFourOperarions checkFourOperarions = new CheckFourOperarions();
    private static JudgeArray judgeArray = new JudgeArray();
    private static List<String> questionList = new ArrayList<>();
    private static List<String> answerList = new ArrayList<>();
    private static Set<String> reversePolandSet = new LinkedHashSet<>();

    public static void main(String[] args) {
        int naturalNumberMax = 100;
        int questionNum = 100;
        String exerciseFileName = null;
        String answerFileName = null;
        boolean fileFlag = false;
        boolean flag;
        flag = judgeArray.isArrayError(args);
        if (flag) {
            System.out.println("参数异常");
            return;
        }
        for (int i = 0; i < args.length; i++) {
            if ("-r".equals(args[i])) {
                naturalNumberMax = Integer.valueOf(args[i + 1]);
            }
            if ("-n".equals(args[i])) {
                questionNum = Integer.valueOf(args[i + 1]);
            }
            if ("-e".equals(args[i])) {
                exerciseFileName = args[i + 1];
                fileFlag = true;
            }
            if ("-a".equals(args[i])) {
                answerFileName = args[i + 1];
                fileFlag = true;
            }
        }
        if (fileFlag) {
            if (checkFourOperarions.checkFourOperarionsAnswer(exerciseFileName, answerFileName)) {
                System.out.println("检查成功");
            } else {
                System.out.println("检查出错");
            }
        } else {
            generateFourOperations.generateFourOperations(questionNum, naturalNumberMax,
                    questionList, answerList, reversePolandSet);
        }
    }
}

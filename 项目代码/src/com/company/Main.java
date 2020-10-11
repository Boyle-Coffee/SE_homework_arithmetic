package com.company;

import java.util.*;

import com.company.controller.GenerateFourOperations;
import com.company.controller.CheckFourOperarions;

public class Main {

    private static GenerateFourOperations generateFourOperations = new GenerateFourOperations();
    private static CheckFourOperarions checkFourOperarions = new CheckFourOperarions();
    private static List<String> questionList = new ArrayList<>();
    private static List<String> answerList = new ArrayList<>();
    private static Set<String> reversePolandSet = new LinkedHashSet<>();

    public static void main(String[] args) {
        int naturalNumberMax = 100;
        int questionNum = 100;
        String exerciseFileName = null;
        String answerFileName = null;
        boolean flag = true;
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
                exerciseFileName = args[i + 1];
            }
            if ("-a".equals(args[i])) {
                answerFileName = args[i + 1];
            }
        }
        if (flag) {
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

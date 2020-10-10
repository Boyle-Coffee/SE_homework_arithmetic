package com.company;

import java.util.*;

import com.company.controller.GenerateFourOperations;

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
                questionFileName = args[i + 1];
            }
            if ("-a".equals(args[i])) {
                answerFileName = args[i + 1];
            }
        }
        if (flag) {
            // todo 需求九
            System.out.println("需求九");
        } else {
            generateFourOperations.generateFourOperations(questionNum, naturalNumberMax,
                    questionList, answerList, reversePolandSet);
        }
    }
}

package com.company;

import java.util.*;

import com.company.controller.GenerateFourOperations;
import com.company.controller.JudgeArray;

public class Main {

    private static GenerateFourOperations generateFourOperations = new GenerateFourOperations();
    private static JudgeArray judgeArray = new JudgeArray();
    private static List<String> questionList = new ArrayList<>();
    private static List<String> answerList = new ArrayList<>();
    private static Set<String> reversePolandSet = new LinkedHashSet<>();

    public static void main(String[] args) {
        int questionNum = 100;
        int naturalNumberMax = 100;
        if (judgeArray.judgeArrayIsFile(args, naturalNumberMax, questionNum)) {
            // todo 需求九
            System.out.println("需求九");
        } else {
            generateFourOperations.generateFourOperations(questionNum, naturalNumberMax,
                    questionList, answerList, reversePolandSet);
        }
    }
}

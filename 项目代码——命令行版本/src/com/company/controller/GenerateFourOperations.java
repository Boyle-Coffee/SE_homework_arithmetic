package com.company.controller;

import com.company.service.CalculateMdlService;
import com.company.service.CheckMdlService;
import com.company.service.FileMdlService;
import com.company.service.GenerateMdlService;
import com.company.service.impl.CalculateMdlServiceImpl;
import com.company.service.impl.CheckMdlServiceImpl;
import com.company.service.impl.FileMdlServiceImpl;
import com.company.service.impl.GenerateMdlServiceImpl;

import java.util.List;
import java.util.Set;

/**
 * @program: 项目代码
 * @description: 四则运算的生成
 * @author: Mr.Huang
 * @create: 2020-10-09 21:52
 **/
public class GenerateFourOperations {

    private GenerateMdlService generateMdlService = new GenerateMdlServiceImpl();
    private CalculateMdlService calculateMdlService = new CalculateMdlServiceImpl();
    private CheckMdlService checkMdlService = new CheckMdlServiceImpl();
    private FileMdlService fileMdlService = new FileMdlServiceImpl();

    private String question = null;
    private String reversePoland = null;
    private String answer = null;

    public boolean generateFourOperations(Integer questionNum, Integer naturalNumberMax,
                                       List<String> questionList, List<String> answerList, Set<String> reversePolandSet) {
        int again_time = 0;  // 重复次数
        while (answerList.size() < questionNum) {
            generateQuesAndAnswerAndReverse(naturalNumberMax);
            while ("<0".equals(answer) || "÷0".equals(answer) || reversePoland == null) {
                generateQuesAndAnswerAndReverse(naturalNumberMax);
            }
            boolean flag = checkMdlService.isErrorReversePoland(reversePoland, reversePolandSet);
            again_time += 1;
            if (flag) {
                questionList.add(question);
                answerList.add(answer);
                again_time = 0;
            }
            if (again_time > 10000) {  // 当尝试10000次都没有生成式子，可能可生成式子的空间已经被消耗完
                return false;
            }
        }
        fileMdlService.writeToFile("Exercises.txt", questionList);
        fileMdlService.writeToFile("Answers.txt", answerList);

        return true;
    }

    private void generateQuesAndAnswerAndReverse(Integer naturalNumberMax) {
        question = generateMdlService.generateQuestion(naturalNumberMax);
        reversePoland = calculateMdlService.generateReversePoland(question);
        answer = calculateMdlService.generateAnswer(reversePoland);
    }
}

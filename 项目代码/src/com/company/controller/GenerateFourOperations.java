package com.company.controller;

import com.company.service.CalculateMdlService;
import com.company.service.CheckMdlService;
import com.company.service.GenerateMdlService;
import com.company.service.impl.CalculateMdlServiceImpl;
import com.company.service.impl.CheckMdlServiceImpl;
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

    public void generateFourOperations(Integer questionNum, Integer naturalNumberMax,
                                       List<String> questionList, List<String> answerList, Set<String> reversePolandSet) {
        String question = null;
        String reversePoland = null;
        String answer = null;
        for (int i = 0; i < questionNum; i++) {
            generateQuesAndAnswerAndReverse(question, reversePoland, answer, naturalNumberMax);
            boolean flag = checkMdlService.isErrorReversePoland(reversePoland, reversePolandSet);
            if (flag) {
                questionList.add(question);
                answerList.add(answer);
            }
        }
    }

    private void generateQuesAndAnswerAndReverse(String question, String reversePoland, String answer, Integer naturalNumberMax) {
        question = generateMdlService.generateQuestion(naturalNumberMax);
        reversePoland = calculateMdlService.generateReversePoland(question);
        answer = calculateMdlService.generateAnswer(reversePoland);
    }
}

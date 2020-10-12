package com.example.arithmetic.controller;


import com.example.arithmetic.domain.QuestionInfo;
import com.example.arithmetic.service.CalculateMdlService;
import com.example.arithmetic.service.CheckMdlService;
import com.example.arithmetic.service.FileMdlService;
import com.example.arithmetic.service.GenerateMdlService;
import com.example.arithmetic.service.impl.CalculateMdlServiceImpl;
import com.example.arithmetic.service.impl.CheckMdlServiceImpl;
import com.example.arithmetic.service.impl.FileMdlServiceImpl;
import com.example.arithmetic.service.impl.GenerateMdlServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

/**
 * @program: 项目代码
 * @description: 四则运算的生成
 * @author: Mr.Huang
 * @create: 2020-10-09 21:52
 **/
@Controller
public class GenerateFourOperations {

    private GenerateMdlService generateMdlService = new GenerateMdlServiceImpl();
    private CalculateMdlService calculateMdlService = new CalculateMdlServiceImpl();
    private CheckMdlService checkMdlService = new CheckMdlServiceImpl();
    private FileMdlService fileMdlService = new FileMdlServiceImpl();

    private String question = null;
    private String reversePoland = null;
    private String answer = null;

    private List<String> questionList = new ArrayList<>();
    private List<String> answerList = new ArrayList<>();
    private Set<String> reversePolandSet = new LinkedHashSet<>();

    @PostMapping("/questionInfoNum")
    public String generateFourOperations(@ModelAttribute QuestionInfo questionInfo, Model model) {
        int again_time = 0;  // 重复次数
        while (answerList.size() < questionInfo.getQuestionNum()) {
            generateQuesAndAnswerAndReverse(questionInfo.getNaturalNumberMax());
            while ("<0".equals(answer) || "÷0".equals(answer) || reversePoland == null) {
                generateQuesAndAnswerAndReverse(questionInfo.getNaturalNumberMax());
            }
            boolean flag = checkMdlService.isErrorReversePoland(reversePoland, reversePolandSet);
            again_time += 1;
            if (flag) {
                questionList.add(question);
                answerList.add(answer);
                again_time = 0;
            }
            if (again_time > 10000) {  // 当尝试10000次都没有生成式子，可能可生成式子的空间已经被消耗完
                return "errorResult";
            }
        }
        fileMdlService.writeToFile("Exercises.txt", questionList);
        fileMdlService.writeToFile("Answers.txt", answerList);
        model.addAttribute("questionList", questionList);
        model.addAttribute("answerList", answerList);
        return "questionResult";
    }

    private void generateQuesAndAnswerAndReverse(Integer naturalNumberMax) {
        question = generateMdlService.generateQuestion(naturalNumberMax);
        reversePoland = calculateMdlService.generateReversePoland(question);
        answer = calculateMdlService.generateAnswer(reversePoland);
    }
}

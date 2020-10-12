package com.example.arithmetic.controller;


import com.example.arithmetic.domain.CheckInfo;
import com.example.arithmetic.domain.QuestionInfo;
import com.example.arithmetic.service.CalculateMdlService;
import com.example.arithmetic.service.CheckMdlService;
import com.example.arithmetic.service.FileMdlService;
import com.example.arithmetic.service.impl.CalculateMdlServiceImpl;
import com.example.arithmetic.service.impl.CheckMdlServiceImpl;
import com.example.arithmetic.service.impl.FileMdlServiceImpl;
import com.example.arithmetic.util.calculateUtil.DigitStringUtil;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: 项目代码
 * @description: 需求9，答案检查
 * @author: Boyle
 * @create: 2020-10-11 10:44
 **/
@Controller
public class CheckFourOperarions {

    private CheckMdlService checkMdlService = new CheckMdlServiceImpl();
    private FileMdlService fileMdlService = new FileMdlServiceImpl();
    private CalculateMdlService calculateMdlService = new CalculateMdlServiceImpl();
    List<String> resultList = null;
    List<String> checkResult = null;
    List<String> myAnswerList = null;
    List<String> trueAnswerList = null;
    List<String> exerciseList = null;
    String reversePoland = null;
    String answer = null;

    @PostMapping("/checkInfoNum")
    public String checkFourOperarionsAnswer(@ModelAttribute CheckInfo checkInfo, Model model) {
        try {
            trueAnswerList = new ArrayList<String>();
            resultList = new ArrayList<String>();
            myAnswerList = fileMdlService.readFromFile(checkInfo.getAnswerFileName());
            exerciseList = fileMdlService.readFromFile(checkInfo.getExerciseFileName());
            if (myAnswerList == null || exerciseList == null) {
                return "errorResult";
            }
            exerciseToAnswer();
            checkResult = checkMdlService.checkAnswer(myAnswerList, trueAnswerList);
            if (checkResult == null) {
                return "errorResult";
            }
            gradeToFile();
            System.out.println(resultList);
            model.addAttribute("checkResult", resultList);
            return "checkResult";
        } catch (Exception e) {
            return "errorResult";
        }
    }

    private void exerciseToAnswer() throws Exception {
        for (String exercise : exerciseList) {
            reversePoland = calculateMdlService.generateReversePoland(exercise);
            if (reversePoland == null) {
                throw new Exception("生成逆波兰式时发生错误");
            }
            answer = calculateMdlService.generateAnswer(reversePoland);
            if (answer == null) {
                throw new Exception("计算答案时发生错误");
            }
            trueAnswerList.add(answer);
        }
    }

    private void gradeToFile() {
        List<String> correctList = new ArrayList<String>();
        List<String> wrongList = checkResult;
        List<String> fileContent = resultList;

        // 生成正确答案的列表
        for (int i = 0; i < trueAnswerList.size(); i++) {
            answer = DigitStringUtil.integerToStr(i + 1);
            if (!wrongList.contains(answer)) {
                correctList.add(answer);
            }
        }

        String correct = "Correct: " + DigitStringUtil.integerToStr(correctList.size()) + " (";
        String wrong = "Wrong: " + DigitStringUtil.integerToStr(wrongList.size()) + " (";

        // 生成正确答案的打印内容
        for (int i = 0; i < correctList.size(); i++) {
            if (i == correctList.size() - 1) {
                correct += correctList.get(i) + ")";
                continue;
            }
            correct += correctList.get(i) + ", ";
        }
        if (correctList.size() == 0) {
            correct += ")";
        }
        fileContent.add(correct);

        // 生成错误答案的打印内容
        for (int i = 0; i < wrongList.size(); i++) {
            if (i == wrongList.size() - 1) {
                wrong += wrongList.get(i) + ")";
                continue;
            }
            wrong += wrongList.get(i) + ", ";
        }
        if (wrongList.size() == 0) {
            wrong += ")";
        }
        fileContent.add(wrong);

        // 存入文件夹
        fileMdlService.gradeToFile("Grade.txt", fileContent);
    }
}


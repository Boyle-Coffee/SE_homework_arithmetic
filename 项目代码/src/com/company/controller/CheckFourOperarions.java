package com.company.controller;

import com.company.service.CalculateMdlService;
import com.company.service.CheckMdlService;
import com.company.service.FileMdlService;
import com.company.service.impl.CalculateMdlServiceImpl;
import com.company.service.impl.CheckMdlServiceImpl;
import com.company.service.impl.FileMdlServiceImpl;
import com.company.util.calculateUtil.DigitStringUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: 项目代码
 * @description: 需求9，答案检查
 * @author: Boyle
 * @create: 2020-10-11 10:44
 **/
public class CheckFourOperarions {
    private CheckMdlService checkMdlService = new CheckMdlServiceImpl();
    private FileMdlService fileMdlService = new FileMdlServiceImpl();
    private CalculateMdlService calculateMdlService = new CalculateMdlServiceImpl();
    List<String> checkResult = null;
    List<String> myAnswerList = null;
    List<String> trueAnswerList = null;
    List<String> exerciseList = null;
    String reversePoland = null;
    String answer = null;

    public boolean checkFourOperarionsAnswer(String exerciseFileName, String answerFileName) {
        try {
            trueAnswerList = new ArrayList<String>();
            myAnswerList = fileMdlService.readFromFile(answerFileName);
            exerciseList = fileMdlService.readFromFile(exerciseFileName);
            exerciseToAnswer();
            checkResult = checkMdlService.checkAnswer(myAnswerList, trueAnswerList);
            if (checkResult == null) {
                return false;
            }
            gradeToFile();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public void exerciseToAnswer() throws Exception {
        for(String exercise: exerciseList) {
            reversePoland = calculateMdlService.generateReversePoland(exercise);
            if(reversePoland == null) {
                throw new Exception("生成逆波兰式时发生错误");
            }
            answer = calculateMdlService.generateAnswer(reversePoland);
            if(answer == null) {
                throw new Exception("计算答案时发生错误");
            }
            trueAnswerList.add(answer);
        }
    }

    public void gradeToFile() {
        List<String> correctList = new ArrayList<String>();
        List<String> wrongList = checkResult;
        List<String> fileContent = new ArrayList<String>();

        // 生成正确答案的列表
        for(int i=0; i < trueAnswerList.size(); i++) {
            answer = DigitStringUtil.integerToStr(i+1);
            if (!wrongList.contains(answer)) {
                correctList.add(answer);
            }
        }

        String correct = "Correct: " + DigitStringUtil.integerToStr(correctList.size()) + " (";
        String wrong = "Wrong: " + DigitStringUtil.integerToStr(wrongList.size()) + " (";

        // 生成正确答案的打印内容
        for(int i=0; i<correctList.size(); i++) {
            if (i==correctList.size()-1) {
                correct += correctList.get(i)+")";
                continue;
            }
            correct += correctList.get(i)+", " ;
        }
        if (correctList.size()==0) {
            correct += ")";
        }
        fileContent.add(correct);

        // 生成错误答案的打印内容
        for(int i=0; i<wrongList.size(); i++) {
            if (i==wrongList.size()-1) {
                wrong += wrongList.get(i)+")";
                continue;
            }
            wrong += wrongList.get(i)+", " ;
        }
        if (wrongList.size()==0) {
            wrong += ")";
        }
        fileContent.add(wrong);

        // 存入文件夹
        fileMdlService.gradeToFile("Grade.txt", fileContent);
    }
}


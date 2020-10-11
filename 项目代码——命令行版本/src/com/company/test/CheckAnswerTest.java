package com.company.test;

import com.company.service.impl.CheckMdlServiceImpl;
import com.company.service.CheckMdlService;

import java.util.Arrays;
import java.util.List;

/**
 * @program: 项目代码
 * @description: 检查答案方法测试
 * @author: Boyle
 * @create: 2020-10-11 10:08
 **/
public class CheckAnswerTest {
    private static CheckMdlService testObj = new CheckMdlServiceImpl();

    public static void main(String[] args) {
        List<String> myAnswerList = Arrays.asList("1'2/3", "2", "4", "6/7", "2'3/4");
        List<String> trueAnswerList = Arrays.asList("1'2/3", "9", "4", "7", "2'3/4");
        System.out.println(testObj.checkAnswer(myAnswerList, trueAnswerList));
    }
}


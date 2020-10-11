package com.company.test;

import com.company.service.FileMdlService;
import com.company.service.impl.FileMdlServiceImpl;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: 项目代码
 * @description: 读取文件测试
 * @author: Mr.Huang
 * @create: 2020-10-09 15:19
 **/
public class ReadFromFileTest {

    private static FileMdlService fileMdlService = new FileMdlServiceImpl();

    public static void main(String[] args) {
        testMethod("Answers.txt");
    }

    private static void testMethod(String fileName) {
        List<String> textList = new ArrayList<>();

        textList = fileMdlService.readFromFile(fileName);
        for (String str : textList) {
            System.out.println(str);
        }
    }
}

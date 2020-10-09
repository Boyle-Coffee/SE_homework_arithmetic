package com.company.test;

import com.company.service.FileMdlService;
import com.company.service.GenerateMdlService;
import com.company.service.impl.FileMdlServiceImpl;
import com.company.service.impl.GenerateMdlServiceImpl;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: 项目代码
 * @description: 输出文本至文件测试
 * @author: Mr.Huang
 * @create: 2020-10-09 15:01
 **/
public class WriteToFileTest {

    private static GenerateMdlService generateMdlService = new GenerateMdlServiceImpl();

    private static FileMdlService fileMdlService = new FileMdlServiceImpl();

    public static void main(String[] args) {
        testMethod();
    }

    public static void testMethod() {
        List<String> textList = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            String question = generateMdlService.generateQuestion(100);
            textList.add(question);
        }

        fileMdlService.writeToFile("F://testFile.txt",textList);
    }
}

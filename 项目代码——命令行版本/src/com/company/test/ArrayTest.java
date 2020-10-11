package com.company.test;

import com.company.controller.JudgeArray;

/**
 * @program: 项目代码
 * @description:
 * @author: Mr.Huang
 * @create: 2020-10-11 13:50
 **/
public class ArrayTest {
    static JudgeArray judgeArray = new JudgeArray();

    public static void main(String[] args) {
        boolean flag = judgeArray.isArrayError(args);
        System.out.println(flag);
    }
}

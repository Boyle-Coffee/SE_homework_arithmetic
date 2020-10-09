package com.company.controller;

/**
 * @program: 项目代码
 * @description: 判断数组内容
 * @author: Mr.Huang
 * @create: 2020-10-09 22:53
 **/
public class JudgeArray {

    public boolean judgeArrayIsFile(String[] args, Integer naturalNumberMax, Integer questionNum) {
        boolean flag = false;
        for (int i = 0; i < args.length; i++) {
            if ("-r".equals(args[i])) {
                naturalNumberMax = Integer.valueOf(args[i + 1]);
                flag = true;
            }
            if ("-n".equals(args[i])) {
                questionNum = Integer.valueOf(args[i + 1]);
                flag = true;
            }
        }
        return flag;
    }
}

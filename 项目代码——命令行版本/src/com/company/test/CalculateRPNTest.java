package com.company.test;

import com.company.service.CalculateMdlService;
import com.company.service.impl.CalculateMdlServiceImpl;

/**
 * @program: 项目代码
 * @description: 逆波兰计算器计算
 * @author: Boyle
 * @create: 2020-10-09 20:32
 **/
public class CalculateRPNTest {
    private static CalculateMdlService test = new CalculateMdlServiceImpl();

    public static void main(String[] args) {
        String exper = "2 - 0/1 ÷ 0";
        for(int i=0; i <=10; i++) {
            String res = test.generateReversePoland(exper);
            System.out.println(i);
            System.out.println(res);
            System.out.println(test.generateAnswer(res));
        }
    }
}


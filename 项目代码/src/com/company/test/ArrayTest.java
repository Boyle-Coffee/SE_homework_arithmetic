package com.company.test;

/**
 * @program: 项目代码
 * @description:
 * @author: Mr.Huang
 * @create: 2020-10-11 13:50
 **/
public class ArrayTest {
    public static void main(String[] args) {
        boolean flag = args[1].matches("[0-9]+");
        System.out.println(flag);
    }
}

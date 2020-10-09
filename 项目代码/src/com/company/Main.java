package com.company;

import com.company.dao.generateDao.GenerateQuestion;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        System.out.println("Hello World");
//        String question = "x+y+z+u";
//        GenerateQuestion gq = new GenerateQuestion();
//        List<String> list = gq.saveQuestion(question);
//        System.out.println(list);
//        System.out.println(list.subList(0, 3));
//        System.out.println(list.subList(3, list.size()));
//        System.out.println("(" + question.substring(0, 3) + ")" + question.substring(3));
//        System.out.println(question.substring(0, 2) + "(" + question.substring(2) + ")");
//        System.out.println("(" + question.substring(0, 3) + ")" + question.substring(3));
//        System.out.println(question.substring(0, 2) + "(" + question.substring(2, 5) + ")" + question.substring(5));
//        System.out.println(question.substring(0, 3) + "(" + question.substring(3) + ")");
//        System.out.println("(" + question.substring(0, 5) + ")" + question.substring(5));
//        System.out.println(question.substring(0, 2) + "(" + question.substring(2) + ")");
//        System.out.println("(" + question.substring(0, 3) + ")" + question.substring(3, 4) + "(" + question.substring(4) + ")");
        GenerateQuestion gq = new GenerateQuestion();
        gq.checkMinus("8-41/30÷18");
        gq.checkMinus("8-41÷18");
//        for (int i = 0; i < 10; i++) {
//            String question = gq.generateQuestion(100);
//            System.out.println("加括号：" + question);
//        }

    }
}

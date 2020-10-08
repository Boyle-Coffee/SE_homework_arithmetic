package com.company;

public class Main {

    public static void main(String[] args) {
        System.out.println("Hello World");
        String question = "x+y+z+u";
//        System.out.println("(" + question.substring(0, 3) + ")" + question.substring(3));
//        System.out.println(question.substring(0, 2) + "(" + question.substring(2) + ")");
        System.out.println("(" + question.substring(0, 3) + ")" + question.substring(3));
        System.out.println(question.substring(0, 2) + "(" + question.substring(2, 5) + ")" + question.substring(5));
        System.out.println(question.substring(0, 3) + "(" + question.substring(3) + ")");
        System.out.println("(" + question.substring(0, 5) + ")" + question.substring(5));
        System.out.println(question.substring(0, 2) + "(" + question.substring(2) + ")");
        System.out.println("(" + question.substring(0, 3) + ")" + question.substring(3, 4) + "(" + question.substring(4) + ")");
    }
}

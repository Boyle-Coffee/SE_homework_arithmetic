package com.company.common;

public class Constants {

    public static final String LEFT = "(";

    public static final String RIGHT = ")";

    public static final String ADD = "+";

    public static final String MINUS = "-";

    public static final String TIMES = "×";

    public static final String DIVISION = "÷";

    public static final String APOSTROPHE = "'";  // 用于说明是带分数的撇号

    public static final String VIRGULE = "/";  // 分数的斜杆号

    public static final String REGEX = " ";
    /**
     * 运算符级别： + -
     */
    public static final int LEVEL_1 = 1;

    /**
     * 运算符级别：× ÷
     */
    public static final int LEVEL_2 = 2;

    /**
     * int 的 最大值(代表括号的等级)
     */
    public static final int LEVEL_HIGH = Integer.MAX_VALUE;
}

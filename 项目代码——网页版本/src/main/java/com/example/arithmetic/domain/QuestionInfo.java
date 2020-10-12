package com.example.arithmetic.domain;

/**
 * @program: arithmetic
 * @description: 题目参数信息
 * @author: Mr.Huang
 * @create: 2020-10-12 11:27
 **/
public class QuestionInfo {

    private Integer questionNum;
    private Integer naturalNumberMax;

    public Integer getQuestionNum() {
        return questionNum;
    }

    public void setQuestionNum(Integer questionNum) {
        this.questionNum = questionNum;
    }

    public Integer getNaturalNumberMax() {
        return naturalNumberMax;
    }

    public void setNaturalNumberMax(Integer naturalNumberMax) {
        this.naturalNumberMax = naturalNumberMax;
    }
}

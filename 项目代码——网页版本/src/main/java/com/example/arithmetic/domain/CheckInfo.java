package com.example.arithmetic.domain;

/**
 * @program: arithmetic
 * @description:
 * @author: Mr.Huang
 * @create: 2020-10-12 16:14
 **/
public class CheckInfo {
    private String exerciseFileName;
    private String answerFileName;

    public String getExerciseFileName() {
        return exerciseFileName;
    }

    public void setExerciseFileName(String exerciseFileName) {
        this.exerciseFileName = exerciseFileName;
    }

    public String getAnswerFileName() {
        return answerFileName;
    }

    public void setAnswerFileName(String answerFileName) {
        this.answerFileName = answerFileName;
    }
}

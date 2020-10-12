package com.company.model.generatemodel;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GenerateQuestionTest {
    private GenerateQuestion generateMdlService = new GenerateQuestion();

    @Test
    @DisplayName("生成10以内的10000道题")
    void generateQuestion() {
        for(int i=0; i<10000; i++) {
            System.out.println(generateMdlService.generateQuestion(10));
        }
    }
}
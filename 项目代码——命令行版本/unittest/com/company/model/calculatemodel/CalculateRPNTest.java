package com.company.model.calculatemodel;

import com.company.common.Constants;
import com.company.model.filemodel.ReadFromFile;
import org.junit.jupiter.api.*;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CalculateRPNTest {
    static private ReadFromFile fileMdlService = new ReadFromFile();
    private CalculateRPN calculateMdlService = new CalculateRPN();
    static List<String> questionList;
    List<String> RPNList = new ArrayList<String>();
    String RPNu;

    @BeforeAll
    static void readFile() {
        questionList = fileMdlService.readFromFile("Exercises.txt");
    }

    @Test
    @DisplayName("转换10000题")
    void generateReversePoland() {
        for(String question:questionList) {
            RPNu = calculateMdlService.generateReversePoland(question);
            RPNList.add(RPNu);
            System.out.println(RPNu);
        }
    }

    @Test
    @DisplayName("计算10000个答案")
    void generateAnswer() {
        for(String item:RPNList) {
            System.out.println(calculateMdlService.generateAnswer(item));
        }
    }

    @Test
    @DisplayName("输入错误中缀表达式")
    void generateReversePolandError() {
        String question = "3 2 4";
        String answer;
        answer = calculateMdlService.generateReversePoland(question);
        assertNull(answer);
    }

    @Test
    @DisplayName("输入式子计算过程出现负数")
    void generateReversePolandNegative() {
        String question = "3 - 4";
        String RPN;
        String answer;
        RPN = calculateMdlService.generateReversePoland(question);
        answer = calculateMdlService.generateAnswer(RPN);
        assertEquals(answer, Constants.NEGATIVE);
    }


    @Test
    @DisplayName("输入式子中除数为0")
    void generateReversePolandDivZero() {
        String question = "3 ÷ 0";
        String RPN;
        String answer;
        RPN = calculateMdlService.generateReversePoland(question);
        answer = calculateMdlService.generateAnswer(RPN);
        assertEquals(answer, Constants.DIVZERO);
    }
}
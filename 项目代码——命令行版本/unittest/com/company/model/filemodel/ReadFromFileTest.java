package com.company.model.filemodel;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ReadFromFileTest {
    private ReadFromFile fileMdlService = new ReadFromFile();

    @Test
    @DisplayName("读取文件并打印内容")
    void readFromFile() {
        List<String> questionList;

        questionList = fileMdlService.readFromFile("Exercises.txt");
        for(String question: questionList) {
            System.out.println(question);
        }
    }

    @Test
    @DisplayName("读取不存在的文件")
    void readFromFileNotExist() {
        List<String> questionList;

        questionList = fileMdlService.readFromFile("NotExist.txt");
        assertNull(questionList);  // 读取的文件不存在将返回空值
    }
}
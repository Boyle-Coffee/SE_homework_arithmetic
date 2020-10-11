package com.example.arithmetic.model.filemodel;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

/**
 * @program: 项目代码
 * @description: 输出文本至文件
 * @author: Mr.Huang
 * @create: 2020-10-09 14:55
 **/
public class WriteToFile {

    /**
     * 将题目文本或答案文本输出至文件
     *
     * @param fileName 文件名
     * @param textList 文本集合
     */
    public void writeToFile(String fileName, List<String> textList) {
        File file = new File(fileName);
        try {
            FileWriter fileWriter = new FileWriter(file, false);
            for (int i = 0; i < textList.size(); i++) {
                fileWriter.write(i + 1 + ".");
                fileWriter.write(textList.get(i));
                fileWriter.write("\r\n");
            }
            fileWriter.close();
        } catch (IOException e) {
            System.out.println("写入文件时出现错误，可能是写入文件异常");
            System.exit(0);
        }
    }

    /**
     * 将成绩输出至文件
     *
     * @param fileName 文件名
     * @param textList 文本集合
     */
    public boolean gradeToFile(String fileName, List<String> textList) {
        File file = new File(fileName);
        try {
            FileWriter fileWriter = new FileWriter(file, false);
            for (int i = 0; i < textList.size(); i++) {
                fileWriter.write(textList.get(i));
                fileWriter.write("\r\n");
            }
            fileWriter.close();
        } catch (IOException e) {
            return false;
        }
        return true;
    }
}

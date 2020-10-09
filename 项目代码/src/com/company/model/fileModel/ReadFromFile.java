package com.company.model.fileModel;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

/**
 * @program: 项目代码
 * @description: 从题目或答案文件中读取文本
 * @author: Mr.Huang
 * @create: 2020-10-09 15:12
 **/
public class ReadFromFile {

    /**
     * 读取题目文件或答案文件中的内容
     *
     * @param fileName 文件名
     * @return 返回文本集合
     */
    public List<String> readFromFile(String fileName) {
        String strLine;
        List<String> textList = new ArrayList<>();
        File file = new File(fileName);
        FileInputStream fis = null;
        try {
            fis = new FileInputStream(file);
            InputStreamReader reader = new InputStreamReader(fis, StandardCharsets.UTF_8);
            BufferedReader bufr = new BufferedReader(reader);
            while ((strLine = bufr.readLine()) != null) {
                textList.add(strLine);
            }
            reader.close();
            bufr.close();
            fis.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return textList;
    }
}

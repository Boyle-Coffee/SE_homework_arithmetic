package com.company.dao.fileDao;

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

    public void writeToFile(String fileName, List<String> textList) {
        File file = new File(fileName);
        try {
            FileWriter fileWriter = new FileWriter(file, true);
            for (int i = 0; i < textList.size(); i++) {
                fileWriter.write(i + 1 + ".");
                fileWriter.write(textList.get(i));
                fileWriter.write("\r\n");
            }
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}

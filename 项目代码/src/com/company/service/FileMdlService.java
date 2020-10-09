package com.company.service;

import java.util.List;

/**
 * @program: 项目代码
 * @description: 文件模块接口
 * @author: Mr.Huang
 * @create: 2020-10-09 14:47
 **/
public interface FileMdlService {

    /**
     * 将题目文本或答案文本输出至文件中
     *
     * @param fileName 文件名
     * @param textList 文本集合
     */
    public void writeToFile(String fileName, List<String> textList);


    /**
     * 将题目文件或答案文件读取为文本
     * @param fileName 文件名
     * @return 返回文本集合
     */
    public List<String> readFromFile(String fileName);
}

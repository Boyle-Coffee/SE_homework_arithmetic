package com.company.service.impl;

import com.company.model.filemodel.ReadFromFile;
import com.company.model.filemodel.WriteToFile;
import com.company.service.FileMdlService;

import java.util.List;

/**
 * @program: 项目代码
 * @description: 文件模块接口具体实现类
 * @author: Mr.Huang
 * @create: 2020-10-09 14:47
 **/
public class FileMdlServiceImpl implements FileMdlService {

    private WriteToFile writeToFile = new WriteToFile();

    private ReadFromFile readFromFile = new ReadFromFile();

    @Override
    public void writeToFile(String fileName, List<String> textList) {
        writeToFile.writeToFile(fileName, textList);
    }

    @Override
    public List<String> readFromFile(String fileName) {
        return readFromFile.readFromFile(fileName);
    }
}

package com.company.service.impl;

import java.io.Writer;

import com.company.dao.fileDao.WriteToFile;
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

    @Override
    public void writeToFile(String fileName, List<String> textList) {
        writeToFile.writeToFile(fileName, textList);
    }
}

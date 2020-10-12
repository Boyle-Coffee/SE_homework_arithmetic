package com.example.arithmetic.service;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

/**
 * @program: 项目代码
 * @description: 检查模块接口
 * @author: Mr.Huang
 * @create: 2020-10-09 15:25
 **/

public interface CheckMdlService {

    public boolean isErrorReversePoland(String reversePoland, Set<String> set);

    public List<String> checkAnswer(List<String> myAnswerList, List<String> trueAnswerList);
}

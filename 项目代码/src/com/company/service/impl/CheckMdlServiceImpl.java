package com.company.service.impl;

import com.company.model.checkmodel.CheckReversePoland;
import com.company.service.CheckMdlService;

import java.util.List;
import java.util.Set;

/**
 * @program: 项目代码
 * @description: 检查模块接口具体实现
 * @author: Mr.Huang
 * @create: 2020-10-09 15:26
 **/
public class CheckMdlServiceImpl implements CheckMdlService {

    private CheckReversePoland checkReversePoland = new CheckReversePoland();

    @Override
    public boolean isErrorReversePoland(String reversePoland, Set<String> set) {
        return checkReversePoland.checkReversePoland(reversePoland, set);
    }

    @Override
    public List<String> checkAnswer(List<String> myAnswerList, List<String> trueAnswerList) {
        return checkReversePoland.checkAnswer(myAnswerList, trueAnswerList);
    }
}

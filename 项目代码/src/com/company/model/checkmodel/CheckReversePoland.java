package com.company.model.checkmodel;

import java.util.Set;

/**
 * @program: 项目代码
 * @description: 检查逆波兰式是否合理
 * @author: Mr.Huang
 * @create: 2020-10-09 21:21
 **/
public class CheckReversePoland {

    public boolean checkReversePoland(String reversePoland, Set<String> set) {
        return set.add(reversePoland);
    }

}

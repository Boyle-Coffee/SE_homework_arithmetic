package com.company.model.checkmodel;

import com.company.util.calculateUtil.DigitStringUtil;

import java.util.ArrayList;
import java.util.List;
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

    public List<String> checkAnswer(List<String> myAnswerList, List<String> trueAnswerList) {
        try {
            if (myAnswerList == null || trueAnswerList == null || myAnswerList.size() != trueAnswerList.size()) {
                return null;
            }

            List<String> result = new ArrayList<String>();
            int answerLen = trueAnswerList.size();

            for(int i=0; i<answerLen; i++) {
                if (!myAnswerList.get(i).equals(trueAnswerList.get(i))) {
                    result.add(DigitStringUtil.integerToStr(i+1));
                }
            }
            return result;
        } catch (Exception e) {
            return null;
        }

    }

}

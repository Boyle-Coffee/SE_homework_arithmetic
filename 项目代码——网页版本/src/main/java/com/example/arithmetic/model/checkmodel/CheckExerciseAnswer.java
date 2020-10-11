package com.example.arithmetic.model.checkmodel;



import com.example.arithmetic.util.calculateUtil.DigitStringUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: 项目代码
 * @description: 检查答案
 * @author: Boyle
 * @create: 2020-10-11 12:07
 **/
public class CheckExerciseAnswer {

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


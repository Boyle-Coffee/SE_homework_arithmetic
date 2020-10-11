package com.company.model.calculatemodel;

import com.company.common.Constants;
import com.company.util.calculateUtil.DigitStringUtil;
import com.company.util.calculateUtil.FractionObj;

import java.util.Stack;

public class CalculateRPN {
    /**
     * @Description: 进行加法、乘法交换，确保等价的算式后缀表达式相同
     * @Param: [resultStack]
     * @return: java.lang.String
     * @Author: Boyle
     * @date: 2020/10/9
     */
    private String stack2RPN(Stack<String> resultStack) {

        Stack<String> tempStack = new Stack<>();
        String childExper1, childExper2, tempExper;

        while (!resultStack.empty()) {
            if (DigitStringUtil.isFigure(resultStack.peek())) {
                tempStack.push(resultStack.pop());
            } else if (DigitStringUtil.isOpt(resultStack.peek())) {
                childExper1 = tempStack.pop();
                childExper2 = tempStack.pop();
                if (childExper1.compareTo(childExper2) == 1 && ("+".equals(resultStack.peek()) || "×".equals(resultStack.peek()))) {
                    tempExper = childExper2 + " " + childExper1 + " " + resultStack.pop();
                } else {
                    tempExper = childExper1 + " " + childExper2 + " " + resultStack.pop();
                }
                tempStack.push(tempExper);
            } else {
                return null;
            }
        }
        if (tempStack.size() == 1) {
            return tempStack.pop();
        }
        return null;
    }

    public String generateReversePoland(String question) {
        /**
         *@Description: 逆波兰式生成，将中缀表达式转换为后缀表达式
         *@Param: [question]
         *@return: java.lang.String
         *@Author: Boyle
         *@date: 2020/10/8
         */
        if (question == null || "".equals(question.trim())) {
            return null;
        }
        // 根据空格分割字符串
        String[] preExper = question.trim().split(Constants.REGEX);
        // 初始化运算符栈
        Stack<String> optStack = new Stack<>();
        // 存储中间结果的栈
        Stack<String> tempStack = new Stack<>();
        Stack<String> resultStack = new Stack<>();

        int experSize = preExper.length;
        try {
            for (int i = 0; i < experSize; i++) {
                String item = preExper[i].trim();
                if ("".equals(item)) {  // 舍弃多余的空格
                    continue;
                }
                if (DigitStringUtil.isFigure(item)) {  // 遇到整数时，直接压入存储结果的栈
                    tempStack.push(item);
                } else if (DigitStringUtil.isOpt(item)) {  // 遇到运算符，根据栈顶元素进行操作
                    while (optStack.size() != 0
                            && (!optStack.peek().equals(Constants.LEFT))
                            && DigitStringUtil.getValue(optStack.peek()) >= DigitStringUtil.getValue(item)) {
                        tempStack.push(optStack.pop());
                    }
                    optStack.push(item);
                } else if (item.equals(Constants.LEFT)) {  // 遇到左括号时，直接压入运算符栈
                    optStack.push(item);
                } else if (item.equals(Constants.RIGHT)) {  // 遇到右括号一次弹出栈元素，直到遇到左括号
                    while (!optStack.peek().equals(Constants.LEFT)) {
                        tempStack.push(optStack.pop());
                    }
                    optStack.pop();
                } else {
                    return null;
                }
            }
            while (!optStack.empty()) {
                tempStack.push(optStack.pop());
            }

            while (!tempStack.empty()) {
                resultStack.push(tempStack.pop());
            }
            return stack2RPN(resultStack);

        } catch (Exception e) {
            return null;
        }
    }

    public String operation(String fig1, String fig2, String opt) {
        try {
            FractionObj result;
            String resultStr;
            switch (opt) {
                case Constants.ADD:
                    result = new FractionObj(fig1).add(new FractionObj(fig2));
                    if (result.DenominatorZero()) {
                        resultStr = Constants.DIVZERO;
                    } else {
                        resultStr = result.getString();
                    }
                    break;
                case Constants.MINUS:
                    result = new FractionObj(fig1).sub(new FractionObj(fig2));
                    if (result.DenominatorZero()) {
                        resultStr = Constants.DIVZERO;
                    } else if (result.LTZero()) {
                        resultStr = Constants.NEGATIVE;
                    } else {
                        resultStr = result.getString();
                    }
                    break;
                case Constants.TIMES:
                    result = new FractionObj(fig1).multi(new FractionObj(fig2));
                    if (result.DenominatorZero()) {
                        resultStr = Constants.DIVZERO;
                    } else {
                        resultStr = result.getString();
                    }
                    break;
                case Constants.DIVISION:
                    result = new FractionObj(fig1).div(new FractionObj(fig2));
                    if (result.DenominatorZero()) {
                        resultStr = Constants.DIVZERO;
                    } else {
                        resultStr = result.getString();
                    }
                    break;
                default:
                    resultStr = null;
            }
            return resultStr;
        } catch (Exception e) {
            return null;
        }
    }

    // 生成答案
    public String generateAnswer(String reversePoland) {
        if (reversePoland == null || "".equals(reversePoland.trim())) {
            return null;
        }
        String[] postExper = reversePoland.trim().split(Constants.REGEX);  // 根据空格分割字符串
        Stack<String> experStack = new Stack<>();
        Stack<String> tempStack = new Stack<>();
        String fig1, fig2, temp;

        for (int i = postExper.length; i > 0; i--) {
            experStack.push(postExper[i - 1]);
        }
        while (!experStack.empty()) {
            if (DigitStringUtil.isFigure(experStack.peek())) {
                tempStack.push(experStack.pop());
            } else if (DigitStringUtil.isOpt(experStack.peek())) {
                fig1 = tempStack.pop();
                fig2 = tempStack.pop();
                temp = operation(fig1, fig2, experStack.pop());
                if (temp == null) {
                    return null;
                }
                if (temp.equals(Constants.NEGATIVE)) {
                    return Constants.NEGATIVE;
                } else if (temp.equals(Constants.DIVZERO)) {
                    return Constants.DIVZERO;
                }
                tempStack.push(temp);
            } else {
                return null;
            }
        }
        if (tempStack.size() == 1) {
            return tempStack.pop();
        }
        return null;

    }

    public static void main(String[] args) {
        String exper = "( 8'6/7 - 1 × 3'3/4 )";
        CalculateRPN test = new CalculateRPN();
        for (int i = 0; i <= 10000; i++) {
            String res = test.generateReversePoland(exper);
            System.out.println(i);
            System.out.println(res);
            System.out.println(test.generateAnswer(res));
        }
    }
}

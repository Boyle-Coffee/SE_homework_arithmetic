package com.example.arithmetic.util.calculateUtil;


import com.example.arithmetic.common.Constants;

public class DigitStringUtil {
    public static int getValue(String opt) {
        /**
         *@Description: 获得符号的对应优先级
         *@Param: [opt]
         *@return: int
         *@Author: Boyle
         *@date: 2020/10/9
         */
        int result = 0;
        switch (opt) {
            case Constants.ADD:
                result = Constants.LEVEL_1;
                break;
            case Constants.MINUS:
                result = Constants.LEVEL_1;
                break;
            case Constants.TIMES:
                result = Constants.LEVEL_2;
                break;
            case Constants.DIVISION:
                result = Constants.LEVEL_2;
                break;
            default:
                result = Constants.LEVEL_HIGH;
        }
        return result;
    }

    // 将字符串转换为整数
    public static Integer strToInteger(String strNum) {
        try {
            Integer num = Integer.valueOf(strNum);
            return num;
        } catch (Exception e) {
            return null;
        }
    }

    // 将整数转换为字符串
    public static String integerToStr(Integer num) {
        try {
            String strNum = String.valueOf(num);
            return strNum;
        } catch (Exception e) {
            return null;
        }
    }

    public static boolean isFigure(String strNum) {
        /**
         *@Description: 判断字符串是否为合法数字
         *@Param: [strNum]
         *@return: boolean
         *@Author: Boyle
         *@date: 2020/10/8
         */
        strNum = strNum.trim();
        if (strNum.contains(Constants.APOSTROPHE)) {  // 是否是带分数
            String[] strArray = strNum.split(Constants.APOSTROPHE);
            if (strArray.length != 2 || strToInteger(strArray[0])==null) {
                return false;
            }
            if (strArray[1].contains(Constants.VIRGULE)) {  // 后半部分是否是分数
                String[] strArray2 = strArray[1].split(Constants.VIRGULE);
                if (strArray2.length != 2 || strToInteger(strArray2[0])==null || strToInteger(strArray2[1])==null) {
                    return false;
                }
                return true;
            } else {
                return false;
            }
        } else if (strNum.contains(Constants.VIRGULE)) {  // 是否是分数
            String[] strArray2 = strNum.split(Constants.VIRGULE);
            if (strArray2.length != 2 || strToInteger(strArray2[0])==null || strToInteger(strArray2[1])==null) {
                return false;
            }
            return true;
        } else {  // 当做整数处理
            if (strToInteger(strNum)==null) {
                return false;
            }
            return true;
        }
    }

    public static boolean isOpt(String strOpt) {
        /**
         *@Description: 判断字符串是否为运算符
         *@Param: [strOpt]
         *@return: boolean
         *@Author: Boyle
         *@date: 2020/10/9
         */
        strOpt = strOpt.trim();
        if(strOpt.equals(Constants.ADD)
                || strOpt.equals(Constants.MINUS)
                || strOpt.equals(Constants.TIMES)
                || strOpt.equals(Constants.DIVISION)) {
            return true;
        } else {
            return false;
        }
    }
}

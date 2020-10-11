package com.company.util.calculateUtil;

import com.company.common.Constants;

public class FractionObj {
    int numerator;  // 分子
    int denominator;  // 分母

    FractionObj() {}

    public FractionObj(String strNum) throws Exception {
        Integer integerPart;
        Integer a;
        Integer b;
        if (strNum.contains(Constants.APOSTROPHE)) {  // 带分数
            String[] strArray = strNum.split(Constants.APOSTROPHE);
            if (strArray.length != 2 || (integerPart=DigitStringUtil.strToInteger(strArray[0])) == null) {
                throw new Exception("输入的数字错误");
            }
            if (strArray[1].contains(Constants.VIRGULE)) {  // 后半部分是否是分数
                String[] strArray2 = strArray[1].split(Constants.VIRGULE);
                if (strArray2.length != 2 || (a=DigitStringUtil.strToInteger(strArray2[0]))==null || (b=DigitStringUtil.strToInteger(strArray2[1]))==null) {
                    throw new Exception("输入的数字错误");
                }
                a = a + b * integerPart;
                setNumeratorAndDenominator(a, b);
            } else {
                throw new Exception("输入的数字错误");
            }
        } else if (strNum.contains(Constants.VIRGULE)) {
            String[] strArray2 = strNum.split(Constants.VIRGULE);
            if (strArray2.length != 2 || (a=DigitStringUtil.strToInteger(strArray2[0]))==null || (b=DigitStringUtil.strToInteger(strArray2[1]))==null) {
                throw new Exception("输入的数字错误");
            }
            setNumeratorAndDenominator(a, b);
        } else {
            integerPart = DigitStringUtil.strToInteger(strNum);
            if (integerPart==null) {
                throw new Exception("输入的数字错误");
            }
            setNumeratorAndDenominator(integerPart, 1);
        }
    }

    FractionObj(int a, int b) {
        setNumeratorAndDenominator(a, b);
    }

    private int getGreatestCommonDivisor(int a, int b) {
        if (a == b) {
            return a;
        }
        if ((a & 1) == 0 && (b & 1) == 0) {
            return getGreatestCommonDivisor(a >> 1, b >> 1) << 1;
        } else if ((a & 1) == 0 && (b & 1) != 0) {
            return getGreatestCommonDivisor(a >> 1, b);
        } else if ((a & 1) != 0 && (b & 1) == 0) {
            return getGreatestCommonDivisor(a, b >> 1);
        } else {
            int big = a > b ? a : b;
            int small = a < b ? a : b;
            return getGreatestCommonDivisor(big - small, small);
        }
    }

    private void setNumeratorAndDenominator(int a, int b) {
        if (b==0) {
            numerator = a;
            denominator = 0;
        } else if (b==1) {
            numerator = a;
            denominator = b;
        } else if (a==0){
            numerator = 0;
            denominator = 1;
        } else {
            int c = getGreatestCommonDivisor(Math.abs(a), Math.abs(b));
            numerator = a / c;
            denominator = b / c;
            if(numerator<0 && denominator<0){
                numerator = - numerator;
                denominator = - denominator;
            }
        }
    }

    public boolean LTZero() {
        if ((numerator<0 && denominator>0) || (numerator>0 && denominator<0)) {
            return true;
        }
        return false;
    }

    public boolean EqlZero() {
        if(numerator==0) {
            return true;
        }
        return false;
    }

    public boolean DenominatorZero() {
        if (denominator == 0) {
            return true;
        }
        return false;
    }

    public int getDenominator() {
        return denominator;
    }

    public int getNumerator() {
        return numerator;
    }

    public String getString() {
        String a, b, c;
        int temp, denominator, numerator;
        String sign;
        if (this.LTZero()) {
            denominator = Math.abs(this.denominator);
            numerator = Math.abs(this.numerator);
            sign = "-";
        } else {
            denominator = this.denominator;
            numerator = this.numerator;
            sign = "";
        }
        if (denominator == 1) {
            return sign + DigitStringUtil.integerToStr(numerator);
        } else if(denominator == 0) {
            return Constants.INF;
        } else if (denominator < numerator) {
            temp = numerator / denominator;
            c = DigitStringUtil.integerToStr(temp);
            a = DigitStringUtil.integerToStr(numerator - temp * denominator);
            b = DigitStringUtil.integerToStr(denominator);
            return sign + c + "'" + a + "/"+b;
        } else {
            a = DigitStringUtil.integerToStr(numerator);
            b = DigitStringUtil.integerToStr(denominator);
            return sign + a + "/"+b;
        }
    }

    public FractionObj add(FractionObj r) {  // 加法运算
        if (this.getString() == Constants.INF || r.getString() == Constants.INF) {
            return new FractionObj(1,0);
        }
        int a = r.getNumerator();
        int b = r.getDenominator();
        int newNumerator = numerator * b + denominator * a;
        int newDenominator = denominator * b;
        FractionObj result = new FractionObj(newNumerator, newDenominator);
        return result;
    }

    public FractionObj sub(FractionObj r) {  // 减法运算
        if (this.getString() == Constants.INF || r.getString() == Constants.INF) {
            return new FractionObj(1,0);
        }
        int a = r.getNumerator();
        int b = r.getDenominator();
        int newNumerator = numerator * b - denominator * a;
        int newDenominator = denominator * b;
        FractionObj result = new FractionObj(newNumerator,newDenominator);
        return result;
    }

    public FractionObj multi(FractionObj r) {
        if (this.getString() == Constants.INF || r.getString() == Constants.INF) {
            return new FractionObj(1,0);
        }
        int a = r.getNumerator();
        int b = r.getDenominator();
        int newNumerator = numerator * a;
        int newDenominator = denominator * b;
        FractionObj result = new FractionObj(newNumerator,newDenominator);
        return result;
    }

    public FractionObj div(FractionObj r) {
        if (this.getString() == Constants.INF || r.getString() == Constants.INF) {
            return new FractionObj(1,0);
        }
        int a = r.getNumerator();
        int b = r.getDenominator();
        int newNumerator = numerator * b;
        int newDenominator = denominator * a;
        FractionObj result = new FractionObj(newNumerator,newDenominator);
        return result;
    }
}

package com.company.execption;

/**
 * @program: 项目代码
 * @description: 数组参数异常
 * @author: Mr.Huang
 * @create: 2020-10-11 10:01
 **/
public class ArrayExecption extends RuntimeException{
    public ArrayExecption() {
        super();
    }

    public ArrayExecption(String message) {
        super(message);
    }

    public ArrayExecption(String message, Throwable cause) {
        super(message, cause);
    }

    public ArrayExecption(Throwable cause) {
        super(cause);
    }
}

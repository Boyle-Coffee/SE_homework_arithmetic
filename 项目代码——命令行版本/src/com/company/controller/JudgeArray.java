package com.company.controller;

import java.util.HashMap;

import java.util.Map;

/**
 * @program: 项目代码
 * @description: 判断数组
 * @author: Mr.Huang
 * @create: 2020-10-11 13:48
 **/
public class JudgeArray {

    public boolean isArrayError(String args[]) {

        int fileFlag = 0;
        Map<String, String> map = new HashMap<String, String>();
        if (args.length == 0) {
            return false;
        }
        for (int i = 1; i < args.length; i += 2) {
            map.put(args[i - 1], args[i]);
        }
        for (String key : map.keySet()) {
            if (!("-r".equals(key) || "-n".equals(key)
                    || "-e".equals(key) || "-a".equals(key))) {
                return true;
            }
            if ("-r".equals(key)) {
                boolean matches = map.get(key).matches("[0-9]+");
                if (!matches) {
                    return true;
                }
            }
            if ("-n".equals(key)) {
                boolean matches = map.get(key).matches("[0-9]+");
                if (!matches) {
                    return true;
                }
            }
            if ("-e".equals(key)) {
                boolean matches = map.get(key).matches("[0-9]+");
                fileFlag++;
                if (matches) {
                    return true;
                }
            }
            if ("-a".equals(key)) {
                boolean matches = map.get(key).matches("[0-9]+");
                fileFlag++;
                if (matches) {
                    return true;
                }
            }
        }
        if ((fileFlag & 1) != 0) {
            return true;
        }
        return false;
    }
}

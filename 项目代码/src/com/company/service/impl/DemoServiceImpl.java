package com.company.service.impl;

import com.company.dao.Demo;
import com.company.service.DemoService;

/**
 * @program: 项目代码
 * @description: 业务层接口实现类Demo
 * @author: Mr.Huang
 * @create: 2020-10-08 16:10
 **/
public class DemoServiceImpl implements DemoService {

    private Demo demo = new Demo();

    @Override
    public void demo() {
        System.out.println("调用具体实现方法");
        demo.demo();
    }
}

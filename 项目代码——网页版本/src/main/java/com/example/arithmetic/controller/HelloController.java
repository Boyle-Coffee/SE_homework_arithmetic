package com.example.arithmetic.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @program: arithmetic
 * @description:
 * @author: Mr.Huang
 * @create: 2020-10-11 22:44
 **/
@Controller
public class HelloController {

    @RequestMapping("/hello")
    public String helloThymeleaf(Model model) {
        model.addAttribute("name", "hello Thymeleaf");
        return "hello";
    }

    @RequestMapping("/hi")
    public String hiThymeleaf(Model model) {
        model.addAttribute("name", "hello Thymeleaf");
        return "hi";
    }
}

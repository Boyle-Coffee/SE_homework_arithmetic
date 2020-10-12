package com.example.arithmetic.controller;

import com.example.arithmetic.domain.CheckInfo;
import com.example.arithmetic.domain.QuestionInfo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @program: arithmetic
 * @description:
 * @author: Mr.Huang
 * @create: 2020-10-12 11:50
 **/
@Controller
public class WebController {

    @GetMapping("/questionInfo")
    public String questionForm(Model model) {
        model.addAttribute("gi", new QuestionInfo());
        return "question";
    }

    @GetMapping("/checkInfo")
    public String checkForm(Model model) {
        model.addAttribute("ci", new CheckInfo());
        return "check";
    }

    @GetMapping("/index")
    public String index() {
        return "index";
    }


}

package com.clockworkjava.kursspring.controlers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloControler {
    @RequestMapping("/login")
    public String hello(){
        return "redirect:/knights";
    }
    @RequestMapping("/")
    public String back(){
        return "redirect:/knights";
    }
}

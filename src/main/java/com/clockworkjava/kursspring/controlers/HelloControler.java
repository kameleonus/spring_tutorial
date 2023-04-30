package com.clockworkjava.kursspring.controlers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloControler {
    @RequestMapping("/hello")
    public String hello(){
        return "hello";
    }
}

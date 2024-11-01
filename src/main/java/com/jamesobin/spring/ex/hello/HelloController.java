package com.jamesobin.spring.ex.hello;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {
    @ResponseBody
    @RequestMapping("/helloEx")
    public String helloWorld() {
        return "Hello World!!";
    }
}

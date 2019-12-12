package com.mamin.spring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by otherz on 12.12.2019.
 */
@Controller
public class FirstController {
    @RequestMapping(path = "/hello")
    public String showHelloWorld(){
        return "hello-world";
    }
}

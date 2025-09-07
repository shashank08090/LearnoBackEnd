package com.shashank.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloShashank {

    @GetMapping("/helloshashank")
    public String sayHello() {
        return "Hello Shashank";
    }
}
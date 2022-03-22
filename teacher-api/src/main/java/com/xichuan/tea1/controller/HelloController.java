package com.xichuan.tea1.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("teacher")
public class HelloController {

    @GetMapping("/hello")
    public Object hello() {
        return "hello teacher ~~";
    }



    @GetMapping("/myStuList")
    public Object myStuList() {
        return "hello teacher ~~";
    }



}

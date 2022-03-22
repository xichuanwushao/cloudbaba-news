package com.xichuan.tea1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("teacher")
public class HelloController {

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/hello")
    public Object hello() {
        return "hello teacher ~~";
    }



    @GetMapping("/myStuList")
    public Object myStuList() {

        String url = "http://service-student";

        List list = restTemplate.getForObject(url + "/service-student/student/getStuListByTeacherId?teacherId=10011", ArrayList.class);
        //注意这里加了 context-path 所以路径路由多了一个service-student

        return list;
    }



}

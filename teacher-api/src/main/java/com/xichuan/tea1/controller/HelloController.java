package com.xichuan.tea1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("teacher")
@RefreshScope       // 动态刷新的注解
public class HelloController {

    @Value("${alibaba.teacher.name}")
    private String name;

    @Value("${alibaba.teacher.age}")
    private Integer age;

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/hello")
    public Object hello() {
        return "hello teacher ~~";
    }

    @GetMapping("/myStuListPost")
    public Object myStuListPost() {

        String url = "http://service-student";

        List list = restTemplate.getForObject(url + "/service-student/student/getStuListByTeacherId?teacherId=10011", ArrayList.class);
        //注意这里加了 context-path 所以路径路由多了一个service-student

        return list;
    }


    @GetMapping("/myStuList")
    public Object myStuList() {

        String url = "http://service-student";

        List list = restTemplate.getForObject(url + "/service-student/student/getStuListByTeacherId?teacherId=10011", ArrayList.class);
        //注意这里加了 context-path 所以路径路由多了一个service-student

        return list;
    }

    @GetMapping("/info")
    public Object info() {
        return name + " - " + age;
    }



}

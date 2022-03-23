package com.xichuan.stu1.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("student")
public class HelloController {

    @GetMapping("/hello")
    public Object hello() {
        return "Hello Student~";
    }

    @Value("${server.port}")
    private String port;

    @GetMapping("/getStuListByTeacherId")
    public Object getStuListByTeacherId(String teacherId) {

        // 假设此处经过数据库查询，节约时间

        List stuList = new ArrayList();
        stuList.add("Jack");
        stuList.add("LiEgg");
        stuList.add("Jason");
        stuList.add("BatMan");
        stuList.add("SpiderMan");
        stuList.add("IronMan");

        System.out.println("测试轮询"+port);

        return stuList;
    }

}

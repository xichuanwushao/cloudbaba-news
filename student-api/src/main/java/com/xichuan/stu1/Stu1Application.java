package com.xichuan.stu1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Stu1Application {

    public static void main(String[] args) {
        SpringApplication.run(Stu1Application.class, args);
        System.out.println("http://localhost:8001/service-teacher/teacher/myStuList");
    }

}

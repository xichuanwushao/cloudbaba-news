package com.xichuan.tea1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Tea1Application {

    public static void main(String[] args) {
        SpringApplication.run(Tea1Application.class, args);
        System.out.println("http://localhost:8001/service-teacher/teacher/myStuList");
    }

}

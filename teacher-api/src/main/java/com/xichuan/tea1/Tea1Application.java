package com.xichuan.tea1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient//用于注册服务到zookeeper或者console
@SpringBootApplication
public class Tea1Application {

    public static void main(String[] args) {
        SpringApplication.run(Tea1Application.class, args);
        System.out.println("http://localhost:8001/service-teacher/teacher/myStuList");
    }

}

package com.example.springdata1;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableCaching
@MapperScan("com.example.springdata1.mapper")
public class SpringData1Application {


    public static void main(String[] args) {
        SpringApplication.run(SpringData1Application.class, args);
    }

}

package com.example.lpadmin;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.example.lpadmin.mapper")
public class LpadminApplication {

    public static void main(String[] args) {
        SpringApplication.run(LpadminApplication.class, args);
    }

}

package com.wechat.pickles.client;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = "com.wechat.pickles.client.mapper")
@AutoConfiguration
public class PicklesClientApplication {

    public static void main(String[] args) {
        SpringApplication.run(PicklesClientApplication.class, args);
    }

}

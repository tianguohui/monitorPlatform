package com.ph.monitorPlatform;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.ph.monitorPlatform.mapper")
public class MonitorPlatformApplication {


    public static void main(String[] args) {
        SpringApplication.run(MonitorPlatformApplication.class, args);
    }

}

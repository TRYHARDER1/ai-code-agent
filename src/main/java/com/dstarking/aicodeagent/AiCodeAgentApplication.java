package com.dstarking.aicodeagent;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.dstarking.aicodeagent.mapper")
public class AiCodeAgentApplication {

    public static void main(String[] args) {
        SpringApplication.run(AiCodeAgentApplication.class, args);
    }

}

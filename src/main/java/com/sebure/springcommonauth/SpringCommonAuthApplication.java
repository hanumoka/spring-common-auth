package com.sebure.springcommonauth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class SpringCommonAuthApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringCommonAuthApplication.class, args);
    }

}

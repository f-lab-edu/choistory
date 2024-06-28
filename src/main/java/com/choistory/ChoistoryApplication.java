package com.choistory;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.data.redis.repository.configuration.EnableRedisRepositories;

@EnableCaching
@EnableRedisRepositories
@SpringBootApplication
public class ChoistoryApplication {

    public static void main(String[] args) {
        SpringApplication.run(ChoistoryApplication.class, args);
    }

}

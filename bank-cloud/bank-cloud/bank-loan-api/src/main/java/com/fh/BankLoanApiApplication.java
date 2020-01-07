package com.fh;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.data.redis.repository.configuration.EnableRedisRepositories;

@SpringBootApplication
@EnableFeignClients
@EnableDiscoveryClient
@EnableRedisRepositories
public class BankLoanApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(BankLoanApiApplication.class, args);
    }

}

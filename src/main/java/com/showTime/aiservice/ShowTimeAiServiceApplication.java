package com.showTime.aiservice;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;


@SpringBootApplication
@EnableFeignClients
public class ShowTimeAiServiceApplication {

    public static void main(String args[]){
        SpringApplication.run(ShowTimeAiServiceApplication.class,args);
    }
}

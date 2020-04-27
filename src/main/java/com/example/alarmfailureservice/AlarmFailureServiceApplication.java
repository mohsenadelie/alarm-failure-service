package com.example.alarmfailureservice;

import com.example.alarmfailureservice.services.SMS;
import com.example.alarmfailureservice.services.SendMessageStrategy;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class AlarmFailureServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(AlarmFailureServiceApplication.class, args);
    }

    @Bean
    public SendMessageStrategy getNotification() {
        return new SMS();
    }
}

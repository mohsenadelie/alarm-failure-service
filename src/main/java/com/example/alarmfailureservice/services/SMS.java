package com.example.alarmfailureservice.services;

import java.util.Date;

public class SMS implements SendMessageStrategy {
    @Override
    public void send(String message) {
        System.out.println("From (10002030): \n" +
                "Date/Time : " + new Date(System.currentTimeMillis()) +
                "\nMessage: " + message);
    }
}

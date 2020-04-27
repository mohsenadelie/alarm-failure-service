package com.example.alarmfailureservice.services;

import org.springframework.stereotype.Component;

@Component
public class SendMessageSystem {
    private final SendMessageStrategy strategy;

    public SendMessageSystem(SendMessageStrategy strategy) {
        this.strategy = strategy;
    }

    public void executeStrategy(String message) {
        strategy.send(message);
    }
}

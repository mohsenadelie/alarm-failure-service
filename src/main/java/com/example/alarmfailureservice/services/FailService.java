package com.example.alarmfailureservice.services;

import org.springframework.stereotype.Service;

@Service
public class FailService {

    private final FailSensor failSensor;
    private final SendMessageSystem sendMessageSystem;

    public FailService(FailSensor failSensor, SendMessageSystem sendMessageSystem) {
        this.failSensor = failSensor;
        this.sendMessageSystem = sendMessageSystem;
    }

    public void registerFailureTime(Long timeInMilliSecond) {
        try {
            failSensor.register(timeInMilliSecond);
        } catch (Exception e) {
            sendMessageSystem.executeStrategy(e.getMessage());
        }
    }

}

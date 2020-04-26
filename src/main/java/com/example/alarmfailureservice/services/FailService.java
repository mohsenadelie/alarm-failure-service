package com.example.alarmfailureservice.services;

import org.springframework.stereotype.Service;

import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

@Service
public class FailService {

    private static final Long TIME_PERIOD_SECOND = 60L;
    private static final int FAIL_LIMIT = 5;
    private final Queue<Long> failTimeQueues;

    public FailService() {
        this.failTimeQueues = new ArrayBlockingQueue<>(FAIL_LIMIT);
    }

    public void fail(Long time) {
        clearExpiredElement(time);
        addFailure(time);
        // Convert to class/interface with Strategy Pattern.
        sendNotify();
    }

    public void clearExpiredElement(Long time) {
        while (!failTimeQueues.isEmpty() && (time - failTimeQueues.peek() > TIME_PERIOD_SECOND)) {
            failTimeQueues.poll();
        }
    }

    public void addFailure(Long time) {
        if (isQueueFull()) {
            failTimeQueues.poll();
        }
        failTimeQueues.add(time);
    }

    private boolean isQueueFull() {
        return failTimeQueues.size() == FAIL_LIMIT;
    }

    private void sendNotify() {
        if (isQueueFull()) {
            System.out.println("We have " + FAIL_LIMIT + " failure in " + TIME_PERIOD_SECOND + " seconds");
        }
    }


}

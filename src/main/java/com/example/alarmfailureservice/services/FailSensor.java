package com.example.alarmfailureservice.services;

import org.springframework.stereotype.Service;

import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

@Service
public class FailSensor {
    private static final Long DURATION_IN_MILLISECOND = 60000L;
    private static final int FAIL_LIMIT_NUMBERS = 5;

    private final Queue<Long> failTimeQueues = new ArrayBlockingQueue<>(FAIL_LIMIT_NUMBERS);

    public void register(Long time) throws Exception {
        clearExpiredElements(time);
        addFailure(time);
        if (isQueueFull())
            throw new Exception(FAIL_LIMIT_NUMBERS + " fail happend in " +
                    (DURATION_IN_MILLISECOND / 1000) + " second.");
    }

    private void clearExpiredElements(Long time) {
        while (!failTimeQueues.isEmpty() && (time - failTimeQueues.peek() > DURATION_IN_MILLISECOND)) {
            failTimeQueues.poll();
        }
    }

    public void addFailure(Long time) {
        while (!failTimeQueues.offer(time)) {
            failTimeQueues.poll();
        }
    }

    private boolean isQueueFull() {
        return failTimeQueues.size() == FAIL_LIMIT_NUMBERS;
    }
}

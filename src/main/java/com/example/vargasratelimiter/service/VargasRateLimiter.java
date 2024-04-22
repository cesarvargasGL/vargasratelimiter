package com.example.vargasratelimiter.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.concurrent.Semaphore;

public class VargasRateLimiter {

    private static final Logger logger = LogManager.getLogger(VargasRateLimiter.class);

    private final Semaphore rateLimiter;

    public VargasRateLimiter(int maxLimit) {
        rateLimiter = new Semaphore(maxLimit);
    }

    public boolean isAllowed() {
        int availablePermits = rateLimiter.availablePermits();
        logger.info("availablePermits: {}", availablePermits);
        return rateLimiter.availablePermits() > 0;
    }

    public boolean acquire() {
        logger.info("acquire");
        return rateLimiter.tryAcquire();
    }

    public void release() {
        rateLimiter.release();
        logger.info("available permits: {}", rateLimiter.availablePermits());
    }

}

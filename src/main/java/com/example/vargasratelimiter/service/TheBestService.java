package com.example.vargasratelimiter.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientResponseException;

@Service
public class TheBestService {

    private final VargasRateLimiter vargasRateLimiter;

    private TheBestService(VargasRateLimiter vargasRateLimiter) {
        this.vargasRateLimiter = vargasRateLimiter;
    }

    public String execute() throws InterruptedException {
        if(!vargasRateLimiter.isAllowed()) {
            throw new RestClientResponseException("too many requests", 429, "", null, null, null);
        }
        if (vargasRateLimiter.acquire()) {
            return executeAcquired();
        }

        throw new RestClientResponseException("too many requests", 429, "", null, null, null);
    }

    private String executeAcquired() throws InterruptedException {
        try {
            Thread.sleep(2000);
            return "Success";
        } finally {
            vargasRateLimiter.release();
        }
    }

}

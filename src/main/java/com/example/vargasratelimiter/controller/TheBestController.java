package com.example.vargasratelimiter.controller;

import com.example.vargasratelimiter.service.TheBestService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClientResponseException;

@RestController
public class TheBestController {

    private final TheBestService theBestService;

    public TheBestController(TheBestService theBestService) {
        this.theBestService = theBestService;
    }

    @PostMapping("/execute")
    public ResponseEntity<String> myEndpoint() throws InterruptedException {
        try {
            return ResponseEntity.ok(theBestService.execute());
        } catch(RestClientResponseException ex) {
            return ResponseEntity.status(ex.getStatusCode()).body(ex.getMessage());
        }
    }
}

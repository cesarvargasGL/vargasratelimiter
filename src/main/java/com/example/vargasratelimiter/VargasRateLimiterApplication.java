package com.example.vargasratelimiter;

import com.example.vargasratelimiter.service.VargasRateLimiter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class VargasRateLimiterApplication {

	public static void main(String[] args) {
		SpringApplication.run(VargasRateLimiterApplication.class, args);
	}

	@Bean
	public VargasRateLimiter myVargasRateLimiter(@Value("${max.limit}") int maxLimit) {
		return new VargasRateLimiter(maxLimit);
	}
}

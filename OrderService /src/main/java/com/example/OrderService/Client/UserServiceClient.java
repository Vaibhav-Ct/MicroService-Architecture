package com.example.OrderService.Client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "user-service", url = "http://localhost:8080/api")
public interface UserServiceClient {
    @GetMapping("/id")
    String getUserById(@RequestParam String id);
}
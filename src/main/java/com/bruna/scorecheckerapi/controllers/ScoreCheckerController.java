package com.bruna.scorecheckerapi.controllers;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/score")
public class ScoreCheckerController {
    @Autowired
    public RestTemplate restTemplate;
    @GetMapping("/customer")
    @CircuitBreaker(name = "depositCheckerApi", fallbackMethod = "getDefaultDepositValue")
    public Double getDeposits(){
        return  restTemplate.getForObject("http://localhost:8081/deposit", Double.class);
    }
    public Double getDefaultDepositValue(Exception exception){
        return 10.00;
    }

}

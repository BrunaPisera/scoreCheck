package com.bruna.scorecheckerapi.controllers;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/score")
public class ScoreCheckerController {
    @Autowired
    public RestTemplate restTemplate;
    @Autowired
    DiscoveryClient discoveryClient;
    @GetMapping("/customer")
    @CircuitBreaker(name = "depositCheckerApi", fallbackMethod = "getDefaultDepositValue")

    public Double getDeposits(){
        discoveryClient.getInstances("DEPOSIT-CHECKER").stream().forEach(serviceInstance -> System.out.println(serviceInstance.getHost() + ": " + serviceInstance.getPort()));
        return  restTemplate.getForObject("http://DEPOSIT-CHECKER/deposit", Double.class);
    }
    public Double getDefaultDepositValue(Exception exception){
        return 10.00;
    }

}

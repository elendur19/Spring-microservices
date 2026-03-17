package com.robic.clients.fraud;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
/*
Any microservice which wants to talk to Fraud
has to use this interface
 */
@FeignClient(
        value = "fraud",
        url = "http://localhost:8081")
public interface FraudClient {
    // Interface which target's Fraud controller, without body
    @GetMapping(path = "api/v1/fraud-check/{customerId}")
    FraudCheckResponse isFraudster(@PathVariable("customerId") Integer customerId);
}

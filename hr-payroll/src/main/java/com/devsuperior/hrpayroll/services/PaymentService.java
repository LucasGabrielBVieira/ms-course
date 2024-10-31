package com.devsuperior.hrpayroll.services;

import com.devsuperior.hrpayroll.entities.Payment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class PaymentService {

    @Value("${hr-worker.host}")
    private String workerHost;

    @Autowired
    private RestTemplate restTemplate;

    public Payment getPayment(long workerId, int days) {

        Worker worker = restTemplate.getForObject();
        return new Payment("Bob", 200.0, days);
    }
}

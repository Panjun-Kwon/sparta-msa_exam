package com.sparta.msa_exam.order.api;

import org.springframework.beans.factory.annotation.*;
import org.springframework.web.bind.annotation.*;

@RestController
public class HealthController {

    @Value("${spring.application.name}")
    private String appName;
    @Value("${server.port}")
    private String serverPort;

    @GetMapping("/order/info")
    public String info() {
        return appName + " : " + serverPort;
    }
}

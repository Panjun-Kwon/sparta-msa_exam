package com.sparta.msa_exam.product.api;

import jakarta.servlet.http.*;
import lombok.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.*;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class HealthController {

    @Value("${spring.application.name}")
    private String appName;
//    @Value("${server.port}")
//    private String serverPort;
    private final Environment env;

    @GetMapping("/products/info")
    public String info(HttpServletResponse response) {
        String serverPort = env.getProperty("local.server.port");
        return appName + " : " + serverPort;
    }
}

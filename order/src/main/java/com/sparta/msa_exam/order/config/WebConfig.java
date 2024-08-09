package com.sparta.msa_exam.order.config;

import com.sparta.msa_exam.order.interceptor.*;
import org.springframework.context.annotation.*;
import org.springframework.web.servlet.config.annotation.*;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new HeaderInterceptor())
                .addPathPatterns("/**");
    }
}
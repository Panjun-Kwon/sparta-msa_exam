package com.sparta.msa_exam.auth.interceptor;

import jakarta.servlet.http.*;
import org.springframework.stereotype.*;
import org.springframework.web.servlet.*;

@Component
public class HeaderInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        int serverPort = request.getServerPort();
        response.addHeader("Server-Port", String.valueOf(serverPort));
        return true;
    }

}

package com.sparta.msa_exam.gateway.ffilter;

import com.sparta.msa_exam.gateway.jwt.*;
import lombok.*;
import org.springframework.cloud.gateway.filter.*;
import org.springframework.core.*;
import org.springframework.http.*;
import org.springframework.stereotype.*;
import org.springframework.web.server.*;
import reactor.core.publisher.*;

@Component
@RequiredArgsConstructor
public class AuthFilter implements GlobalFilter, Ordered {

    private final JwtUtils jwtUtils;

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        String path = exchange.getRequest().getURI().getPath();
        if (path.equals("/auth/signIn")) {
            return chain.filter(exchange);
        }

        String accessToken = jwtUtils.extractToken(exchange);

        if (accessToken == null || !jwtUtils.validateToken(accessToken)) {
            exchange.getResponse().setStatusCode(HttpStatus.UNAUTHORIZED);
            return exchange.getResponse().setComplete();
        }

        return chain.filter(exchange);
    }

    @Override
    public int getOrder() {
        return Ordered.HIGHEST_PRECEDENCE;
    }
}

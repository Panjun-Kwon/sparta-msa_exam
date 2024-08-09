package com.sparta.msa_exam.auth.app;

import com.sparta.msa_exam.auth.jwt.*;
import lombok.*;
import org.springframework.stereotype.*;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final JwtUtils jwtUtils;

    public String signIn(String userId) {
        return jwtUtils.generateAccessToken(userId);
    }
}

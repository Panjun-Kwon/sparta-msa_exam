package com.sparta.msa_exam.auth.api;

import com.sparta.msa_exam.auth.api.dto.*;
import com.sparta.msa_exam.auth.app.*;
import lombok.*;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @GetMapping("/auth/signIn")
    public SignInRes signIn(@RequestParam("user_id") String user_id) {
        String accessToken = authService.signIn(user_id);
        return new SignInRes(accessToken);
    }

}

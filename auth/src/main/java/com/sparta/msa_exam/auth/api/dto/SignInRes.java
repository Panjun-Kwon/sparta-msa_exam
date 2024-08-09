package com.sparta.msa_exam.auth.api.dto;

import lombok.*;

@Getter
@NoArgsConstructor
public class SignInRes {

    private String accessToken;

    public SignInRes(String accessToken) {
        this.accessToken = accessToken;
    }
}

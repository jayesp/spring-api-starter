package com.codewithmosh.store.auth;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class LoginResponse {
    private final Jwt accessToken;
    private final Jwt refreshToken;
}

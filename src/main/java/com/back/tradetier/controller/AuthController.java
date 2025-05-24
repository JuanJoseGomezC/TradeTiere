package com.back.tradetier.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.back.tradetier.dto.LoginDto;
import com.back.tradetier.dto.RegisterDto;
import com.back.tradetier.dto.TokenDto;
import com.back.tradetier.service.UserService;

import lombok.RequiredArgsConstructor;


@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthController {
    private final UserService userService;

    @PostMapping("/register")
    public ResponseEntity<TokenDto> register(@RequestBody final RegisterDto registerDto) {
        return ResponseEntity.ok(userService.register(registerDto));
    }

    @PostMapping("/login")
    public ResponseEntity<TokenDto> login(@RequestBody final LoginDto loginDto) {
        return ResponseEntity.ok(userService.login(loginDto));
    }

    // @PostMapping("/refresh")
    // public TokenResponse refreshToken(@RequestHeader(HttpHeaders.AUTHORIZATION) final String authHeader) {
    //     return authService.refreshToken(authHeader);
    // }

}

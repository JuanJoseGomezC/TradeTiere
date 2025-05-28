package com.back.tradetier.config.security;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import com.back.tradetier.exceptions.ResourceNotFoundException;
import com.back.tradetier.model.User;
import com.back.tradetier.repository.UserRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RequiredArgsConstructor
@Component
@Slf4j
public class SecurityUtils {

    private final JwtService jwtService;
    private final UserRepository userRepository;

    public String getCurrentToken() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if (authentication != null) {
            Object credentials = authentication.getCredentials();
            if (credentials instanceof String string) {
                return string;
            }
        }
        return null;
    }

    public User getCurrentUser() {
        String token = getCurrentToken();
        String mail = jwtService.extractMail(token);
        log.debug("Extracting user with email: {}", mail);

        return userRepository.findByMail(mail)
                .orElseThrow(() -> new ResourceNotFoundException("User not found with email: " + mail));
    }
}
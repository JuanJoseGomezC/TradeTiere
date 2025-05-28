package com.back.tradetier.config.security;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.back.tradetier.repository.UserRepository;
import com.back.tradetier.service.UserService;

import io.micrometer.common.lang.NonNull;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class JwtAuthenticationFilter extends OncePerRequestFilter {

    private final JwtService jwtService;
    private final UserRepository userRepository;

    private static final List<String> WHITELIST = Arrays.asList(
        // Endpoints públicos de tu API
        "/api/v1/auth/login",
        "/api/v1/auth/register",
        "/api/v1/public/",

        // Rutas de Swagger/OpenAPI
        "/swagger-ui.html",
        "/swagger-ui/",          // Incluye subrutas (/swagger-ui/*)
        "/v3/api-docs",          // Endpoint principal
        "/v3/api-docs/",         // Subrutas (/v3/api-docs/*)
        "/swagger-resources",    // Recursos de Swagger
        "/swagger-resources/",   // Subrutas
        "/webjars/",             // Archivos estáticos (JS/CSS)
        "/favicon.ico"           // Icono de Swagger
    );

    @Override
    protected boolean shouldNotFilter(HttpServletRequest request) {
        String path = request.getRequestURI();
        return WHITELIST.stream().anyMatch(whitelistedPath -> 
            path.startsWith(whitelistedPath) // Coincidencia por prefijo
        );
    }

    @Override
    protected void doFilterInternal(@NonNull HttpServletRequest request,
                                    @NonNull HttpServletResponse response,
                                    @NonNull FilterChain filterChain)
        throws ServletException, IOException {

        final String authHeader = request.getHeader("Authorization");
        if (authHeader == null || !authHeader.startsWith("Bearer ") || !userRepository.findByMail( jwtService.extractMail(authHeader.substring("Bearer ".length()))).isPresent()) {
                response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Token inválido o expirado");
            return;
        }
        String jwt = authHeader.substring("Bearer ".length());

        if (jwtService.isTokenValid(jwt)) {
            String mail = jwtService.extractMail(jwt);

            UsernamePasswordAuthenticationToken authToken =
                new UsernamePasswordAuthenticationToken(
                    mail,
                    jwt
                );
            SecurityContextHolder.getContext().setAuthentication(authToken);
        }

        filterChain.doFilter(request, response);
    }
}
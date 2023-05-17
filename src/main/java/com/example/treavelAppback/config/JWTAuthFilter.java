package com.example.treavelAppback.config;

import com.example.treavelAppback.service.JWTService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;


@Component
@RequiredArgsConstructor
public class JWTAuthFilter extends OncePerRequestFilter {

    private final JWTService jwtService;

    @Override
    protected void doFilterInternal(@NonNull HttpServletRequest request,
                                    @NonNull HttpServletResponse response,
                                    @NonNull FilterChain filterChain) throws ServletException, IOException {
        final String authoHeader = request.getHeader("Authorization");
        final String jwt;
        final String userEmail;
        if (authoHeader != null && authoHeader.startsWith("Bearer ")) {
            jwt = authoHeader.substring(7);
            userEmail = jwtService.extractUserEmail(jwt);



        }
        else {
           filterChain.doFilter(request, response);
           return;
        }

    }
}

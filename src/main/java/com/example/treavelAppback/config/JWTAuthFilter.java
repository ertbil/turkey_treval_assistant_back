package com.example.treavelAppback.config;

import com.example.treavelAppback.consts.strings.ErrorInfo;
import com.example.treavelAppback.service.JWTService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;


@Component
@RequiredArgsConstructor
public class JWTAuthFilter extends OncePerRequestFilter {

    private final JWTService jwtService;
    private final UserDetailsService userDetailsService;

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

            if (userEmail != null && SecurityContextHolder.getContext().getAuthentication() == null) {
                UserDetails user = this.userDetailsService.loadUserByUsername(userEmail);
                if (jwtService.isTokenValid(jwt, user)) {
                    UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(
                            user,
                            null
                            , user.getAuthorities()
                    );

                    authToken.setDetails(
                            new WebAuthenticationDetailsSource().buildDetails(request)
                    );

                    SecurityContextHolder.getContext().setAuthentication(authToken);
                } else {
                    response.sendError(HttpServletResponse.SC_UNAUTHORIZED, ErrorInfo.inValidToken);

                }
            } else {
                response.sendError(HttpServletResponse.SC_UNAUTHORIZED, ErrorInfo.inValidToken);
            }

        } else {
            filterChain.doFilter(request, response);

        }

    }
}

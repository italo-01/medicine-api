package com.udemy.PrimeiroProjetoSpring.infra;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
public class SecurityFilter extends OncePerRequestFilter {
    @Autowired
    private TokenService tokenService;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        var tokenJWt = recuperartoken(request);

        var subject = tokenService.getSubject(tokenJWt);

        filterChain.doFilter(request, response);

    }

    private String recuperartoken(HttpServletRequest request) {
        var authorationHeader = request.getHeader("Authorization");
        if (authorationHeader == null ){
            throw new RuntimeException("Token não enviado");
        }
        return authorationHeader;
    }
}

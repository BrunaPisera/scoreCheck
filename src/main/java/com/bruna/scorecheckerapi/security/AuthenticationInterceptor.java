package com.bruna.scorecheckerapi.security;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

public class AuthenticationInterceptor extends OncePerRequestFilter {
    private final String USER = "bank";
    private final String PWD = "123";
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

    }

    private void authenticate(HttpServletRequest request){

    }
}

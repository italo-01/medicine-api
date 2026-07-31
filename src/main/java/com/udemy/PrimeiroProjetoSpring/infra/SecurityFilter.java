package com.udemy.PrimeiroProjetoSpring.infra;

import com.udemy.PrimeiroProjetoSpring.usuarios.Usuario;
import com.udemy.PrimeiroProjetoSpring.usuarios.UsuarioRepository;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
public class SecurityFilter extends OncePerRequestFilter {
    @Autowired
    private TokenService tokenService;

    @Autowired
    private UsuarioRepository repository;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {


        var tokenJWt = recuperartoken(request);

        if (tokenJWt != null) {
            var subject = tokenService.getSubject(tokenJWt);

            var usuario = repository.findByLogin(subject);
            var authetication = new UsernamePasswordAuthenticationToken(usuario, null, usuario.getAuthorities());

            SecurityContextHolder.getContext().setAuthentication(authetication);
        }

        filterChain.doFilter(request, response);

    }

    private String recuperartoken(HttpServletRequest request) {
        var authorationHeader = request.getHeader("Authorization");
        if (authorationHeader != null) {
            return authorationHeader.replace("Bearer ", "");
        }
        return null;
    }
}

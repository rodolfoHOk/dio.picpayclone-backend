package br.com.dio.picpayclone.configuration.security;

import br.com.dio.picpayclone.application.ports.inbound.ITokenService;
import br.com.dio.picpayclone.domain.models.User;
import br.com.dio.picpayclone.domain.services.IUserService;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.UUID;

public class AuthenticationTokenFilter extends OncePerRequestFilter {

    private final ITokenService tokenService;
    private final IUserService userService;

    public AuthenticationTokenFilter(ITokenService tokenService, IUserService userService) {
        this.tokenService = tokenService;
        this.userService = userService;
    }

    @Override
    protected void doFilterInternal(
            HttpServletRequest request,
            HttpServletResponse response,
            FilterChain filterChain
    ) throws ServletException, IOException {
        String token = getTokenFromRequest(request);
        Boolean isValid = tokenService.isTokenValid(token);
        if (isValid) {
            authenticateClient(token);
        }
        filterChain.doFilter(request, response);
    }

    private String getTokenFromRequest(HttpServletRequest request) {
        String token = request.getHeader("Authorization");
        if (token == null || !token.startsWith("Bearer ")) {
            return null;
        }
        return token.substring(7);
    }

    private void authenticateClient(String token) {
        UUID userId = tokenService.getUserId(token);
        User user = userService.findById(userId);
        var authenticationUser = (AuthenticationUser) user;
        UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(user,
                null, authenticationUser.getAuthorities());
        SecurityContextHolder.getContext().setAuthentication(authentication);
    }

}

package br.com.dio.picpayclone.configuration.security;

import br.com.dio.picpayclone.application.ports.inbound.ITokenService;
import br.com.dio.picpayclone.infrastructure.persistence.repositories.UserRepository;

import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

public class AuthenticationTokenFilter extends UsernamePasswordAuthenticationFilter {

    private final ITokenService tokenService;
    private final UserRepository userRepository;

    public AuthenticationTokenFilter(ITokenService tokenService, UserRepository userRepository) {
        this.tokenService = tokenService;
        this.userRepository = userRepository;
    }

}

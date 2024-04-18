package br.com.dio.picpayclone.infrastructure.web.security.configuration;

import br.com.dio.picpayclone.infrastructure.web.security.usecases.IAuthenticateUseCase;
import br.com.dio.picpayclone.infrastructure.web.security.services.ITokenService;
import br.com.dio.picpayclone.infrastructure.web.security.usecases.AuthenticateUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;

@Configuration
public class AuthenticationResourceConfig {

    @Bean
    public IAuthenticateUseCase authenticateUseCase(AuthenticationManager authenticationManager, ITokenService tokenService) {
        return new AuthenticateUseCase(authenticationManager, tokenService);
    }

}

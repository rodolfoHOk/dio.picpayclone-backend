package br.com.dio.picpayclone.configuration;

import br.com.dio.picpayclone.application.ports.inbound.IAuthenticateUseCase;
import br.com.dio.picpayclone.application.ports.inbound.ITokenService;
import br.com.dio.picpayclone.application.services.TokenService;
import br.com.dio.picpayclone.application.usecases.AuthenticateUseCase;
import br.com.dio.picpayclone.infrastructure.api.mappers.LoginRequestMapper;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;

@Configuration
public class AuthenticationConfig {

    @Bean
    public LoginRequestMapper loginRequestMapper(ModelMapper modelMapper) {
        return new LoginRequestMapper(modelMapper);
    }

    @Bean
    public ITokenService tokenService() {
        return new TokenService();
    }

    @Bean
    public IAuthenticateUseCase authenticateUseCase(AuthenticationManager authenticationManager, ITokenService tokenService) {
        return new AuthenticateUseCase(authenticationManager, tokenService);
    }

}

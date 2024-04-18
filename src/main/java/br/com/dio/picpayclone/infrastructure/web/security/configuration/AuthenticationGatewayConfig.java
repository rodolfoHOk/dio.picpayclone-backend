package br.com.dio.picpayclone.infrastructure.web.security.configuration;

import br.com.dio.picpayclone.application.ports.outbound.IAuthenticationGateway;
import br.com.dio.picpayclone.infrastructure.web.mappers.LoginRequestMapper;
import br.com.dio.picpayclone.infrastructure.web.security.adapters.AuthenticationGateway;
import br.com.dio.picpayclone.infrastructure.web.security.services.ITokenService;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;

@Configuration
public class AuthenticationGatewayConfig {

    @Bean
    public LoginRequestMapper loginRequestMapper(ModelMapper modelMapper) {
        return new LoginRequestMapper(modelMapper);
    }

    @Bean
    public IAuthenticationGateway authenticationGateway(
            AuthenticationManager authenticationManager,
            ITokenService tokenService,
            LoginRequestMapper loginRequestMapper
    ) {
        return new AuthenticationGateway(authenticationManager, tokenService, loginRequestMapper);
    }

}

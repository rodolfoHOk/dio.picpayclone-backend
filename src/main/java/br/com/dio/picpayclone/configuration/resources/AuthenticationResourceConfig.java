package br.com.dio.picpayclone.configuration.resources;

import br.com.dio.picpayclone.application.ports.inbound.IAuthenticateUseCase;
import br.com.dio.picpayclone.application.ports.outbound.IAuthenticationGateway;
import br.com.dio.picpayclone.application.usecases.AuthenticateUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AuthenticationResourceConfig {

    @Bean
    public IAuthenticateUseCase authenticateUseCase(IAuthenticationGateway authenticationGateway) {
        return new AuthenticateUseCase(authenticationGateway);
    }

}

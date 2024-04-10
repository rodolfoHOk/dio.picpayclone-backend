package br.com.dio.picpayclone.configuration;

import br.com.dio.picpayclone.application.converter.UserConverter;
import br.com.dio.picpayclone.application.ports.inbound.IGetUserByLoginUseCase;
import br.com.dio.picpayclone.application.ports.outbound.IUserGateway;
import br.com.dio.picpayclone.application.usecases.GetUserByLoginUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UserConfig {

    @Bean
    public IGetUserByLoginUseCase getUserByLoginUseCase(IUserGateway userGateway, UserConverter userConverter) {
        return new GetUserByLoginUseCase(userGateway, userConverter);
    }
}

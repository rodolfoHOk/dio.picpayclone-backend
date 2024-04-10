package br.com.dio.picpayclone.configuration;

import br.com.dio.picpayclone.application.converter.UserConverter;
import br.com.dio.picpayclone.application.ports.inbound.IGetUserBalanceByLoginUseCase;
import br.com.dio.picpayclone.application.ports.inbound.IGetUserByLoginUseCase;
import br.com.dio.picpayclone.application.ports.inbound.IListUserContactsByLoginUseCase;
import br.com.dio.picpayclone.application.ports.outbound.IUserGateway;
import br.com.dio.picpayclone.application.usecases.GetUserBalanceByLoginUseCase;
import br.com.dio.picpayclone.application.usecases.GetUserByLoginUseCase;
import br.com.dio.picpayclone.application.usecases.ListUserContactsByLoginUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UserConfig {

    @Bean
    public IGetUserByLoginUseCase getUserByLoginUseCase(IUserGateway userGateway, UserConverter userConverter) {
        return new GetUserByLoginUseCase(userGateway, userConverter);
    }

    @Bean
    public IListUserContactsByLoginUseCase listUserContactsByLoginUseCase(
            IUserGateway userGateway, UserConverter userConverter) {
        return new ListUserContactsByLoginUseCase(userGateway, userConverter);
    }

    @Bean
    public IGetUserBalanceByLoginUseCase getUserBalanceByLoginUseCase(IUserGateway userGateway) {
        return new GetUserBalanceByLoginUseCase(userGateway);
    }
}

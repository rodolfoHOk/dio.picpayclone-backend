package br.com.dio.picpayclone.configuration.resources;

import br.com.dio.picpayclone.application.converter.UserConverter;
import br.com.dio.picpayclone.application.ports.inbound.IGetUserBalanceByLoginUseCase;
import br.com.dio.picpayclone.application.ports.inbound.IGetUserByLoginUseCase;
import br.com.dio.picpayclone.application.ports.inbound.IListUserContactsByLoginUseCase;
import br.com.dio.picpayclone.application.ports.outbound.IUserGateway;
import br.com.dio.picpayclone.application.usecases.GetUserBalanceByLoginUseCase;
import br.com.dio.picpayclone.application.usecases.GetUserByLoginUseCase;
import br.com.dio.picpayclone.application.usecases.ListUserContactsByLoginUseCase;
import br.com.dio.picpayclone.domain.services.IUserService;
import br.com.dio.picpayclone.domain.services.impl.UserService;
import br.com.dio.picpayclone.infrastructure.persistence.adapters.UserGateway;
import br.com.dio.picpayclone.infrastructure.persistence.repositories.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UserConfig {

    @Bean
    public UserConverter userConverter(ModelMapper modelMapper) {
        return new UserConverter(modelMapper);
    }

    @Bean
    public IUserGateway userGateway(UserRepository userRepository) {
        return new UserGateway(userRepository);
    }

    @Bean
    public IUserService userService(IUserGateway userGateway) {
        return new UserService(userGateway);
    }

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

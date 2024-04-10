package br.com.dio.picpayclone.application.usecases;

import br.com.dio.picpayclone.application.converter.UserConverter;
import br.com.dio.picpayclone.application.dtos.UserDTO;
import br.com.dio.picpayclone.application.ports.inbound.IGetUserByLoginUseCase;
import br.com.dio.picpayclone.application.ports.outbound.IUserGateway;
import br.com.dio.picpayclone.domain.models.User;

public class GetUserByLoginUseCase implements IGetUserByLoginUseCase {

    private final IUserGateway userGateway;
    private final UserConverter userConverter;

    public GetUserByLoginUseCase(IUserGateway userGateway, UserConverter userConverter) {
        this.userGateway = userGateway;
        this.userConverter = userConverter;
    }

    @Override
    public UserDTO execute(String login) {
        User user = userGateway.findByLogin(login);
        return userConverter.entityToDtoConverter(user);
    }
}

package br.com.dio.picpayclone.application.usecases;

import br.com.dio.picpayclone.application.converter.UserConverter;
import br.com.dio.picpayclone.application.dtos.UserDTO;
import br.com.dio.picpayclone.application.ports.inbound.IListUserContactsByLoginUseCase;
import br.com.dio.picpayclone.application.ports.outbound.IUserGateway;
import br.com.dio.picpayclone.domain.models.User;

import java.util.List;

public class ListUserContactsByLoginUseCase implements IListUserContactsByLoginUseCase {

    private final IUserGateway userGateway;
    private final UserConverter userConverter;

    public ListUserContactsByLoginUseCase(IUserGateway userGateway, UserConverter userConverter) {
        this.userGateway = userGateway;
        this.userConverter = userConverter;
    }

    @Override
    public List<UserDTO> execute(String login) {
        List<User> users = userGateway.getContactsByUserLogin(login);
        return userConverter.entitiesToDtosConverter(users);
    }
}

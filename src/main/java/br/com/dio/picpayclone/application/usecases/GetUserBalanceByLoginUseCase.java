package br.com.dio.picpayclone.application.usecases;

import br.com.dio.picpayclone.application.dtos.BalanceDTO;
import br.com.dio.picpayclone.application.ports.inbound.IGetUserBalanceByLoginUseCase;
import br.com.dio.picpayclone.application.ports.outbound.IUserGateway;
import br.com.dio.picpayclone.domain.models.User;

public class GetUserBalanceByLoginUseCase implements IGetUserBalanceByLoginUseCase {

    private final IUserGateway userGateway;

    public GetUserBalanceByLoginUseCase(IUserGateway userGateway) {
        this.userGateway = userGateway;
    }

    @Override
    public BalanceDTO execute(String login) {
        User user = userGateway.findByLogin(login);
        return new BalanceDTO(login, user.getBalance());
    }
}

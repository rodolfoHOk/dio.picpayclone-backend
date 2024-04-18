package br.com.dio.picpayclone.application.usecases;

import br.com.dio.picpayclone.application.dtos.LoginDTO;
import br.com.dio.picpayclone.application.ports.inbound.IAuthenticateUseCase;
import br.com.dio.picpayclone.application.ports.outbound.IAuthenticationGateway;
import br.com.dio.picpayclone.application.dtos.TokenDTO;

public class AuthenticateUseCase implements IAuthenticateUseCase {

    private final IAuthenticationGateway authenticationGateway;

    public AuthenticateUseCase(IAuthenticationGateway authenticationGateway) {
        this.authenticationGateway = authenticationGateway;
    }

    @Override
    public TokenDTO execute(LoginDTO loginDTO) {
        return authenticationGateway.authenticate(loginDTO);
    }

}

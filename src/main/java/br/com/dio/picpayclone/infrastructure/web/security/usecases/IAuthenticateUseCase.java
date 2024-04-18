package br.com.dio.picpayclone.infrastructure.web.security.usecases;

import br.com.dio.picpayclone.infrastructure.web.requests.LoginRequest;
import br.com.dio.picpayclone.infrastructure.web.responses.TokenResponse;

public interface IAuthenticateUseCase {

    TokenResponse execute(LoginRequest loginRequest);

}

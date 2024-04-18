package br.com.dio.picpayclone.application.ports.inbound;

import br.com.dio.picpayclone.application.dtos.LoginDTO;
import br.com.dio.picpayclone.application.dtos.TokenDTO;

public interface IAuthenticateUseCase {

    TokenDTO execute(LoginDTO loginDTO);

}

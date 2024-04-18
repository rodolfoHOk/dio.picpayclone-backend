package br.com.dio.picpayclone.application.ports.outbound;

import br.com.dio.picpayclone.application.dtos.LoginDTO;
import br.com.dio.picpayclone.application.dtos.TokenDTO;

public interface IAuthenticationGateway {

    TokenDTO authenticate(LoginDTO loginDTO);

}

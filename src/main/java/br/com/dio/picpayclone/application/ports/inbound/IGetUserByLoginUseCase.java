package br.com.dio.picpayclone.application.ports.inbound;

import br.com.dio.picpayclone.application.dtos.UserDTO;

public interface IGetUserByLoginUseCase {

    UserDTO execute(String login);
}

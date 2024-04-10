package br.com.dio.picpayclone.application.ports.inbound;

import br.com.dio.picpayclone.application.dtos.UserDTO;

import java.util.List;

public interface IListUserContactsByLoginUseCase {
    List<UserDTO> execute(String login);
}

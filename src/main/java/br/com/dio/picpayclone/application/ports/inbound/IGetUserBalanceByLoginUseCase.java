package br.com.dio.picpayclone.application.ports.inbound;

import br.com.dio.picpayclone.application.dtos.BalanceDTO;

public interface IGetUserBalanceByLoginUseCase {

    BalanceDTO execute(String login);
}

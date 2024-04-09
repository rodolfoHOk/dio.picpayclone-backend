package br.com.dio.picpayclone.application.ports.outbound;

import br.com.dio.picpayclone.domain.models.User;

import java.math.BigDecimal;

public interface IUserGateway {
    User findByLogin(String login);

    void updateIncrementBalance(String login, BigDecimal amount);

    void updateDecrementBalance(String login, BigDecimal amount);
}

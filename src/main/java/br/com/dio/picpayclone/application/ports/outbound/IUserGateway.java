package br.com.dio.picpayclone.application.ports.outbound;

import br.com.dio.picpayclone.domain.models.User;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

public interface IUserGateway {

    User findById(UUID id);

    User findByLogin(String login);

    void updateIncrementBalance(String login, BigDecimal amount);

    void updateDecrementBalance(String login, BigDecimal amount);

    List<User> getContactsByUserLogin(String login);

}

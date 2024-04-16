package br.com.dio.picpayclone.domain.services;

import br.com.dio.picpayclone.domain.models.Transaction;
import br.com.dio.picpayclone.domain.models.User;

public interface IUserService {
    User findByLogin(String login);

    void validate(User... users);

    void updateBalance(Transaction transaction, boolean isCreditCard);
}

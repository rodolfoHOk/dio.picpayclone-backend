package br.com.dio.picpayclone.domain.services.impl;

import br.com.dio.picpayclone.application.ports.outbound.IUserGateway;
import br.com.dio.picpayclone.domain.exceptions.BusinessException;
import br.com.dio.picpayclone.domain.models.Transaction;
import br.com.dio.picpayclone.domain.models.User;
import br.com.dio.picpayclone.domain.services.IUserService;
import org.springframework.scheduling.annotation.Async;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;

public class UserService implements IUserService {

    private final IUserGateway userGateway;

    public UserService(IUserGateway userGateway) {
        this.userGateway = userGateway;
    }

    @Override
    public User findByLogin(String login) {
        return userGateway.findByLogin(login);
    }

    @Override
    public void validate(User... users) {
        Arrays.asList(users).forEach(user -> {
            if (user == null) {
                throw new BusinessException("Usuário informado não existe");
            }
        });
    }

    @Override
    @Async("asyncExecutor")
    @Transactional
    public void updateBalance(Transaction transaction, boolean isCreditCard) {
        decrementBalance(transaction, isCreditCard);
        incrementBalance(transaction);
    }

    private void incrementBalance(Transaction transaction) {
        userGateway.updateIncrementBalance(transaction.getDestination().getLogin(), transaction.getAmount());
    }

    private void decrementBalance(Transaction transaction, Boolean isCreditCard) {
        if (!isCreditCard) {
            userGateway.updateDecrementBalance(transaction.getOrigin().getLogin(), transaction.getAmount());
        }
    }
}

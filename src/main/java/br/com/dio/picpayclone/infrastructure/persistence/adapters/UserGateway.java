package br.com.dio.picpayclone.infrastructure.persistence.adapters;

import br.com.dio.picpayclone.application.ports.outbound.IUserGateway;
import br.com.dio.picpayclone.domain.constants.ValidationMessages;
import br.com.dio.picpayclone.domain.exceptions.NotFoundException;
import br.com.dio.picpayclone.domain.models.User;
import br.com.dio.picpayclone.infrastructure.persistence.adapters.mapper.UserEntityMapper;
import br.com.dio.picpayclone.infrastructure.persistence.repositories.UserRepository;

import java.math.BigDecimal;
import java.util.List;

public class UserGateway implements IUserGateway {

    private final UserRepository userRepository;

    public UserGateway(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User findByLogin(String login) {
        var userEntity = userRepository.findByLogin(login)
                .orElseThrow(() -> new NotFoundException(ValidationMessages.ERROR_USER_NOT_EXISTS));
        return UserEntityMapper.toDomainModel(userEntity);
    }

    @Override
    public void updateIncrementBalance(String login, BigDecimal amount) {
        userRepository.updateIncrementBalance(login, amount);
    }

    @Override
    public void updateDecrementBalance(String login, BigDecimal amount) {
        userRepository.updateDecrementBalance(login, amount);
    }

    @Override
    public List<User> getContactsByUserLogin(String login) {
        var userEntity = userRepository.findByLogin(login)
                .orElseThrow(() -> new NotFoundException(ValidationMessages.ERROR_USER_NOT_EXISTS));
        var contacts = userEntity.getContacts();
        return contacts.stream().map(UserEntityMapper::toDomainModel).toList();
    }

}

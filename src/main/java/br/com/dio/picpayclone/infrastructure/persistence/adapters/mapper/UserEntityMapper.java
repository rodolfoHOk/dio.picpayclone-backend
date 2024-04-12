package br.com.dio.picpayclone.infrastructure.persistence.adapters.mapper;

import br.com.dio.picpayclone.domain.models.CreditCard;
import br.com.dio.picpayclone.domain.models.User;
import br.com.dio.picpayclone.infrastructure.persistence.entities.CreditCardEntity;
import br.com.dio.picpayclone.infrastructure.persistence.entities.UserEntity;

import java.util.ArrayList;

public class UserEntityMapper {

    public static UserEntity toEntity(User userDomainModel) {
        var creditCards = userDomainModel.getCreditCards() != null ? userDomainModel.getCreditCards().stream()
                .map(CreditCardEntityMapper::toEntity)
                .toList() : new ArrayList<CreditCardEntity>();

        return UserEntity.builder()
                .id(userDomainModel.getId())
                .login(userDomainModel.getLogin())
                .password(userDomainModel.getPassword())
                .email(userDomainModel.getEmail())
                .completeName(userDomainModel.getCompleteName())
                .cpf(userDomainModel.getCpf())
                .birthday(userDomainModel.getBirthday())
                .phoneNumber(userDomainModel.getPhoneNumber())
                .balance(userDomainModel.getBalance())
                .creditCards(creditCards)
                .active(userDomainModel.getActive())
                .build();
    }

    public static User toDomainModel(UserEntity userEntity) {
        var creditCards = userEntity.getCreditCards() != null ? userEntity.getCreditCards().stream()
                .map(CreditCardEntityMapper::toDomainModel)
                .toList() : new ArrayList<CreditCard>();

        return User.builder()
                .id(userEntity.getId())
                .login(userEntity.getLogin())
                .password(userEntity.getPassword())
                .email(userEntity.getEmail())
                .completeName(userEntity.getCompleteName())
                .cpf(userEntity.getCpf())
                .birthday(userEntity.getBirthday())
                .phoneNumber(userEntity.getPhoneNumber())
                .balance(userEntity.getBalance())
                .creditCards(creditCards)
                .active(userEntity.getActive())
                .build();
    }
}

package br.com.dio.picpayclone.infrastructure.adapters;

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
        var creditCards = userEntity.creditCards() != null ? userEntity.creditCards().stream()
                .map(CreditCardEntityMapper::toDomainModel)
                .toList() : new ArrayList<CreditCard>();

        return User.builder()
                .id(userEntity.id())
                .login(userEntity.login())
                .password(userEntity.password())
                .email(userEntity.email())
                .completeName(userEntity.completeName())
                .cpf(userEntity.cpf())
                .birthday(userEntity.birthday())
                .phoneNumber(userEntity.phoneNumber())
                .balance(userEntity.balance())
                .creditCards(creditCards)
                .active(userEntity.active())
                .build();
    }
}

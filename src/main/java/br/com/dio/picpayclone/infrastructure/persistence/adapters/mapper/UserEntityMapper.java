package br.com.dio.picpayclone.infrastructure.persistence.adapters.mapper;

import br.com.dio.picpayclone.domain.models.User;
import br.com.dio.picpayclone.infrastructure.persistence.entities.UserEntity;

public class UserEntityMapper {

    public static UserEntity toEntity(User userDomainModel) {
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
                .active(userDomainModel.getActive())
                .build();
    }

    public static User toDomainModel(UserEntity userEntity) {
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
                .active(userEntity.getActive())
                .build();
    }
}

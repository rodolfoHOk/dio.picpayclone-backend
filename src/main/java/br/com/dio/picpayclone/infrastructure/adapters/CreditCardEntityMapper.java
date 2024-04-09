package br.com.dio.picpayclone.infrastructure.adapters;

import br.com.dio.picpayclone.domain.models.CreditCard;
import br.com.dio.picpayclone.domain.models.User;
import br.com.dio.picpayclone.infrastructure.persistence.entities.CreditCardEntity;
import br.com.dio.picpayclone.infrastructure.persistence.entities.UserEntity;

public class CreditCardEntityMapper {

    public static CreditCardEntity toEntity(CreditCard creditCardDomainModel) {
        return CreditCardEntity.builder()
                .id(creditCardDomainModel.getId())
                .number(creditCardDomainModel.getNumber())
                .banner(creditCardDomainModel.getBanner())
                .tokenNumber(creditCardDomainModel.getTokenNumber())
                .user(UserEntity.builder().id(creditCardDomainModel.getUser().getId()).build())
                .build();
    }

    public static CreditCard toDomainModel(CreditCardEntity creditCardEntity) {
        return CreditCard.builder()
                .id(creditCardEntity.id())
                .number(creditCardEntity.number())
                .banner(creditCardEntity.banner())
                .tokenNumber(creditCardEntity.tokenNumber())
                .user(User.builder().id(creditCardEntity.user().id()).build())
                .build();
    }
}

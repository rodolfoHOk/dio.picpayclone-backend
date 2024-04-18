package br.com.dio.picpayclone.infrastructure.persistence.adapters;

import br.com.dio.picpayclone.application.ports.outbound.ICreditCardGateway;
import br.com.dio.picpayclone.domain.models.CreditCard;
import br.com.dio.picpayclone.infrastructure.persistence.mappers.CreditCardEntityMapper;
import br.com.dio.picpayclone.infrastructure.persistence.repositories.CreditCardRepository;

public class CreditCardGateway implements ICreditCardGateway {

    private final CreditCardRepository creditCardRepository;

    public CreditCardGateway(CreditCardRepository creditCardRepository) {
        this.creditCardRepository = creditCardRepository;
    }

    @Override
    public CreditCard save(CreditCard creditCard) {
        var creditCardEntity = CreditCardEntityMapper.toEntity(creditCard);
        var savedCreditCardEntity = creditCardRepository.save(creditCardEntity);
        return CreditCardEntityMapper.toDomainModel(savedCreditCardEntity);
    }
}

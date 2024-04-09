package br.com.dio.picpayclone.domain.services.impl;

import br.com.dio.picpayclone.application.converter.CreditCardConverter;
import br.com.dio.picpayclone.application.dtos.CreditCardDTO;
import br.com.dio.picpayclone.application.ports.outbound.ICreditCardGateway;
import br.com.dio.picpayclone.domain.models.CreditCard;
import br.com.dio.picpayclone.domain.services.ICreditCardService;

public class CreditCardService implements ICreditCardService {

    private final CreditCardConverter creditCardConverter;
    private final ICreditCardGateway creditCardGateway;

    public CreditCardService(CreditCardConverter creditCardConverter, ICreditCardGateway creditCardGateway) {
        this.creditCardConverter = creditCardConverter;
        this.creditCardGateway = creditCardGateway;
    }

    @Override
    public CreditCard save(CreditCardDTO creditCardDTO) {
        var creditCard = creditCardConverter.dtoToEntityConverter(creditCardDTO);
        return creditCardGateway.save(creditCard);
    }
}

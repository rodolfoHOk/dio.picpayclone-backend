package br.com.dio.picpayclone.domain.services.impl;

import br.com.dio.picpayclone.application.ports.outbound.ICreditCardGateway;
import br.com.dio.picpayclone.domain.models.CreditCard;
import br.com.dio.picpayclone.domain.services.ICreditCardService;

public class CreditCardService implements ICreditCardService {

    private final ICreditCardGateway creditCardGateway;

    public CreditCardService(ICreditCardGateway creditCardGateway) {
        this.creditCardGateway = creditCardGateway;
    }

    @Override
    public CreditCard save(CreditCard creditCard) {
        return creditCardGateway.save(creditCard);
    }
}

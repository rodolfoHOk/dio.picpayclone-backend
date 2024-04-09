package br.com.dio.picpayclone.application.ports.outbound;

import br.com.dio.picpayclone.domain.models.CreditCard;

public interface ICreditCardGateway {
    CreditCard save(CreditCard creditCard);
}

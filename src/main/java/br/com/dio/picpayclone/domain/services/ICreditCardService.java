package br.com.dio.picpayclone.domain.services;

import br.com.dio.picpayclone.application.dtos.CreditCardDTO;
import br.com.dio.picpayclone.domain.models.CreditCard;

public interface ICreditCardService {
    CreditCard save(CreditCardDTO creditCardDTO);
}

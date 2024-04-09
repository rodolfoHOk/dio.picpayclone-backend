package br.com.dio.picpayclone.application.dtos;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

public record TransactionDTO(
    String code,
    UserDTO origin,
    UserDTO destination,
    OffsetDateTime dateTime,
    BigDecimal amount,
    CreditCardDTO creditCard,
    Boolean isCreditCard
) {

}

package br.com.dio.picpayclone.application.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TransactionDTO {
    String code;
    UserDTO origin;
    UserDTO destination;
    OffsetDateTime dateTime;
    BigDecimal amount;
    CreditCardDTO creditCard;
    Boolean isCreditCard;
}

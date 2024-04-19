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
    private String code;
    private UserDTO origin;
    private UserDTO destination;
    private OffsetDateTime dateTime;
    private BigDecimal amount;
    private CreditCardDTO creditCard;
    private Boolean isCreditCard;
}

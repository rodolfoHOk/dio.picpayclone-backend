package br.com.dio.picpayclone.application.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TransactionDTO {
    private String code;
    private UserDTO origin;
    private UserDTO destination;
    private String dateTime;
    private BigDecimal amount;
    private CreditCardDTO creditCard;
    private Boolean isCreditCard;
}

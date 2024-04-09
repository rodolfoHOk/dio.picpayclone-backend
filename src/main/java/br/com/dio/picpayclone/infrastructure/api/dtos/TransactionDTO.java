package br.com.dio.picpayclone.infrastructure.api.dtos;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

@JsonInclude(JsonInclude.Include.NON_NULL)
public record TransactionDTO(

    @NotBlank
    String code,

    @NotNull
    UserDTO origin,

    @NotNull
    UserDTO destination,

    @NotNull
    OffsetDateTime dateTime,

    @NotNull
    BigDecimal amount,

    CreditCardDTO creditCard,

    Boolean isCreditCard
) {

}

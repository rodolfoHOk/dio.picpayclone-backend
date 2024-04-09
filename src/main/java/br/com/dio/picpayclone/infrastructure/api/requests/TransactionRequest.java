package br.com.dio.picpayclone.infrastructure.api.requests;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

@JsonInclude(JsonInclude.Include.NON_NULL)
public record TransactionRequest(

    @NotBlank
    String code,

    @NotNull
    UserRequest origin,

    @NotNull
    UserRequest destination,

    @NotNull
    OffsetDateTime dateTime,

    @NotNull
    BigDecimal amount,

    CreditCardRequest creditCard,

    Boolean isCreditCard
) {

}

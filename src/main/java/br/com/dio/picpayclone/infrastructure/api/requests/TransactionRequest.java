package br.com.dio.picpayclone.infrastructure.api.requests;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

@JsonInclude(JsonInclude.Include.NON_NULL)
public record TransactionRequest(

    @NotBlank
    String code,

    @NotNull
    @Valid
    UserRequest origin,

    @NotNull
    @Valid
    UserRequest destination,

    @NotNull
    OffsetDateTime dateTime,

    @NotNull
    @Positive
    BigDecimal amount,

    @Valid
    CreditCardRequest creditCard,

    Boolean isCreditCard
) {

}

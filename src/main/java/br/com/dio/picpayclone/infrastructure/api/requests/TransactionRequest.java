package br.com.dio.picpayclone.infrastructure.api.requests;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
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
@JsonInclude(JsonInclude.Include.NON_NULL)
public class TransactionRequest {

    @NotBlank
    String code;

    @NotNull
    @Valid
    UserRequest origin;

    @NotNull
    @Valid
    UserRequest destination;

    @NotNull
    OffsetDateTime dateTime;

    @NotNull
    @Positive
    BigDecimal amount;

    @Valid
    CreditCardRequest creditCard;

    Boolean isCreditCard;
}

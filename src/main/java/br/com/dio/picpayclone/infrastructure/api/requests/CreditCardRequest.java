package br.com.dio.picpayclone.infrastructure.api.requests;


import br.com.dio.picpayclone.domain.enums.CardBanner;
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@JsonInclude(JsonInclude.Include.NON_NULL)
public record CreditCardRequest(

    @NotBlank
    String banner,

    String number,

    @NotBlank
    String holderName,

    @NotBlank
    String expirationDate,

    @NotBlank
    String securityCode,

    String tokenNumber,

    @NotNull
    @Valid
    UserRequest user,

    Boolean isSaved
) {

}

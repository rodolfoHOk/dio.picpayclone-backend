package br.com.dio.picpayclone.infrastructure.api.dtos;


import br.com.dio.picpayclone.domain.enums.CardBanner;
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@JsonInclude(JsonInclude.Include.NON_NULL)
public record CreditCardDTO(

    @NotBlank
    CardBanner banner,

    String number,

    @NotBlank
    String holderName,

    @NotBlank
    String expirationDate,

    @NotBlank
    String securityCode,

    String tokenNumber,

    @NotNull
    UserDTO user,

    Boolean isSaved
) {

}

package br.com.dio.picpayclone.infrastructure.api.requests;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CreditCardRequest {

    @NotBlank
    String banner;

    String number;

    @NotBlank
    String holderName;

    @NotBlank
    String expirationDate;

    @NotBlank
    String securityCode;

    String tokenNumber;

    @NotNull
    @Valid
    UserRequest user;

    Boolean isSaved;
}

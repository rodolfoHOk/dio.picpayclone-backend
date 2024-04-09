package br.com.dio.picpayclone.infrastructure.api.requests;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.validation.constraints.NotBlank;

import java.math.BigDecimal;
import java.time.LocalDate;

@JsonInclude(JsonInclude.Include.NON_NULL)
public record UserRequest(

        @NotBlank
        String login,

        String password,

        String email,

        String completeName,

        String cpf,

        LocalDate birthday,

        String phoneNumber,

        BigDecimal balance
) {

}

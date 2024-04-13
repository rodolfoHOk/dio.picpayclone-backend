package br.com.dio.picpayclone.infrastructure.api.requests;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserRequest {

        @NotBlank
        String login;

        String password;

        String email;

        String completeName;

        String cpf;

        LocalDate birthday;

        String phoneNumber;

        BigDecimal balance;
}

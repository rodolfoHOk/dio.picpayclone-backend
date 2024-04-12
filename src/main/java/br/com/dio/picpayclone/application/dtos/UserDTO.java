package br.com.dio.picpayclone.application.dtos;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
public class UserDTO {
        String login;
        @JsonIgnore
        String password;
        String email;
        String completeName;
        String cpf;
        LocalDate birthday;
        String phoneNumber;
        BigDecimal balance;
}

package br.com.dio.picpayclone.application.dtos;

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
        private String login;
        private String email;
        private String completeName;
        private String cpf;
        private LocalDate birthday;
        private String phoneNumber;
        private BigDecimal balance;
}

package br.com.dio.picpayclone.application.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {
        private String login;
        private String email;
        private String completeName;
        private String cpf;
        private String birthday;
        private String phoneNumber;
        private BigDecimal balance;
}

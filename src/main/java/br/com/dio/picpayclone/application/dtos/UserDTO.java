package br.com.dio.picpayclone.application.dtos;

import java.math.BigDecimal;
import java.time.LocalDate;

public record UserDTO(
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

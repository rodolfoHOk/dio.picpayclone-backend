package br.com.dio.picpayclone.application.dtos;

import java.math.BigDecimal;

public record BalanceDTO(
    String login,
    BigDecimal balance
) {

}

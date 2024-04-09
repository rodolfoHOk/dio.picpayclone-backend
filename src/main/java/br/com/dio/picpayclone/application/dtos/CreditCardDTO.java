package br.com.dio.picpayclone.application.dtos;


import br.com.dio.picpayclone.domain.enums.CardBanner;

public record CreditCardDTO(
    CardBanner banner,
    String number,
    String holderName,
    String expirationDate,
    String securityCode,
    String tokenNumber,
    UserDTO user,
    Boolean isSaved
) {

}

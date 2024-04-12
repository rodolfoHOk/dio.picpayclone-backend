package br.com.dio.picpayclone.application.dtos;


import br.com.dio.picpayclone.domain.enums.CardBanner;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CreditCardDTO {
    CardBanner banner;
    String number;
    String holderName;
    String expirationDate;
    String securityCode;
    String tokenNumber;
    UserDTO user;
    Boolean isSaved;
}

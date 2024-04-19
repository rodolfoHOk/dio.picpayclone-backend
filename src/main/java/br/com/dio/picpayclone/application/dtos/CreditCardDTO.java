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
    private CardBanner banner;
    private String number;
    private String holderName;
    private String expirationDate;
    private String securityCode;
    private String tokenNumber;
    private UserDTO user;
    private Boolean isSaved;
}

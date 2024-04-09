package br.com.dio.picpayclone.domain.models;

import br.com.dio.picpayclone.domain.enums.CardBanner;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CreditCard {

    private UUID id;

    private String number;

    private CardBanner banner;

    private String tokenNumber;

    private User user;
}

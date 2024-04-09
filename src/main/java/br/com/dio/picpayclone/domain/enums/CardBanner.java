package br.com.dio.picpayclone.domain.enums;

import lombok.Getter;

@Getter
public enum CardBanner {

    VISA("Visa"),
    MASTERCARD("Master Card"),
    ELO("Elo");

    private final String description;

    CardBanner(String description) {
        this.description = description;
    }
}

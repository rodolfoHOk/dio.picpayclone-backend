package br.com.dio.picpayclone.domain.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.UUID;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Transaction {

    private UUID id;

    private String code;

    private User origin;

    private User destination;

    private OffsetDateTime dateTime;

    private BigDecimal amount;
}

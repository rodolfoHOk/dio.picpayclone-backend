package br.com.dio.picpayclone.infrastructure.persistence.entities;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Builder;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.UUID;

@Builder
@Entity
@Table(name = "transactions")
public record TransactionEntity(

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    UUID id,

    @Column(name = "tr_code", nullable = false)
    String code,

    @ManyToOne(cascade = { CascadeType.MERGE }, fetch = FetchType.EAGER)
    @JoinColumn(name = "tr_origin_user", nullable = false)
    UserEntity origin,

    @ManyToOne(cascade = { CascadeType.MERGE }, fetch = FetchType.EAGER)
    @JoinColumn(name = "tr_destination_user", nullable = false)
    UserEntity destination,

    @Column(name = "tr_date_time", nullable = false)
    OffsetDateTime dateTime,

    @Column(name = "tr_amount", nullable = false)
    BigDecimal amount
){

}

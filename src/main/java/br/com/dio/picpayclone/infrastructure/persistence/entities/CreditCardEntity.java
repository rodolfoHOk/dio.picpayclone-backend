package br.com.dio.picpayclone.infrastructure.persistence.entities;


import br.com.dio.picpayclone.domain.enums.CardBanner;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
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
@Entity
@Table(name = "credit_cards")
public class CreditCardEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    UUID id;

    @Column(name = "cc_number", nullable = false)
    String number;

    @Column(name = "cc_banner", nullable = false)
    CardBanner banner;
    @Column(name = "cc_token")
    String tokenNumber;

    @ManyToOne(cascade = {CascadeType.MERGE})
    @JoinColumn(name = "cc_user_id", nullable = false)
    UserEntity user;
}

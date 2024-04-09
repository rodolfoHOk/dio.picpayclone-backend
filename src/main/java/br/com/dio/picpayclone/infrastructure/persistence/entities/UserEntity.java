package br.com.dio.picpayclone.infrastructure.persistence.entities;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Builder;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Builder
@Entity
@Table(name = "users")
public record UserEntity(

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    UUID id,

    @Column(name = "usr_login", nullable = false)
    String login,

    @Column(name = "usr_password", nullable = false)
    String password,

    @Column(name = "usr_email", nullable = false)
    String email,

    @Column(name = "usr_complete_name", nullable = false)
    String completeName,

    @Column(name = "usr_cpf", nullable = false)
    String cpf,

    @Column(name = "usr_birthday", nullable = false)
    LocalDate birthday,

    @Column(name = "usr_phone_number", nullable = false)
    String phoneNumber,

    @Column(name = "usr_balance", nullable = false)
    BigDecimal balance,

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY, cascade = CascadeType.MERGE, orphanRemoval = true)
    List<CreditCardEntity> creditCards,

    @Column(name = "usr_active", nullable = false)
    Boolean active
){

}

package br.com.dio.picpayclone.infrastructure.persistence.entities;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Set;
import java.util.UUID;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "users")
public class UserEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    UUID id;

    @Column(name = "usr_login", nullable = false)
    String login;

    @Column(name = "usr_password", nullable = false)
    String password;

    @Column(name = "usr_email", nullable = false)
    String email;

    @Column(name = "usr_complete_name", nullable = false)
    String completeName;

    @Column(name = "usr_cpf", nullable = false)
    String cpf;

    @Column(name = "usr_birthday", nullable = false)
    LocalDate birthday;

    @Column(name = "usr_phone_number", nullable = false)
    String phoneNumber;

    @Column(name = "usr_balance", nullable = false)
    BigDecimal balance;

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY, cascade = CascadeType.MERGE, orphanRemoval = true)
    List<CreditCardEntity> creditCards;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "users_contacts",
            joinColumns = { @JoinColumn(name = "user_id") }, inverseJoinColumns = { @JoinColumn(name = "contact_id") })
    Set<UserEntity> contacts;

    @Column(name = "usr_active", nullable = false)
    Boolean active;
}

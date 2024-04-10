package br.com.dio.picpayclone.domain.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class User {

    private UUID id;

    private String login;

    private String password;

    private String email;

    private String completeName;

    private String cpf;

    private LocalDate birthday;

    private String phoneNumber;

    private BigDecimal balance;

    private List<CreditCard> creditCards;

    private List<User> contacts;

    private Boolean active;
}

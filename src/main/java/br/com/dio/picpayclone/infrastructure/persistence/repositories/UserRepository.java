package br.com.dio.picpayclone.infrastructure.persistence.repositories;

import br.com.dio.picpayclone.infrastructure.persistence.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.math.BigDecimal;
import java.util.Optional;
import java.util.UUID;

public interface UserRepository extends JpaRepository<UserEntity, UUID> {

    Optional<UserEntity> findByLogin(String login);

    @Modifying
    @Query("update UserEntity u set u.balance = u.balance - ?2 where u.login = ?1")
    void updateDecrementBalance(String login, BigDecimal amount);

    @Modifying
    @Query("update UserEntity u set u.balance = u.balance + ?2 where u.login = ?1")
    void updateIncrementBalance(String login, BigDecimal amount);
}

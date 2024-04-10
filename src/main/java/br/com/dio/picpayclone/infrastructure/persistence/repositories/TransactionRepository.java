package br.com.dio.picpayclone.infrastructure.persistence.repositories;

import br.com.dio.picpayclone.infrastructure.persistence.entities.TransactionEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface TransactionRepository extends JpaRepository<TransactionEntity, UUID> {
    Page<TransactionEntity> findAllByOriginLoginOrDestinationLogin(
            Pageable pageable, String originLogin, String destinationLogin);
}

package br.com.dio.picpayclone.infrastructure.persistence.repositories;

import br.com.dio.picpayclone.infrastructure.persistence.entities.CreditCardEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CreditCardRepository extends JpaRepository<CreditCardEntity, UUID> {

}

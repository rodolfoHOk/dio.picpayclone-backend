package br.com.dio.picpayclone.infrastructure.adapters;

import br.com.dio.picpayclone.domain.models.Transaction;
import br.com.dio.picpayclone.infrastructure.persistence.entities.TransactionEntity;

public class TransactionEntityMapper {

    private static TransactionEntity toEntity(Transaction transactionDomainModel) {
        return TransactionEntity.builder()
                .id(transactionDomainModel.getId())
                .code(transactionDomainModel.getCode())
                .origin(UserEntityMapper.toEntity(transactionDomainModel.getOrigin()))
                .destination(UserEntityMapper.toEntity(transactionDomainModel.getDestination()))
                .dateTime(transactionDomainModel.getDateTime())
                .amount(transactionDomainModel.getAmount())
                .build();
    }

    private static Transaction toDomainModel(TransactionEntity transactionEntity) {
        return Transaction.builder()
                .id(transactionEntity.id())
                .code(transactionEntity.code())
                .origin(UserEntityMapper.toDomainModel(transactionEntity.origin()))
                .destination(UserEntityMapper.toDomainModel(transactionEntity.destination()))
                .dateTime(transactionEntity.dateTime())
                .amount(transactionEntity.amount())
                .build();
    }
}

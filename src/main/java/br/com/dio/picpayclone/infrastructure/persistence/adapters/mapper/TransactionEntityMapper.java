package br.com.dio.picpayclone.infrastructure.persistence.adapters.mapper;

import br.com.dio.picpayclone.domain.models.Transaction;
import br.com.dio.picpayclone.infrastructure.persistence.entities.TransactionEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;

public class TransactionEntityMapper {

    public static TransactionEntity toEntity(Transaction transactionDomainModel) {
        return TransactionEntity.builder()
                .id(transactionDomainModel.getId())
                .code(transactionDomainModel.getCode())
                .origin(UserEntityMapper.toEntity(transactionDomainModel.getOrigin()))
                .destination(UserEntityMapper.toEntity(transactionDomainModel.getDestination()))
                .dateTime(transactionDomainModel.getDateTime())
                .amount(transactionDomainModel.getAmount())
                .build();
    }

    public static Transaction toDomainModel(TransactionEntity transactionEntity) {
        return Transaction.builder()
                .id(transactionEntity.getId())
                .code(transactionEntity.getCode())
                .origin(UserEntityMapper.toDomainModel(transactionEntity.getOrigin()))
                .destination(UserEntityMapper.toDomainModel(transactionEntity.getDestination()))
                .dateTime(transactionEntity.getDateTime())
                .amount(transactionEntity.getAmount())
                .build();
    }

    public static Page<Transaction> toPagedDomainModel(Page<TransactionEntity> pagedTransactionsEntities) {
        return new PageImpl<>(
                pagedTransactionsEntities.getContent().stream().map(TransactionEntityMapper::toDomainModel).toList(),
                pagedTransactionsEntities.getPageable(),
                pagedTransactionsEntities.getTotalElements());
    }
}

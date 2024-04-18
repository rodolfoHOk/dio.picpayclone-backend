package br.com.dio.picpayclone.infrastructure.persistence.mappers;

import br.com.dio.picpayclone.application.dtos.PageDTO;
import br.com.dio.picpayclone.domain.models.Transaction;
import br.com.dio.picpayclone.infrastructure.persistence.entities.TransactionEntity;
import org.springframework.data.domain.Page;

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

    public static PageDTO<Transaction> toPagedDomainModel(Page<TransactionEntity> pagedTransactionsEntities) {
        var pagedTransactions = new PageDTO<Transaction>();
        pagedTransactions.setContent(pagedTransactionsEntities.getContent().stream()
                .map(TransactionEntityMapper::toDomainModel).toList());
        pagedTransactions.setNumber(pagedTransactionsEntities.getNumber());
        pagedTransactions.setSize(pagedTransactionsEntities.getSize());
        pagedTransactions.setTotalPages(pagedTransactionsEntities.getTotalPages());
        pagedTransactions.setTotalElements(pagedTransactionsEntities.getTotalElements());
        return pagedTransactions;
    }
}

package br.com.dio.picpayclone.infrastructure.persistence.adapters;

import br.com.dio.picpayclone.application.dtos.PageDTO;
import br.com.dio.picpayclone.application.dtos.PageableDTO;
import br.com.dio.picpayclone.application.ports.outbound.ITransactionGateway;
import br.com.dio.picpayclone.domain.models.Transaction;
import br.com.dio.picpayclone.infrastructure.persistence.mappers.PageableMapper;
import br.com.dio.picpayclone.infrastructure.persistence.mappers.TransactionEntityMapper;
import br.com.dio.picpayclone.infrastructure.persistence.repositories.TransactionRepository;

public class TransactionGateway implements ITransactionGateway {

    private final TransactionRepository transactionRepository;

    public TransactionGateway(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    @Override
    public Transaction save(Transaction transaction) {
        var transactionEntity = TransactionEntityMapper.toEntity(transaction);
        var savedTransactionEntity = transactionRepository.save(transactionEntity);
        return TransactionEntityMapper.toDomainModel(savedTransactionEntity);
    }

    @Override
    public PageDTO<Transaction> findAllByLogin(PageableDTO pageableDTO, String login) {
        var pageable = PageableMapper.toEntity(pageableDTO);
        var pagedTransactionsEntities = transactionRepository.findAllByOriginLoginOrDestinationLogin(pageable, login, login);
        return TransactionEntityMapper.toPagedDomainModel(pagedTransactionsEntities);
    }
}

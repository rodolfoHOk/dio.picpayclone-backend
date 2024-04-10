package br.com.dio.picpayclone.infrastructure.persistence.adapters;

import br.com.dio.picpayclone.application.ports.outbound.ITransactionGateway;
import br.com.dio.picpayclone.domain.models.Transaction;
import br.com.dio.picpayclone.infrastructure.persistence.adapters.mapper.TransactionEntityMapper;
import br.com.dio.picpayclone.infrastructure.persistence.repositories.TransactionRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

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
    public Page<Transaction> findAllByLogin(Pageable pageable, String login) {
        var pagedTransactionsEntities = transactionRepository.findAllByOriginLoginOrDestinationLogin(pageable, login, login);
        return TransactionEntityMapper.toPagedDomainModel(pagedTransactionsEntities);
    }
}

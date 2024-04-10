package br.com.dio.picpayclone.application.usecases;

import br.com.dio.picpayclone.application.converter.TransactionConverter;
import br.com.dio.picpayclone.application.dtos.TransactionDTO;
import br.com.dio.picpayclone.application.ports.inbound.IListTransactionUseCase;
import br.com.dio.picpayclone.application.ports.outbound.ITransactionGateway;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public class ListTransactionUseCase implements IListTransactionUseCase {

    private final ITransactionGateway transactionGateway;
    private final TransactionConverter transactionConverter;

    public ListTransactionUseCase(ITransactionGateway transactionGateway, TransactionConverter transactionConverter) {
        this.transactionGateway = transactionGateway;
        this.transactionConverter = transactionConverter;
    }

    @Override
    public Page<TransactionDTO> execute(Pageable pageable, String login) {
        var pagedTransactions = transactionGateway.findAllByLogin(pageable, login);
        return transactionConverter.pageEntityToDtoConverter(pagedTransactions);
    }
}

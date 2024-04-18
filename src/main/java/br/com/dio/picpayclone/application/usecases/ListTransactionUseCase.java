package br.com.dio.picpayclone.application.usecases;

import br.com.dio.picpayclone.application.converter.TransactionConverter;
import br.com.dio.picpayclone.application.dtos.PageDTO;
import br.com.dio.picpayclone.application.dtos.PageableDTO;
import br.com.dio.picpayclone.application.dtos.TransactionDTO;
import br.com.dio.picpayclone.application.ports.inbound.IListTransactionUseCase;
import br.com.dio.picpayclone.application.ports.outbound.ITransactionGateway;

public class ListTransactionUseCase implements IListTransactionUseCase {

    private final ITransactionGateway transactionGateway;
    private final TransactionConverter transactionConverter;

    public ListTransactionUseCase(ITransactionGateway transactionGateway, TransactionConverter transactionConverter) {
        this.transactionGateway = transactionGateway;
        this.transactionConverter = transactionConverter;
    }

    @Override
    public PageDTO<TransactionDTO> execute(PageableDTO pageable, String login) {
        var pagedTransactions = transactionGateway.findAllByLogin(pageable, login);
        return transactionConverter.pageEntityToDtoConverter(pagedTransactions);
    }
}

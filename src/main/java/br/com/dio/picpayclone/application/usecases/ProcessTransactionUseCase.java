package br.com.dio.picpayclone.application.usecases;

import br.com.dio.picpayclone.application.converter.TransactionConverter;
import br.com.dio.picpayclone.application.dtos.TransactionDTO;
import br.com.dio.picpayclone.application.ports.inbound.IProcessTransactionUseCase;
import br.com.dio.picpayclone.application.ports.outbound.ITransactionGateway;
import br.com.dio.picpayclone.domain.models.Transaction;
import br.com.dio.picpayclone.domain.services.ICreditCardService;
import br.com.dio.picpayclone.domain.services.IUserService;

public class ProcessTransactionUseCase implements IProcessTransactionUseCase {

    private final TransactionConverter transactionConverter;
    private final IUserService userService;
    private final ICreditCardService creditCardService;
    private final ITransactionGateway transactionGateway;

    public ProcessTransactionUseCase(
            TransactionConverter transactionConverter,
            IUserService userService,
            ICreditCardService creditCardService,
            ITransactionGateway transactionGateway) {
        this.transactionConverter = transactionConverter;
        this.userService = userService;
        this.creditCardService = creditCardService;
        this.transactionGateway = transactionGateway;
    }

    @Override
    public TransactionDTO execute(TransactionDTO transactionDTO) {
        var savedTransaction = save(transactionDTO);
        if (transactionDTO.getIsCreditCard() &&
                transactionDTO.getCreditCard() != null &&
                transactionDTO.getCreditCard().getIsSaved()) {
            creditCardService.save(transactionDTO.getCreditCard());
        }
        userService.updateBalance(savedTransaction, transactionDTO.getIsCreditCard());
        return transactionConverter.entityToDtoConverter(savedTransaction);
    }

    private Transaction save(TransactionDTO transactionDTO) {
        var transaction = transactionConverter.dtoToEntityConverter(transactionDTO);
        userService.validate(transaction.getDestination(), transaction.getOrigin());
        return transactionGateway.save(transaction);
    }
}

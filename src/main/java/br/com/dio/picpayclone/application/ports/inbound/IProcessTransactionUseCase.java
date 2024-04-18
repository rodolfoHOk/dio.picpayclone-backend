package br.com.dio.picpayclone.application.ports.inbound;

import br.com.dio.picpayclone.application.dtos.TransactionDTO;

public interface IProcessTransactionUseCase {

    TransactionDTO execute(TransactionDTO transactionDTO);

}

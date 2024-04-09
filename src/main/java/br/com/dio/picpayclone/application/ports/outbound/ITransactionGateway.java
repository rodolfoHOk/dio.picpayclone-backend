package br.com.dio.picpayclone.application.ports.outbound;

import br.com.dio.picpayclone.domain.models.Transaction;

public interface ITransactionGateway {

    Transaction save(Transaction transaction);
}
